package gui.view.material;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import gui.view.ColorView;

public class PhongMaterialView extends AMaterialView {

    private final ColorView difuseView;
    private final ColorView spectacularView;

    private final JTextField exponentField = new JTextField(2);

    public PhongMaterialView(ColorView difuseView, ColorView spectacularView) {
        this.difuseView = difuseView;
        this.spectacularView = spectacularView;
    }

    @Override
    public void setPanel() {
        
        final JLabel exponentLabel = new JLabel("Exponent:");
        
        Insets insets = new Insets(0, 0, 0, 10);

        addComponent(panel, gbl, exponentLabel, 0, 0, width, height, insets);
        addComponent(panel, gbl, exponentField, 0, 1, width, height, insets);
        addComponent(panel, gbl, difuseView.getPanel(), 0, 2, width, height, insets);
        addComponent(panel, gbl, spectacularView.getPanel(), 0, 3, width, height, insets);

    }

    public JTextField getExponentField() {
        return exponentField;
    }

}
