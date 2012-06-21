/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class Sobel extends ImageAlgo{

    

    @Override
    public String getName() {
        return "Sobel";
    }

    @Override
    public float[][] apply(float[][] d) {
        
        float[][] r = new float[d.length-2][d[0].length-2];
        float tmp;
        for(int i = 1; i < d.length-1; i++){
            for(int j = 1; j < d[0].length-1; j++){
                tmp = 0;
                tmp += d[i-1][j-1]; tmp += 2*d[i][j-1]; tmp += d[i+1][j-1];
                tmp -= d[i+1][j+1]; tmp -= 2*d[i][j+1]; tmp -= d[i-1][j+1];
                tmp *= tmp;
                r[i-1][j-1] = tmp;
                tmp = 0;
                tmp += d[i-1][j-1]; tmp += 2*d[i-1][j]; tmp += d[i-1][j+1];
                tmp -= d[i+1][j-1]; tmp -= 2*d[i+1][j]; tmp -= d[i+1][j+1];
                tmp *= tmp;
                r[i-1][j-1] += tmp;
            }
        }
        ImageUtil.correctRange(r);
        return r;
    }
    
}
