package gui.view.camera;

import gui.view.math.Point3View;
import gui.view.math.Vector3View;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PerspectiveCameraView extends ACameraView {

    private final JTextField angleField = new JTextField(2);

    public PerspectiveCameraView(Point3View e, Vector3View g, Vector3View t) {
        super(e, g, t);
    }

    @Override
    public void setPanel() {

        super.setPanel();
        final JLabel angleLabel = new JLabel("Angle: ");

        Insets insets = new Insets(0, 0, 0, 10);

        addComponent(panel, gbl, angleLabel, 4, 0, width, height, insets);
        addComponent(panel, gbl, angleField, 4, 1, width, height, insets);

    }

    public JTextField getAngleField() {
        return angleField;
    }
}
