package gui.view.light;

import gui.view.ColorView;
import gui.view.math.Point3View;
import java.awt.Insets;
import javax.swing.JLabel;

public class PointLightView extends ALightView {

    private final Point3View position;

    public PointLightView(ColorView color, Point3View position) {
        super(color);
        this.position = position;
    }

    @Override
    public void setPanel() {
        super.setPanel();

        final JLabel positionLabel = new JLabel("Position:");

        Insets insets = new Insets(0, 0, 0, 10);

        addComponent(panel, gbl, positionLabel, 2, y, width, height, insets);
        addComponent(panel, gbl, position.getPanel(), 2, 1, width, height, insets);

    }

}
