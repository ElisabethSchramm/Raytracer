package gui.view.math.transform;

import gui.view.AView;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RotationXView extends AView {

    private final JTextField angleField = new JTextField(2);

    @Override
    public void setPanel() {
        final JLabel label = new JLabel("RotationX");
        final JLabel angleLabel = new JLabel("Angle:");
        
        Insets insets = new Insets(0, 0, 0, 10);

        addComponent(panel, gbl, label, x, y, width, height, insets);
        addComponent(panel, gbl, angleLabel, 1, y, width, height, insets);
        addComponent(panel, gbl, angleField, 2, y, width, height, insets);
    }

    public JTextField getAngleField() {
        return angleField;
    }

}
