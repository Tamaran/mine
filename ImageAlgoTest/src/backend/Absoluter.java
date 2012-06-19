/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class Absoluter extends ImageAlgo{

    @Override
    public String getName() {
        return "To Absolute";
    }

    @Override
    public float[][] apply(float[][] d) {
        float m = getMean(d);
        for(int i = 0; i < d.length; i++)
            for(int j = 0; j < d[0].length; j++)
                d[i][j] = (d[i][j] > m?1:0);
        return d;
    }
    
    private float getMean(float[][] d){
        float r = 0;
        for(int i = 0; i < d.length; i++)
            for(int j = 0; j < d[0].length; j++)
                r += d[i][j];
        r /= d.length*d[0].length;
        return r;
    }
    
}
