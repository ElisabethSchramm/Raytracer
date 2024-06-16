package gui.view.geometry;
import java.util.ArrayList;
import gui.view.math.transform.TransformView;

public class NodeView extends AGeometryView {

    private final ArrayList<AGeometryView> geometries;
    private final TransformView transform;

    public NodeView(ArrayList<AGeometryView> geometries, TransformView transform) {
        super(null);
        this.geometries = geometries;
        this.transform = transform;
    }

    @Override
    public void setPanel() {
        super.setPanel();
        int x = 0;
        for (AGeometryView v : geometries) {
            addComponent(panel, gbl, v.getPanel(), x, y, width, height, insets);
            x++;
        }
        addComponent(panel, gbl, transform.getPanel(), x, y, width, height, insets);

    }

}
