package gui;

import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.NAME;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Klasse zum Speichern-Dialog
 *
 * @author Elisabeth Schramm
 */
public class ImageSaver extends AbstractAction {

    private final ImageViewer imageViewer;
    
    /**
     * Dieser Konstruktor erstellt den Menüeintrag speichern
     * @param imageViewer
     */
    public ImageSaver(ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
        putValue(NAME, "Save");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S,
                InputEvent.CTRL_DOWN_MASK));
    }

    @Override
    public void actionPerformed(final ActionEvent e) {

        final File file;
        final FileNameExtensionFilter filterJpg = new FileNameExtensionFilter("JPG", "jpg", "jpeg");
        final FileNameExtensionFilter filterPng = new FileNameExtensionFilter("PNG", "png");
        String pfad = System.getProperty("user.home");
        final JFileChooser chooser = new JFileChooser(pfad);

        chooser.setFileFilter(filterJpg);
        chooser.setFileFilter(filterPng);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setMultiSelectionEnabled(false);
        chooser.setCurrentDirectory(null);
        chooser.setVisible(true);

        final int result = chooser.showSaveDialog(imageViewer.getFrame());

        if (result == JFileChooser.APPROVE_OPTION) {
            final BufferedImage bufferedImage;
            pfad = chooser.getSelectedFile().toString();
            file = new File(pfad.trim());

           
                bufferedImage = imageViewer.getContent().getCanvas().getBufferedImage();
           
            if (filterJpg.accept(file)) {
                try {
                    ImageIO.write(bufferedImage, "JPEG", file);
                } catch (IOException ex) {
                    System.err.println("Das Bild konnte nicht gespeichert werden\n" + ex);
                }
            } else if (filterPng.accept(file)) {
                try {
                    ImageIO.write(bufferedImage, "PNG", file);
                } catch (IOException ex) {
                    System.err.println("Das Bild konnte nicht gespeichert werden\n" + ex);
                }
            } else {
                System.out.println("Bild kann nicht gespeichert werden, falscher Dateityp");
            }
            chooser.setVisible(false);
        }
    }
}
