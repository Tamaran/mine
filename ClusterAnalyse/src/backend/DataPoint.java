/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Tamaran
 */
public class DataPoint {
    
    private double[] data;
    
    public DataPoint(double[] data){
        this.data = data;
    }
    
    public double get(int i){
        return data[i];
    }
}
