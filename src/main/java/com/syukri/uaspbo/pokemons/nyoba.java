package com.syukri.uaspbo.pokemons;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
public class nyoba {
    public static void main(String[] args) throws Exception {
        InputStream input = nyoba.class.getClassLoader().getResourceAsStream("assets/Kurikar.png");
        BufferedImage img = ImageIO.read(input);
        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 1; y < height; y+=6) {
            for (int x = 1; x < width; x+=6) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                System.out.print(String.format("\u001B[48;2;%d;%d;%dm  ", r, g, b));
            }
            System.out.println("\u001B[0m");
        }
    }
}
