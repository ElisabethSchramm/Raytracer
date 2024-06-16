package gui.view.light;

import gui.view.ColorView;
import gui.view.math.Vector3View;
import java.awt.Insets;
import javax.swing.JLabel;

public class DirectionLightView extends ALightView {

    private final Vector3View direction;

    public DirectionLightView(ColorView color, Vector3View direction) {
        super(color);
        this.direction = direction;
    }

    @Override
    public void setPanel() {
        super.setPanel();

        final JLabel directionLabel = new JLabel("Direction:");

        Insets insets = new Insets(0, 0, 0, 10);

        addComponent(panel, gbl, directionLabel, 2, y, width, height, insets);
        addComponent(panel, gbl, direction.getPanel(), 2, 1, width, height, insets);

    }

}
