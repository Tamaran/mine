/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.fft;

import backend.fft.Complex;

/**
 *
 * @author Tamaran
 */
public class ComplexHist {
    
    private Complex[][] classes;
    
    public ComplexHist(Complex[][] in, int size){
        classes = new Complex[size+1][size+1];
        double[][] real = new double[classes.length][classes[0].length];
        double[][] img = new double[classes.length][classes[0].length];
        int[][] count = new int[classes.length][classes[0].length];
        int w = in.length/size;
        for(int i = 0; i < in.length; i++)
            for(int j = 0; j < in[0].length; j++){
                int x = j/w;
                int y = i/w;
                count[y][x]++;
                real[y][x] += in[y][x].getReal();
                img[y][x] += in[y][x].getImg();
            }
        for(int i = 0; i < classes.length; i++)
            for(int j = 0; j < classes[0].length; j++)
                if(count[i][j] != 0){
                    real[i][j] /= count[i][j];
                    img[i][j] /= count[i][j];
                    classes[i][j] = new Complex(real[i][j], img[i][j]);
                }else
                    classes[i][j] = new Complex(0,0);
    }

    public int getWidth(){
        return classes[0].length;
    }
    
    
    public int getHeight(){
        return classes.length;
    }
    
    public Complex getComplexClass(int x, int y){
        return classes[y][x];
    }
}
