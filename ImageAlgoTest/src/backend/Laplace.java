/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class Laplace extends Filter {

    @Override
    protected PointFilterData createPFD() {
        return new PointFilterData() {

            private int i;
            private float[] data = new float[9];

            @Override
            public void addPixel(float f) {
                data[i++] = f;
            }

            @Override
            public float getResult() {
                return data[1] + data[3] - 4 * data[4] + data[5] + data[7];
            }
        };
    }

    @Override
    public String getName() {
        return "Laplace";
    }

    @Override
    protected void onResult(float[][] d) {
        ImageUtil.correctRange(d);
    }
}
