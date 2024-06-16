package gui;

import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.NAME;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class ImageViewer{

    /**
     * Das JFrame diese Fensters
     */
    private final JFrame frame;
    /**
     * Menubar für das Frame
     */
    private final Menubar mainMenubar;
    /**
     * Jpanel, dass als Contentpane gesetzt wird
     */
    private final Content content;
    
    public ImageViewer(){
        
        frame = new JFrame();  
        
        frame.setLayout(new FlowLayout());
        
        mainMenubar = new Menubar(this); 
        
        content = new Content(this);

        setStartPosition();

        frame.setContentPane(content);                       
        
        frame.setJMenuBar(mainMenubar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(640, 480);

        frame.setVisible(true);
    }

    /**
     * Setzt den Frame in die Mitte des Bildschirms
     */
    private void setStartPosition() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final Point frameLocation = new Point();

        frameLocation.x = (screen.width - frame.getSize().width) / 2;
        frameLocation.y = (screen.height - frame.getSize().height) / 2;
        frame.setLocation(frameLocation.x, frameLocation.y);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Content getContent() {
        return content;
    }

    /**
     * Diese Klasse Beendet die Application
     */
    public static class ImageExit extends AbstractAction {

        public ImageExit() {
            putValue(NAME, "Exit");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X,
                    InputEvent.CTRL_DOWN_MASK));
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }   
}
