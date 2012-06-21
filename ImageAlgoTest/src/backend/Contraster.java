/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class Contraster extends ImageAlgo {

    @Override
    public String getName() {
        return "Improve Contrast";
    }

    @Override
    public float[][] apply(float[][] d) {

        float min = Float.MAX_VALUE, max = Float.MIN_VALUE, f;
        float[][] r = new float[d.length][d[0].length];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                if (min > d[i][j]) {
                    min = d[i][j];
                }
                if (max < d[i][j]) {
                    max = d[i][j];
                }
            }
        }
        f = (max-min);
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                r[i][j] = (d[i][j]-min)/f;
            }
        }
        return r;
    }
}
