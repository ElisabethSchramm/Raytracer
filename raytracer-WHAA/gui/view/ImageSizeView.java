package gui.view;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ImageSizeView extends AView {

    //public static final String IMAGESIZE = "IMAGESIZE";
    
    private final JLabel heigthLabel  = new JLabel("Heigth:");
    private final JLabel widthLabel = new JLabel("Width:");
    private final JTextField widthField = new JTextField(3);
    private final JTextField heigthField = new JTextField(3);   

    public ImageSizeView() {
    }

    @Override
    public void setPanel() {

        Insets insets = new Insets(0, 0, 0, 10);

        addComponent(panel, gbl, widthLabel, 0, 0, width, height, insets);
        addComponent(panel, gbl, widthField, 1, 0, width, height, insets);
        addComponent(panel, gbl, heigthLabel, 2, 0, width, height, insets);
        addComponent(panel, gbl, heigthField, 3, 0, width, height, insets);
    }

    public JTextField getWidthField() {
        return widthField;
    }

    public JTextField getHeigthField() {
        return heigthField;
    }   
}
