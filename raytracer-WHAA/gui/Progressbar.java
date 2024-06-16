package gui;


import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class Progressbar extends JProgressBar{
    
    private final int progress;
    private final Border border;
    
    public Progressbar(int width, int height){
        
        progress = 0;
        border = BorderFactory.createTitledBorder("Rendering...");
        setValue(progress);
        setStringPainted(true);        
        setBorder(border);
        setMinimum(0);
	setMaximum(width * height);
    }
   
}
