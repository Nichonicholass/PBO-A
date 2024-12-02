import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageViewer {
    private JFrame frame;
    private ImagePanel imagePanel;
    private OFImage currentImage;

    public ImageViewer() {
        frame = new JFrame("Image Viewer");
        imagePanel = new ImagePanel();

        setupMenuBar();
        frame.add(imagePanel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void closeImage() {
        if (currentImage != null) {
            currentImage = null;
            imagePanel.setImage(null);
            JOptionPane.showMessageDialog(frame, "Image closed.");
        } else {
            JOptionPane.showMessageDialog(frame, "No image to close.");
        }
    }
    
    private void applyLighterFilter() {
        if (currentImage != null) {
            currentImage.adjustBrightness(1.2); // Faktor > 1 membuat lebih terang
            imagePanel.repaint();
        } else {
            JOptionPane.showMessageDialog(frame, "No image loaded.");
        }
    }
    
    private void applyDarkerFilter() {
        if (currentImage != null) {
            currentImage.adjustBrightness(0.8); // Faktor < 1 membuat lebih gelap
            imagePanel.repaint();
        } else {
            JOptionPane.showMessageDialog(frame, "No image loaded.");
        }
    }
    
    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
    
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem exitItem = new JMenuItem("Exit");
    
        openItem.addActionListener(e -> openImage());
        saveItem.addActionListener(e -> saveImage());
        closeItem.addActionListener(e -> closeImage());
        exitItem.addActionListener(e -> System.exit(0));
    
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);
        fileMenu.add(exitItem);
    
        // Filter menu
        JMenu filterMenu = new JMenu("Filter");
        JMenuItem lighterItem = new JMenuItem("Lighter");
        JMenuItem darkerItem = new JMenuItem("Darker");
    
        lighterItem.addActionListener(e -> applyLighterFilter());
        darkerItem.addActionListener(e -> applyDarkerFilter());
    
        filterMenu.add(lighterItem);
        filterMenu.add(darkerItem);
    
        menuBar.add(fileMenu);
        menuBar.add(filterMenu);
    
        frame.setJMenuBar(menuBar);
    }
    

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                currentImage = ImageFileManager.loadImage(file);
                imagePanel.setImage(currentImage);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Failed to load image: " + ex.getMessage());
            }
        }
    }

    private void saveImage() {
        if (currentImage == null) {
            JOptionPane.showMessageDialog(frame, "No image to save!");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                ImageFileManager.saveImage(currentImage, file, "png");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Failed to save image: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new ImageViewer();
    }
}
