/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.fft;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Tamaran
 */
public class ImageUtil {

    private static final int MAX = 0xFFFFFFFF;
    private static final int BYTEMASK = 0x000000FF;

    public static BufferedImage absolute(BufferedImage src, int t) {
        BufferedImage out = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        int w = src.getWidth();
        int h = src.getHeight();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                out.setRGB(j, i, (isBrighter(src.getRGB(j, i), t) ? MAX : 0));
            }
        }
        return out;
    }

    public static int[][] getData(BufferedImage img) {
        int[][] out = new int[img.getHeight()][img.getWidth()];
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                out[i][j] = img.getRGB(j, i);
            }
        }
        return out;
    }
    
    public static BufferedImage createImage(int[][] data){
        BufferedImage out = new BufferedImage(data[0].length, data.length, BufferedImage.TYPE_BYTE_GRAY);
        setData(out, data);
        return out;
    }

    public static void setData(BufferedImage img, int[][] data) {

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                img.setRGB(j, i, data[i][j]);
            }
        }

    }

    public static boolean isBrighter(int a, int b) {
        return (a & BYTEMASK) > (b & BYTEMASK);
    }

    public static double[][] image2doubles(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        double[][] out = new double[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                out[i][j] = img.getRGB(j, i);
            }
        }
        return out;
    }

    public static Complex[][] image2complex(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        Complex[][] out = new Complex[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                out[i][j] = new Complex(img.getRGB(j, i), 0);
            }
        }
        return out;
    }

    public static BufferedImage complex2image(Complex[][] in) {
        BufferedImage img = new BufferedImage(in[0].length, in.length, BufferedImage.TYPE_BYTE_GRAY);
        for(int i = 0; i < in.length; i++)
            for(int j = 0; j < in[0].length; j++)
                img.setRGB(j, i, (int)in[i][j].abs());
        return img;
    }
}
