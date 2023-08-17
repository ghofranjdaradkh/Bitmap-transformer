package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage; //which represents an image with an accessible buffer of image data.
import java.io.File;
import java.io.IOException;

public class Bitmap {
    // Constructor to read and store bitmap data
    private  int height;
    private  int width;
    private  BufferedImage image;

    public Bitmap(int height, int width, BufferedImage image) {
        this.height = height;
        this.width = width;
        this.image = image;
    }



    public Bitmap(String inputFile) throws IOException {
        try {
            image = ImageIO.read(new File(inputFile));
            if (image != null) {
                height = image.getHeight();
                width = image.getWidth();
                System.out.println(image);
            } else {
                throw new IOException("Failed to read the image");
            }
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            // You might want to handle the exception further or rethrow it if needed.
        }
    }








    // Transform methods

    public  void reverseBlackAndGreen() {
        //used to reverse the colors black and white in the image.
        Color black = new Color(0, 0, 0);// creates a Color object representing the color black.
        Color white = new Color(255, 255, 255);
        Color green = new Color(46, 255, 0);
        Color red= new Color(255, 0, 0);

       // nested loops using x and y iterate through each pixel of the image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = image.getRGB(x, y);

                if (color == black.getRGB()) {//check if the color is black or white using the getRGB() method
                    image.setRGB(x, y, white.getRGB());
                } else if (color == white.getRGB()) {
                    image.setRGB(x, y, red.getRGB());
                }
            }
        }

    }


    public void flipVertically() {
       // iterate through each column x and each row y up to half the height of the image.
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height / 2; y++) {
                int topColor = image.getRGB(x, y);// retrieves the color of the pixel located
                int bottomColor = image.getRGB(x, height - 1 - y);
                //subtracts y from the height and then subtracts 1 to get the correct coordinate,
                // since the indexing starts from 0.
                image.setRGB(x, y, bottomColor);
                image.setRGB(x, height - 1 - y, topColor);
            }
        }
    }
    public void resizeImage(int newWidth, int newHeight) {
        //line creates a new BufferedImage with the specified dimensions and type.
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        //This line draws the original image onto the resized image.
        graphics2D.drawImage(image, 0, 0, newWidth, newHeight, null);
        //disposes of the Graphics2D object.
        graphics2D.dispose();
        image = resizedImage; // Update the instance variable with the resized image
    }

    // Save the modified bitmap image to the specified output file path.

    public void saveImage(String outputFilePath) {
        try {
            if (image != null) {
                File outputFile = new File(outputFilePath);
                ImageIO.write(image, "bmp", outputFile);
                System.out.println("Image saved to " + outputFilePath);
            } else {
                System.err.println("Cannot save image. Image is null.");
            }
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }

}