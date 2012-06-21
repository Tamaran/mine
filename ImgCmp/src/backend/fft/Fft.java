/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.fft;

import java.util.Arrays;

/**
 *
 * @author Tamaran
 */
public class Fft {

    public Complex[] fft1(Complex[] in) {

        Complex[] g, u;
        Complex exp;

        if (in.length == 1) {
            return in;
        }

        g = fft1(divideEven(in));
        u = fft1(divideOdd(in));
        for (int k = 0; k < in.length / 2; k++) {
            exp = new Complex(-2 * Math.PI * k / in.length);
            in[k] = g[k].add(exp.mult(u[k]));
            in[k + in.length / 2] = g[k].sub(exp.mult(u[k]));
        }
        return in;
    }

    public void fft2(Complex[][] in) {
        for (int i = 0; i < in.length; i++) {
            fft1(in[i]);
        }
        for(int i = 0; i < in[0].length; i++){
            setCol(in, fft1(cpyCol(in, i)), i);
        }
    }

    private static Complex[] divideEven(Complex[] in) {
        Complex[] out = new Complex[in.length / 2];
        for (int i = 0; i < out.length; i++) {
            out[i] = in[2 * i];
        }
        return out;
    }

    private static Complex[] divideOdd(Complex[] in) {
        Complex[] out = new Complex[in.length / 2];
        for (int i = 0; i < out.length; i++) {
            out[i] = in[2 * i + 1];
        }
        return out;
    }

    private static Complex[] cpyRow(Complex[][] in, int r) {
        Complex[] out = new Complex[in[0].length];
        for (int i = 0; i < out.length; i++) {
            out[i] = in[r][i];
        }
        return out;
    }

    private static Complex[] cpyCol(Complex[][] in, int c) {
        Complex[] out = new Complex[in.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = in[i][c];
        }
        return out;
    }

    private static void setCol(Complex[][] arr, Complex[] data, int c) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][c] = data[i];
        }
    }

    private static void setRow(Complex[][] arr, Complex[] data, int r) {
        for (int i = 0; i < arr[0].length; i++) {
            arr[r][i] = data[i];
        }
    }

    private static Complex[][] trans(Complex[][] in) {
        Complex[][] out = new Complex[in[0].length][in.length];
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                out[j][i] = in[i][j];
            }
        }
        return out;
    }
}
