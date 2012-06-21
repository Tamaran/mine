/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public abstract class Filter extends ImageAlgo{

    @Override
    public float[][] apply(float[][] d) {
        float[][] r = new float[d.length-2][d[0].length-2];
        for(int i = 0; i < r.length; i++)
            for(int j = 0; j < r[0].length; j++){
                PointFilterData pfd = createPFD();
                pfd.addPixel(d[i][j]);
                pfd.addPixel(d[i+1][j]);
                pfd.addPixel(d[i+2][j]);
                pfd.addPixel(d[i][j+1]);
                pfd.addPixel(d[i+1][j+1]);
                pfd.addPixel(d[i+2][j+1]);
                pfd.addPixel(d[i][j+2]);
                pfd.addPixel(d[i+1][j+2]);
                pfd.addPixel(d[i+2][j+2]);
                r[i][j] = pfd.getResult();
            }
        onResult(r);
        return r;
    }
    
    abstract protected PointFilterData createPFD();
    abstract protected void onResult(float[][] d);
}
