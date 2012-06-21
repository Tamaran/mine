/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Tamaran
 */
public class ImagePane extends JPanel{
    
    private BufferedImage image;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(image != null)
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }
    
    
    
}
