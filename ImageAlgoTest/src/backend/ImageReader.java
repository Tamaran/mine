/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Tamaran
 */
public class ImageReader {
    
    public static BufferedImage readImage(File f) throws IOException{
        BufferedImage in = ImageIO.read(f);
        BufferedImage res = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        res.getGraphics().drawImage(in, 0, 0, null);
        return res;
    }
    
}
