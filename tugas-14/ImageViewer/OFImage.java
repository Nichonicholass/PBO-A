import java.awt.image.BufferedImage;

public class OFImage extends BufferedImage {
    public OFImage(BufferedImage image) {
        super(image.getColorModel(),
              image.copyData(null),
              image.isAlphaPremultiplied(),
              null);
    }

    // Contoh metode untuk manipulasi pixel
    public void applyGrayscaleFilter() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                int rgb = getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                int gray = (r + g + b) / 3;
                setRGB(x, y, (gray << 16) | (gray << 8) | gray);
            }
        }
    }

    public void clearImage() {
        int width = getWidth();
        int height = getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                setRGB(x, y, 0xFFFFFFFF); // Set to white
            }
        }
    }

    public void adjustBrightness(double factor) {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                int rgb = getRGB(x, y);
    
                int r = (int) Math.min(255, ((rgb >> 16) & 0xFF) * factor);
                int g = (int) Math.min(255, ((rgb >> 8) & 0xFF) * factor);
                int b = (int) Math.min(255, (rgb & 0xFF) * factor);
    
                setRGB(x, y, (r << 16) | (g << 8) | b);
            }
        }
    }
}
