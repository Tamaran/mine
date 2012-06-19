/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class AvgFilter extends Filter{

    @Override
    protected PointFilterData createPFD() {
        return new PointFilterData() {

            private float r;
            
            @Override
            public void addPixel(float f) {
                r += f;
            }

            @Override
            public float getResult() {
                return r/9;
            }
        };
    }

    @Override
    protected void onResult(float[][] d) {}

    @Override
    public String getName() {
        return "Average Filter";
    }
    
}
