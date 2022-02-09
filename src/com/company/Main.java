package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BufferedImage image;
        File file;
        char[][] tab ;
        try {
            image = ImageIO.read(new File("img.jpg"));
            int width = image.getWidth();
            int height = image.getHeight();
            tab = new char[height][width];
            for(int i=0; i<tab.length;i++){
                for(int j=0; j<tab[0].length; j++){
                    tab[i][j] = ' ';
                }
            }

            for(int i=0; i<height; i++) {
                for(int j=0; j<width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    if (c.getRed() >= 0 && c.getRed() <= 10 && c.getGreen() >= 0 && c.getGreen() <= 10 && c.getBlue() >= 0 && c.getBlue() <= 10){
                        tab[i][j] = '■';
                    }else{
                        if(c.getRed() >= 10 && c.getRed() <= 100 && c.getGreen() >= 10 && c.getGreen() <= 100 && c.getBlue() >= 10 && c.getBlue() <= 100){
                            tab[i][j] = '▒';
                        }
                    }
                }
            }
            for(int i=0; i<tab.length;i++){
                for(int j=0; j<tab[0].length; j++){
                    System.out.print(tab[i][j]);
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println(e);
            System.err.println("erreur");
        }

    }
}
