package gui.view.math.transform;

import static gui.GridbagLayout.gbl;
import gui.view.AView;
import gui.view.math.Vector3View;
import java.awt.Insets;
import javax.swing.JLabel;

public class TranslationView extends AView {

    private final Vector3View view;

    public TranslationView(Vector3View view) {
        this.view = view;
    }

    @Override
    public void setPanel() {
        
        final JLabel label = new JLabel("Translation");
        
        Insets insets = new Insets(0, 0, 0, 10);
        addComponent(panel, gbl, label, x, y, width, height, insets);
        addComponent(panel, gbl, view.getPanel(), 1, y, width, height, insets);
    }

}
