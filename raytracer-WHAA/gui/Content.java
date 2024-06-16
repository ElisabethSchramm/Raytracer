package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Content extends JPanel {

    /**
     * Canvas auf dem gezeichnet wird
     */
    private final ViewCanvas canvas;

    public Content(ImageViewer imageViewer) {   
        
       setLayout(new BorderLayout());
       canvas = new ViewCanvas();
       add(canvas, BorderLayout.NORTH);
       final Border border = BorderFactory.createLineBorder(Color.GRAY, 3);
       setBorder(border);
    }

    public ViewCanvas getCanvas() {
        return canvas;
    }
}
