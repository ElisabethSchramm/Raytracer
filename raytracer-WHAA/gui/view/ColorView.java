package gui.view;

import static gui.GridbagLayout.gbl;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ColorView extends AView {

    public static final String COLOR = "COLOR";

    private final JLabel colorLabel = new JLabel("Color:");
    private final JLabel rLabel = new JLabel("r:");
    private final JLabel gLabel = new JLabel("g:");
    private final JLabel bLabel = new JLabel("b:");
    private final JTextField rField = new JTextField(2);
    private final JTextField gField = new JTextField(2);
    private final JTextField bField = new JTextField(2);

    public ColorView() {
        super();
    }

    @Override
    public void setPanel() {

        int top = 0;
        int left = 0;
        int bottom = 0;

        Insets i = new Insets(top, left, bottom, 15);
        addComponent(panel, gbl, colorLabel, 0, y, width, height, i);

        i = new Insets(top, left, bottom, 5);
        addComponent(panel, gbl, rLabel, 1, y, width, height, i);
        addComponent(panel, gbl, gLabel, 3, y, width, height, i);
        addComponent(panel, gbl, bLabel, 5, y, width, height, i);

        i = new Insets(top, left, bottom, 7);

        addComponent(panel, gbl, rField, 2, y, width, height, i);
        addComponent(panel, gbl, gField, 4, y, width, height, i);
        addComponent(panel, gbl, bField, 6, y, width, height, i);

    }

    public JTextField getrField() {
        return rField;
    }

    public JTextField getgField() {
        return gField;
    }

    public JTextField getbField() {
        return bField;
    }

}
