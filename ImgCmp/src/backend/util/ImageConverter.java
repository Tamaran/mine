/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.util;

import java.awt.image.BufferedImage;

/**
 *
 * @author Tamaran
 */
public class ImageConverter {
    
    private BufferedImage src;
    private int type;

    public ImageConverter(BufferedImage src, int type) {
        this.src = src;
        this.type = type;
    }
    
    public BufferedImage getResult(){
        BufferedImage out = new BufferedImage(src.getWidth(), src.getHeight(), type);
        out.getGraphics().drawImage(src, 0, 0, null);
        return out;
    }
    
}
