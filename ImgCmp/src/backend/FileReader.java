/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.util.CalculationStep;
import log.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 *
 * @author Tamaran
 */
public class FileReader extends CalculationStep<File> {
    
    private ImageReader imageReader;

    public FileReader(List<File> l) {
        super(l);
    }

    public FileReader() {
    }

    
    @Override
    public void perform(File f) {
        FileChannel in = null;
        ByteBuffer buf;
        try {
            in = new FileInputStream(f).getChannel();
            buf = ByteBuffer.allocate((int)f.length());
            in.read(buf);
            imageReader.add(new FileData(f, buf.array()));
        } catch (Exception e) {
            Log.error(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {}
            }
        }
    }

    public ImageReader getImageReader() {
        return imageReader;
    }

    public void setImageReader(ImageReader imageReader) {
        this.imageReader = imageReader;
    }
    
    
}
