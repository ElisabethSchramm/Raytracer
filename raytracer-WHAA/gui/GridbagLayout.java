package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class GridbagLayout {

    public static final GridBagLayout gbl = new GridBagLayout();
    public final GridBagLayout gblElements = new GridBagLayout();
    public final GridBagConstraints gbc = new GridBagConstraints();
    public final int width = 1;
    public final int height = 1;
    public final int x = 0;
    public final int y = 0;
    public final Insets insets = new Insets(0, 0, 0, 0);

    /**
     * Fügt einem Container mit Gridbaglayout Componenten hinzu.
     *
     * @param cont
     * @param gbl
     * @param c
     * @param x
     * @param y
     * @param width
     * @param height
     * @param insets
     */
    public void addComponent(Container cont,
            GridBagLayout gbl,
            Component c,
            int x, int y,
            int width, int height,
            Insets insets) {

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = insets;
        gbc.anchor = GridBagConstraints.CENTER;
        gbl.setConstraints(c, gbc);
        cont.add(c);
    }
}
