/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class DiagMatrix {
    
    private double[] data;
    private int size;
    
    public DiagMatrix(int size){
        data = new double[size];
    }
    
    public double get(int i, int j){
        return data[toIndex(i, j)];
    }
    
    public void set(int i, int j, double v){
        data[toIndex(i, j)] = v;
    }

    private int toIndex(int i, int j){
        int tmp;
        if(i > j){
            tmp = i;
            i = j;
            j = tmp;
        }
        i--;
        return (size-i)*(2*size-i)/2+j-i;
    }
}
