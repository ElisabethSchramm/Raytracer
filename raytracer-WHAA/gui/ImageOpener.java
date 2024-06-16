package gui;

import static exercises.ExerciseAction.progressbar;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.NAME;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Diese Klasse zeigt ein Bild aus einem Öffnen-Dialog
 *
 * @author Elisabeth Schramm
 */
public class ImageOpener extends AbstractAction {

    private final ImageViewer imageViewer;
    
    public ImageOpener(ImageViewer imageViewer) {
        this.imageViewer = imageViewer;
        putValue(NAME, "Open");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O,
                InputEvent.CTRL_DOWN_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        final JFrame frame = imageViewer.getFrame();
        final ViewCanvas canvas = imageViewer.getContent().getCanvas();

        frame.setResizable(false);
        
        if (Arrays.asList(frame.getContentPane().getComponents()).contains(progressbar)) {
            frame.getContentPane().remove(progressbar);
            imageViewer.getContent().repaint();
        }

        final JFileChooser chooser = new JFileChooser();
        final LabelAccessory accessory = new LabelAccessory(chooser);

        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setMultiSelectionEnabled(false);
        chooser.setCurrentDirectory(null);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("*.png; *.jpg, *", "png", "jpg"));
        chooser.setAccessory(accessory);
        chooser.setVisible(true);

        final int state = chooser.showOpenDialog(frame);

        final File file = chooser.getSelectedFile();
        final String name;

        if (file != null) {
            name = chooser.getSelectedFile().getName();
        } else {
            name = "";
        }

        new SwingWorker<BufferedImage, Void>() {
            @Override
            protected BufferedImage doInBackground() throws IOException {
                return ImageIO.read(file);
            }

            @Override
            protected void done() {
                if (state == JFileChooser.APPROVE_OPTION) {

                    try {
                        canvas.setPreferredSize(new Dimension(get().getWidth(), get().getHeight()));
                        canvas.setImage(get());
                        frame.pack();
                        frame.setTitle(name);
                    } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(ImageOpener.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.execute();
    }

    /**
     * Diese Klasse fügt dem Filechooser eine Bildvorschau hinzu
     */
    public static class LabelAccessory extends JLabel implements PropertyChangeListener {

        private static final int ICON_WIDTH = 80 * 2;
        private static final int ICON_HEIGHT = 25 * 2;

        public LabelAccessory(JFileChooser chooser) {
            setVerticalAlignment(JLabel.CENTER);
            setHorizontalAlignment(JLabel.CENTER);
            chooser.addPropertyChangeListener(this);
            setPreferredSize(new Dimension(ICON_WIDTH, ICON_HEIGHT));
        }

        @Override
        public void propertyChange(PropertyChangeEvent changeEvent) {
            final String changeName = changeEvent.getPropertyName();
            if (changeName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
                File file = (File) changeEvent.getNewValue();
                if (file != null) {
                    ImageIcon icon = new ImageIcon(file.getPath());
                    if (icon.getIconWidth() > ICON_WIDTH) {
                        icon = new ImageIcon(icon.getImage().getScaledInstance(ICON_WIDTH, -1, Image.SCALE_DEFAULT));
                        if (icon.getIconHeight() > ICON_HEIGHT) {
                            icon = new ImageIcon(icon.getImage().getScaledInstance(-1, ICON_HEIGHT, Image.SCALE_DEFAULT));
                        }
                    }
                    setIcon(icon);
                }
            }
        }
    }
}
