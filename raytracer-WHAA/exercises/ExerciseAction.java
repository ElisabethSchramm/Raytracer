package exercises;

import static javax.swing.Action.NAME;
import gui.ImageViewer;
import gui.Progressbar;
import gui.ViewCanvas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.AbstractAction;
import javax.swing.JFrame;


public class ExerciseAction extends AbstractAction {

    private final int width = 640;
    private final int height = 480;   
    private final String name;
    private final ImageViewer imageViewer;    
    private final AExercise scene;
    /**
     * Progressbar für das Frame
     */
    public static Progressbar progressbar;    
    

    public ExerciseAction(final String name,final  AExercise scene, final ImageViewer imageViewer) {
        
        this.name = name;
        this.scene = scene;
        this.imageViewer= imageViewer;
        putValue(NAME, this.name);
        progressbar = new Progressbar(width,height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        final JFrame frame = imageViewer.getFrame();
        final ViewCanvas canvas = imageViewer.getContent().getCanvas();
        
        frame.setResizable(false);      
        frame.setTitle(name);          
        canvas.setPreferredSize(new Dimension(width, height)); 
        if (!Arrays.asList(frame.getContentPane().getComponents()).contains(progressbar)) {            
            frame.getContentPane().add(progressbar, BorderLayout.SOUTH);
        }
        frame.pack();
        scene.setScene(name); 
    }
}
