/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.fft;

/**
 *
 * @author Tamaran
 */
public class Complex {
    
    private double real, img;

    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }
    
    public Complex(double omega){
        real = Math.cos(omega);
        img = Math.sin(omega);
    }
    
    public Complex add(Complex c){
        return new Complex(real+c.real, img+c.img);
    }
    
    public Complex sub(Complex c){
        return new Complex(real-c.real, img-c.img);
    }
    
    public Complex mult(Complex c){
        return new Complex(real*c.real-img*c.img, real*c.img+img*c.real);
    }
    
    public double abs(){
        return Math.sqrt(real*real+img*img);
    }
    
    public static Complex[] fromDoubles(double[] data){
        Complex[] out = new Complex[data.length];
        for(int i = 0; i < out.length; i++)
            out[i] = new Complex(data[i],0);
        return out;
    }
    
    public static Complex[][] fromDoubles(double[][] data){
        Complex[][] out = new Complex[data.length][data[0].length];
        for(int i = 0; i < data.length; i++)
            for(int j = 0; j < data[0].length; j++)
                out[i][j] = new Complex(data[i][j],0);
        return out;
    }
    
    public static double[] abs(Complex[] in){
        double[] out = new double[in.length];
        for(int i = 0; i < out.length; i++)
            out[i] = in[i].abs();
        return out;
    }

    @Override
    public String toString() {
        return "Complex{" + "real=" + real + ", img=" + img + '}';
    }

    public double getImg() {
        return img;
    }

    public double getReal() {
        return real;
    }
    
    
}
