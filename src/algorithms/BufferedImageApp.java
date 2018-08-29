package algorithms;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.IntStream;

public class BufferedImageApp {
    public static void main(String[] args) {
        CannyEdgeDetector detector = new CannyEdgeDetector();
        detector.setLowThreshold(0.5f);
        detector.setHighThreshold(1f);
        //apply it to an image
        try {
            Image image = ImageIO.read(new File("D:/Downloads/kumamon.png"));

            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);

            bufferedImage.getGraphics().drawImage(image, 0, 0, null);

            detector.setSourceImage(bufferedImage);
            detector.process();
            BufferedImage edges = detector.getEdgesImage();
            edges.createGraphics();

            File outputfile = new File("D:/Downloads/kumamon_edges.jpg");
            ImageIO.write(edges, "jpg", outputfile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
