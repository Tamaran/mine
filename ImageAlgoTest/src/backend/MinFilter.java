/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class MinFilter extends Filter{

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
                float r = Float.MAX_VALUE;
                for(float f : data)
                    if(f < r)
                        r = f;
                return r;
            }
        };
    }

    @Override
    protected void onResult(float[][] d) {}

    @Override
    public String getName() {
        return "Minimum Filter";
    }
    
}
