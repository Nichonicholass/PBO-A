import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFileManager {
    public static OFImage loadImage(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        return new OFImage(image);
    }

    public static void saveImage(OFImage image, File file, String format) throws IOException {
        ImageIO.write(image, format, file);
    }
}
