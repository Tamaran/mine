/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import backend.*;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;

/**
 *
 * @author Tamaran
 */
public class MainFrameController {
    
    private MainFrame frame;

    public MainFrameController(MainFrame frame) {
        this.frame = frame;
    }

    public void loadPressed() {
        try{
            JFileChooser c = new JFileChooser();
            if(c.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION){
                BufferedImage img = ImageReader.readImage(c.getSelectedFile());
                frame.getLeft().setImage(img);
                frame.getRight().setImage(img);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public void resetPressed() {
        frame.getRight().setImage(frame.getLeft().getImage());
    }
    
    public void performAlgo(ImageAlgo a){
        float[][] data = ImageUtil.getData(frame.getRight().getImage());
        BufferedImage res = ImageUtil.toImage(a.apply(data));
        frame.getRight().setImage(res);
    }
    
}
