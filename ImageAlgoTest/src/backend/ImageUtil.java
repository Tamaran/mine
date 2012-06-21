/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.awt.Color;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tamaran
 */
public class ImageUtil {

    public static float[][] getData(BufferedImage image) {
        float[][] data = new float[image.getHeight()][image.getWidth()];
        long l;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = ((float) new Color(image.getRGB(j, i)).getBlue()) / 255;
            }
        }
        return data;
    }

    public static BufferedImage toImage(float[][] data) {
        BufferedImage img = new BufferedImage(data[0].length, data.length, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                Color c = new Color(data[i][j], data[i][j], data[i][j]);
                img.setRGB(j, i, c.getRGB());
            }
        }
        return img;
    }

    public static void correctRange(float[][] data) {

        float min = Float.MAX_VALUE, max = Float.MIN_VALUE, d;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (min > data[i][j]) {
                    min = data[i][j];
                }
                if (max < data[i][j]) {
                    max = data[i][j];
                }
            }
        }
        d = (max-min);
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[0].length; j++){
                data[i][j] = (data[i][j]-min)/d;
            }
        }
    }
}
