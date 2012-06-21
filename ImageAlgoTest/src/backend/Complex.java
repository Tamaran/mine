/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class Complex {

    private float real, img;

    public Complex(float omega) {
        real = (float) Math.cos(omega);
        img = (float) Math.sin(omega);
    }

    public Complex(float real, float img) {
        this.real = real;
        this.img = img;
    }

    public Complex add(Complex o) {
        return new Complex(real + o.real, img + o.img);
    }

    public Complex mult(Complex o) {
        return new Complex(real * o.real - img * o.img, real * o.img + img * o.real);
    }
    
    public float abs(){
        return (float)Math.sqrt(real*real+img*img);
    }

    public Complex sub(Complex o) {
        return new Complex(real - o.real, img - o.img);
    }

    public float getImg() {
        return img;
    }

    public float getReal() {
        return real;
    }
}
