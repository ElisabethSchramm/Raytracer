package gui.view.camera;

import gui.view.math.Point3View;
import gui.view.math.Vector3View;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OrthographicCameraView extends ACameraView {

    private final JTextField scaleField = new JTextField(2);

    public OrthographicCameraView(Point3View e, Vector3View g, Vector3View t) {
        super(e, g, t);
    }

    @Override
    public void setPanel() {

        super.setPanel();
        final JLabel scaleLabel = new JLabel("Scale Factor:");
        
        Insets insets = new Insets(0, 0, 0, 10);

        addComponent(panel, gbl, scaleLabel, 4, 0, width, height, insets);
        addComponent(panel, gbl, scaleField, 4, 1, width, height, insets);

    }

    public JTextField getScaleField() {
        return scaleField;
    }
}
