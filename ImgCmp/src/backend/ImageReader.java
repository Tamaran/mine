/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.util.CalculationMidStep;
import backend.util.ImageConverter;
import backend.fft.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import log.Log;

/**
 *
 * @author Tamaran
 */
public class ImageReader extends CalculationMidStep<FileData, ImageData> {
    
    private static final int HIST_DIV = 10, IMG_SIZE = 128;

    @Override
    public ImageData midPerform(FileData in) {
        try{
            Complex[][] ft = ImageUtil.image2complex(getRescaled(ImageIO.read(new ByteArrayInputStream(in.getData()))));
            new Fft().fft2(ft);
            ComplexHist h = new ComplexHist(ft, HIST_DIV);
            return new ImageData(in.getFile(), h);
        }catch(Exception e){
            Log.error(e);
        }
        return null;
    }

    private BufferedImage getRescaled(BufferedImage src){
        BufferedImage out = new BufferedImage(IMG_SIZE, IMG_SIZE, BufferedImage.TYPE_BYTE_GRAY);
        out.getGraphics().drawImage(src, 0, 0, IMG_SIZE, IMG_SIZE, null);
        return out;
    }
    
}
