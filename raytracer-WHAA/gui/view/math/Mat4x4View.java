package gui.view.math;

import gui.view.AView;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Mat4x4View extends AView {

    private final JTextField m11Field = new JTextField(2);
    private final JTextField m12Field = new JTextField(2);
    private final JTextField m13Field = new JTextField(2);
    private final JTextField m14Field = new JTextField(2);
    private final JTextField m21Field = new JTextField(2);
    private final JTextField m22Field = new JTextField(2);
    private final JTextField m23Field = new JTextField(2);
    private final JTextField m24Field = new JTextField(2);
    private final JTextField m31Field = new JTextField(2);
    private final JTextField m32Field = new JTextField(2);
    private final JTextField m33Field = new JTextField(2);
    private final JTextField m34Field = new JTextField(2);
    private final JTextField m41Field = new JTextField(2);
    private final JTextField m42Field = new JTextField(2);
    private final JTextField m43Field = new JTextField(2);
    private final JTextField m44Field = new JTextField(2);

    @Override
    public void setPanel() {

        final JLabel m11Label = new JLabel("m11:");
        final JLabel m12Label = new JLabel("m12:");
        final JLabel m13Label = new JLabel("m13:");
        final JLabel m14Label = new JLabel("m14:");
        final JLabel m21Label = new JLabel("m21:");
        final JLabel m22Label = new JLabel("m22:");
        final JLabel m23Label = new JLabel("m23:");
        final JLabel m24Label = new JLabel("m24:");
        final JLabel m31Label = new JLabel("m31:");
        final JLabel m32Label = new JLabel("m32:");
        final JLabel m33Label = new JLabel("m33:");
        final JLabel m34Label = new JLabel("m34:");
        final JLabel m41Label = new JLabel("m41:");
        final JLabel m42Label = new JLabel("m42:");
        final JLabel m43Label = new JLabel("m43:");
        final JLabel m44Label = new JLabel("m44:");

        Insets insets = new Insets(0, 0, 0, 5);

        addComponent(panel, gbl, m11Label, 0, y, width, height, insets);
        addComponent(panel, gbl, m11Field, 1, y, width, height, insets);
        addComponent(panel, gbl, m12Label, 2, y, width, height, insets);
        addComponent(panel, gbl, m12Field, 3, y, width, height, insets);
        addComponent(panel, gbl, m13Label, 4, y, width, height, insets);
        addComponent(panel, gbl, m13Field, 5, y, width, height, insets);
        addComponent(panel, gbl, m14Label, 6, y, width, height, insets);
        addComponent(panel, gbl, m14Field, 7, y, width, height, insets);

        int y = 1;
        addComponent(panel, gbl, m21Label, 0, y, width, height, insets);
        addComponent(panel, gbl, m21Field, 1, y, width, height, insets);
        addComponent(panel, gbl, m22Label, 2, y, width, height, insets);
        addComponent(panel, gbl, m22Field, 3, y, width, height, insets);
        addComponent(panel, gbl, m23Label, 4, y, width, height, insets);
        addComponent(panel, gbl, m23Field, 5, y, width, height, insets);
        addComponent(panel, gbl, m24Label, 6, y, width, height, insets);
        addComponent(panel, gbl, m24Field, 7, y, width, height, insets);

        y = 2;
        addComponent(panel, gbl, m31Label, 0, y, width, height, insets);
        addComponent(panel, gbl, m31Field, 1, y, width, height, insets);
        addComponent(panel, gbl, m32Label, 2, y, width, height, insets);
        addComponent(panel, gbl, m32Field, 3, y, width, height, insets);
        addComponent(panel, gbl, m33Label, 4, y, width, height, insets);
        addComponent(panel, gbl, m33Field, 5, y, width, height, insets);
        addComponent(panel, gbl, m34Label, 6, y, width, height, insets);
        addComponent(panel, gbl, m34Field, 7, y, width, height, insets);

        y = 3;
        addComponent(panel, gbl, m41Label, 0, y, width, height, insets);
        addComponent(panel, gbl, m41Field, 1, y, width, height, insets);
        addComponent(panel, gbl, m42Label, 2, y, width, height, insets);
        addComponent(panel, gbl, m42Field, 3, y, width, height, insets);
        addComponent(panel, gbl, m43Label, 4, y, width, height, insets);
        addComponent(panel, gbl, m43Field, 5, y, width, height, insets);
        addComponent(panel, gbl, m44Label, 6, y, width, height, insets);
        addComponent(panel, gbl, m44Field, 7, y, width, height, insets);

    }

    public JTextField getM11Field() {
        return m11Field;
    }

    public JTextField getM12Field() {
        return m12Field;
    }

    public JTextField getM13Field() {
        return m13Field;
    }

    public JTextField getM14Field() {
        return m14Field;
    }

    public JTextField getM21Field() {
        return m21Field;
    }

    public JTextField getM22Field() {
        return m22Field;
    }

    public JTextField getM23Field() {
        return m23Field;
    }

    public JTextField getM24Field() {
        return m24Field;
    }

    public JTextField getM31Field() {
        return m31Field;
    }

    public JTextField getM32Field() {
        return m32Field;
    }

    public JTextField getM33Field() {
        return m33Field;
    }

    public JTextField getM34Field() {
        return m34Field;
    }

    public JTextField getM41Field() {
        return m41Field;
    }

    public JTextField getM42Field() {
        return m42Field;
    }

    public JTextField getM43Field() {
        return m43Field;
    }

    public JTextField getM44Field() {
        return m44Field;
    }

}
