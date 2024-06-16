package gui.view.light;

import gui.view.AView;
import gui.view.ColorView;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public abstract class ALightView extends AView {

    private ButtonGroup CastShadowsGroup = new ButtonGroup();

    private ColorView color;

    public ALightView(ColorView color) {
        this.color = color;

    }

    @Override
    public void setPanel() {
        final JRadioButton trueButton = new JRadioButton("true");
        final JRadioButton falseButton = new JRadioButton("false");
        trueButton.setActionCommand("true");
        falseButton.setActionCommand("false");

        CastShadowsGroup.add(trueButton);
        CastShadowsGroup.add(falseButton);

        final JLabel colorLabel = new JLabel("Color:");
        final JLabel castShadowsLabel = new JLabel("Cast Shadows:");

        Insets insets = new Insets(0, 0, 0, 5);

        addComponent(panel, gbl, colorLabel, x, y, width, height, insets);
        addComponent(panel, gbl, color.getPanel(), x, 1, width, height, insets);

        addComponent(panel, gbl, castShadowsLabel, 1, 0, width, height, insets);
        addComponent(panel, gbl, trueButton, 1, 2, width, height, insets);;
        addComponent(panel, gbl, falseButton, 1, 3, width, height, insets);

    }

    public ButtonGroup getCastShadowsGroup() {
        return CastShadowsGroup;
    }

}
