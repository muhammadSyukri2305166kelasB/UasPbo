/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.syukri.uaspbo;

/**
 *
 * @author HP
 */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageToAscii {
    public static void main(String[] args) throws Exception {
        BufferedImage image = ImageIO.read(new File("E:\\Sms4\\PBO\\Projek Netbeans\\UasPbo\\src\\main\\java\\com\\syukri\\uaspbo\\kerenmon.png"));
        
        String asciiChars = "@#%xo;:,. "; // dari gelap ke terang
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y += 8) { // langkahi baris agar tidak terlalu panjang
            for (int x = 0; x < width; x += 4) {
                int pixel = image.getRGB(x, y);
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                int gray = (r + g + b) / 3;
                int index = gray * (asciiChars.length() - 1) / 255;
                System.out.print(asciiChars.charAt(index));
            }
            System.out.println();
        }
    }
}

