/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.fft.ComplexHist;

/**
 *
 * @author Tamaran
 */
public class ImageComparator {
    
    private static final double MAX_ALLOWED_DIST = 1000000000;
    
    public boolean compare(ImageData ida, ImageData idb){
        ComplexHist a = ida.getHistogram(),
                    b = idb.getHistogram();
        double sum = 0;
        int w = a.getWidth();
        int h = a.getHeight();
        for(int i = 0; i < h; i++)
            for(int j = 0;j < w; j++){
                double d = b.getComplexClass(j, i).sub(a.getComplexClass(j, i)).abs();
                sum += d*d;
                if(sum > MAX_ALLOWED_DIST)
                    return false;
            }
        return true;
    }
    
}
