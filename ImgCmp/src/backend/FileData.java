/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.File;

/**
 *
 * @author Tamaran
 */
public class FileData {
    
    private File file;
    private byte[] data;

    public FileData(File file, byte[] data) {
        this.file = file;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public File getFile() {
        return file;
    }
    
    
}
