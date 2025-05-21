package com.syukri.uaspbo.pokemons;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;

public class MonsterViewer {

    public static void CharacterSelectionView(String ImageSource) throws Exception {
        InputStream input = MonsterViewer.class.getClassLoader().getResourceAsStream(ImageSource);
        BufferedImage img = ImageIO.read(input);
        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 1; y < height; y += 6) {
            for (int x = 1; x < width; x += 6) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                System.out.print(String.format("\u001B[48;2;%d;%d;%dm  ", r, g, b));
            }

            System.out.println("\u001B[0m");
        }
    }

    public static void BattleView(String Monster1, String Monster2) throws Exception {
        InputStream input = MonsterViewer.class.getClassLoader().getResourceAsStream(Monster1);
        InputStream input2 = MonsterViewer.class.getClassLoader().getResourceAsStream("assets/vs.png");
        InputStream input3 = MonsterViewer.class.getClassLoader().getResourceAsStream(Monster2);
        BufferedImage img = ImageIO.read(input);
        BufferedImage img2 = ImageIO.read(input2);
        BufferedImage img3 = ImageIO.read(input3);
        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 1; y < height; y += 6) {
            for (int x = 1; x < width; x += 6) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                System.out.print(String.format("\u001B[48;2;%d;%d;%dm  ", r, g, b));
            }
            for (int x = 1; x < width; x += 6) {
                int rgb = img2.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                System.out.print(String.format("\u001B[48;2;%d;%d;%dm  ", r, g, b));
            }
            for (int x = 1; x < width; x += 6) {
                int rgb = img3.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                System.out.print(String.format("\u001B[48;2;%d;%d;%dm  ", r, g, b));
            }
            System.out.println("\u001B[0m");
        }
    }

    public static void main(String[] args) throws Exception {
        InputStream input = MonsterViewer.class.getClassLoader().getResourceAsStream("assets/Kurikar.png");
        InputStream input2 = MonsterViewer.class.getClassLoader().getResourceAsStream("assets/vs.png");
        InputStream input3 = MonsterViewer.class.getClassLoader().getResourceAsStream("assets/Banyu.png");
        BufferedImage img = ImageIO.read(input);
        BufferedImage img2 = ImageIO.read(input2);
        BufferedImage img3 = ImageIO.read(input3);
        int width = img.getWidth();
        int height = img.getHeight();

        for (int y = 1; y < height; y += 6) {
            for (int x = 1; x < width; x += 6) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                System.out.print(String.format("\u001B[48;2;%d;%d;%dm  ", r, g, b));
            }
            for (int x = 1; x < width; x += 6) {
                int rgb = img2.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                System.out.print(String.format("\u001B[48;2;%d;%d;%dm  ", r, g, b));
            }
            for (int x = 1; x < width; x += 6) {
                int rgb = img3.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                System.out.print(String.format("\u001B[48;2;%d;%d;%dm  ", r, g, b));
            }
            System.out.println("\u001B[0m");
        }
    }
}
