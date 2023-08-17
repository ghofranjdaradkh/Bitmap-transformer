package bitmap.transformer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class BitmapTest {

    @Test
    public void testReverseBlackAndGreen() throws IOException {
        Bitmap bitmap = new Bitmap("input.jpg"); // Provide your input image file

        // Test reverseBlackAndGreen transformation
        bitmap.reverseBlackAndGreen();

        // TODO: Add assertions to verify the transformation results
        // For example, you can check specific pixels in the modified image
    }

    @Test
    public void testFlipVertically() throws IOException {
        Bitmap bitmap = new Bitmap("input.jpg"); // Provide your input image file

        // Test flipVertically transformation
        bitmap.flipVertically();

        // TODO: Add assertions to verify the transformation results
        // For example, you can check if the top and bottom pixels are swapped
    }

    @Test
    public void testResizeImage() throws IOException {
        Bitmap bitmap = new Bitmap("input.jpg"); // Provide your input image file

        int newWidth = 400; // Provide a new width for resizing
        int newHeight = 300; // Provide a new height for resizing

        // Test resizeImage method
        bitmap.resizeImage(newWidth, newHeight);


    }

    @Test
    public void testSaveImage() throws IOException {
        Bitmap bitmap = new Bitmap("input.jpg"); // Provide your input image file

        String outputFilePath = "output.bmp"; // Provide an output file path


        bitmap.saveImage(outputFilePath);


    }
}