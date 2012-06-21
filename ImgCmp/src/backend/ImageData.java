/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.fft.ComplexHist;
import java.io.File;

/**
 *
 * @author Tamaran
 */
public class ImageData {
    
    private final File file;
    private final ComplexHist histogram;

    public ImageData(File file, ComplexHist histogram) {
        this.file = file;
        this.histogram = histogram;
    }

    public File getFile() {
        return file;
    }

    public ComplexHist getHistogram() {
        return histogram;
    }

    
    
    
}
