package bitmap.transformer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.err.println("Usage: java App input output transform");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];
        String transformName = args[2];
        int width = Integer.parseInt(args[3]);
        int height = Integer.parseInt(args[4]);
        System.out.println(inputFilePath);
        System.out.println(outputFilePath);
        System.out.println(transformName);

        Bitmap bitmap = new Bitmap(inputFilePath);

        switch (transformName) {
            case "transform1":
                bitmap.reverseBlackAndGreen();
                break;
            case "transform2":
                bitmap.flipVertically();
                break;
            case "transform3":
                bitmap.resizeImage(width, height);

                break;
            default:
                System.err.println("Invalid transform name.");
                return;
        }

        bitmap.saveImage(outputFilePath);
        System.out.println("Transform completed. Output saved to " + outputFilePath);
    }
}
