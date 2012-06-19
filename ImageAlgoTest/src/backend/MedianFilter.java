/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Arrays;

/**
 *
 * @author Tamaran
 */
public class MedianFilter extends Filter{

    @Override
    protected PointFilterData createPFD() {
        return new PointFilterData() {
            
            private float[] data = new float[9];
            private int i;

            @Override
            public void addPixel(float f) {
                data[i++] = f;
            }

            @Override
            public float getResult() {
                Arrays.sort(data);
                return data[5];
            }
        };
    }

    @Override
    protected void onResult(float[][] d) {}

    @Override
    public String getName() {
        return "Median Filter";
    }
    
}
