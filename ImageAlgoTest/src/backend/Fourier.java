/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class Fourier extends ImageAlgo {

    @Override
    public String getName() {
        return "Fourier Transformation";
    }

    @Override
    public float[][] apply(float[][] d) {

        Complex[][] data = toComplex(d);
        for (int i = 0; i < data.length; i++) {
            data[i] = internfft1(data[i]);
        }
        data = transpose(data);
        for (int i = 0; i < data.length; i++) {
            data[i] = internfft1(data[i]);
        }
        data = transpose(data);
        float[][] r = toAbs(data);
        ImageUtil.correctRange(r);
        return r;
    }

    private Complex[] internfft1(Complex[] data) {

        if (data.length < 2) {
            return data;
        }
        Complex[] out = new Complex[data.length];
        Complex[] g = divideEven(data);
        Complex[] u = divideOdd(data);
        for (int i = 0; i < u.length; i++) {
            Complex exp = new Complex((float) ((2 * Math.PI * i) / data.length));
            out[i] = g[i].add(u[i].mult(exp));
            out[i + u.length] = g[i].sub(u[i].mult(exp));
        }
        return out;
    }

    private Complex[] divideEven(Complex[] data) {

        Complex[] r = new Complex[data.length / 2];
        for (int i = 0; i < r.length; i++) {
            r[i] = data[2 * i];
        }
        return r;
    }

    private Complex[] divideOdd(Complex[] data) {

        Complex[] r = new Complex[data.length / 2];
        for (int i = 0; i < r.length; i++) {
            r[i] = data[2 * i + 1];
        }
        return r;
    }

    private Complex[][] toComplex(float[][] data) {
        Complex[][] r = new Complex[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                r[i][j] = new Complex(data[i][j], 0);
            }
        }
        return r;
    }

    private Complex[][] transpose(Complex[][] in) {
        Complex[][] out = new Complex[in[0].length][in.length];
        for (int j = 0; j < in[0].length; j++) {
            for (int i = 0; i < in.length; i++) {
                out[j][i] = in[i][j];
            }
        }
        return out;
    }

    private float[][] toAbs(Complex[][] in) {

        float[][] out = new float[in.length][in[0].length];
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                out[i][j] = in[i][j].abs();
            }
        }
        return out;
    }
}
