package gui.view.camera;

import gui.view.math.Point3View;
import gui.view.math.Vector3View;
import gui.view.AView;
import java.awt.Insets;
import javax.swing.JLabel;

public abstract class ACameraView extends AView {

    private final JLabel eyePositionLabel = new JLabel("Eye Postion:");
    private final JLabel gazeDirectionLabel = new JLabel("Gaze Direction:");
    private final JLabel upVectorLabel = new JLabel("Up Vector:");
    private final Point3View e;
    private final Vector3View g;
    private final Vector3View t;

    public ACameraView(Point3View e, Vector3View g, Vector3View t) {
        this.e = e;
        this.g = g;
        this.t = t;
    }

    @Override
    public void setPanel() {

        Insets insets = new Insets(0, 0, 0, 5);
        addComponent(panel, gbl, eyePositionLabel, 0, 0, width, height, insets);
        addComponent(panel, gbl, gazeDirectionLabel, 0, 1, width, height, insets);
        addComponent(panel, gbl, upVectorLabel, 0, 2, width, height, insets);
        addComponent(panel, gbl, e.getPanel(), 1, 0, width, height, insets);
        addComponent(panel, gbl, g.getPanel(), 1, 1, width, height, insets);
        addComponent(panel, gbl, t.getPanel(), 1, 2, width, height, insets);
    }
}
