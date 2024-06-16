package gui.view.light;

import gui.view.ColorView;
import gui.view.math.Point3View;
import gui.view.math.Vector3View;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SpotLightView extends ALightView {

    private final JTextField halfAngleField = new JTextField(2);
    private final Point3View position;
    private final Vector3View direction;

    public SpotLightView(ColorView color, Point3View position, Vector3View direction) {
        super(color);
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void setPanel() {
        super.setPanel();

        final JLabel positionLabel = new JLabel("Position:");
        final JLabel directionLabel = new JLabel("Direction:");
        final JLabel halfAngleLabel = new JLabel("HalfAngle:");

        Insets insets = new Insets(0, 0, 0, 10);

        addComponent(panel, gbl, positionLabel, 2, y, width, height, insets);
        addComponent(panel, gbl, position.getPanel(), 2, 1, width, height, insets);

        addComponent(panel, gbl, directionLabel, 3, y, width, height, insets);
        addComponent(panel, gbl, direction.getPanel(), 3, 1, width, height, insets);

        addComponent(panel, gbl, halfAngleLabel, 4, y, width, height, insets);
        addComponent(panel, gbl, halfAngleField, 4, 2, width, height, insets);

    }

    public JTextField getHalfAngleField() {
        return halfAngleField;
    }

}
