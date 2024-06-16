package gui.view.material;

import gui.view.ColorView;
import java.awt.Insets;

public class LambertMaterialView extends AMaterialView {

    private final ColorView colorView;

    public LambertMaterialView(final ColorView colorView) {
        this.colorView = colorView;
    }

    @Override
    public void setPanel() {
        Insets insets = new Insets(0, 0, 0, 10);
        addComponent(panel, gbl, colorView.getPanel(), x, y, width, height, insets);
    }
}
