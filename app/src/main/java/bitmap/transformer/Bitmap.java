package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    // Constructor to read and store bitmap data

    private static int hight;
    private static int width;

    private static BufferedImage image;





    public Bitmap(String inputFile)throws IOException {

        image = ImageIO.read(new File(inputFile));
        hight = image.getHeight();
        width = image.getWidth();
        System.out.println(image);

    }

    // Transform methods

    public  void reverseBlackAndGreen() {

        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        Color green = new Color(46, 255, 0);
        Color red= new Color(255, 0, 0);


        for (int x = 0; x < width; x++) {
            for (int y = 0; y < hight; y++) {
                int color = image.getRGB(x, y);

                if (color == black.getRGB()) {
                    image.setRGB(x, y, white.getRGB());
                } else if (color == white.getRGB()) {
                    image.setRGB(x, y, red.getRGB());
                }
            }
        }

    }


    public void flipVertically() {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < hight / 2; y++) {
                int topColor = image.getRGB(x, y);
                int bottomColor = image.getRGB(x, hight - 1 - y);
                image.setRGB(x, y, bottomColor);
                image.setRGB(x, hight - 1 - y, topColor);
            }
        }
    }
    public void resizeImage(int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, newWidth, newHeight, null);
        graphics2D.dispose();
        image = resizedImage; // Update the instance variable with the resized image
    }

    // Save the modified bitmap

    public void saveImage(String outputFilePath) {
        try {
            File outputFile = new File(outputFilePath);
            ImageIO.write(image, "bmp", outputFile);
            System.out.println("Image saved to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }
}


