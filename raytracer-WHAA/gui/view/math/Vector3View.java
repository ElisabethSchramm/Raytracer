package gui.view.math;

import gui.view.AView;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vector3View extends AView {

    private final JTextField xField = new JTextField(2);
    private final JTextField yField = new JTextField(2);
    private final JTextField zField = new JTextField(2);

    public Vector3View() {
    }

    @Override
    public void setPanel() {

        final JLabel xLabel = new JLabel("x:");
        final JLabel yLabel = new JLabel("y:");
        final JLabel zLabel = new JLabel("z:");

        Insets insets = new Insets(0, 0, 0, 5);

        addComponent(panel, gbl, xLabel, 0, y, width, height, insets);
        addComponent(panel, gbl, xField, 1, y, width, height, insets);
        addComponent(panel, gbl, yLabel, 2, y, width, height, insets);
        addComponent(panel, gbl, yField, 3, y, width, height, insets);
        addComponent(panel, gbl, zLabel, 4, y, width, height, insets);
        addComponent(panel, gbl, zField, 5, y, width, height, insets);

    }

    public JTextField getxField() {
        return xField;
    }

    public JTextField getyField() {
        return yField;
    }

    public JTextField getzField() {
        return zField;
    }

}
