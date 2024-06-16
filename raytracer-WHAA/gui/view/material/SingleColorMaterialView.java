package gui.view.material;

import static gui.GridbagLayout.gbl;
import gui.view.ColorView;
import java.awt.Insets;

public class SingleColorMaterialView extends AMaterialView {

    private final ColorView colorView;

    public SingleColorMaterialView(final ColorView colorView) {
        this.colorView = colorView;
    }

    @Override
    public void setPanel() {
        Insets insets = new Insets(0, 0, 0, 10);
        addComponent(panel, gbl, colorView.getPanel(), 0, 0, width, height, insets);
    }

}
