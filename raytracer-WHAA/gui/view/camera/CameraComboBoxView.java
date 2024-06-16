package gui.view.camera;

import gui.controller.camera.ACameraController;
import gui.view.AView;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Set;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

public class CameraComboBoxView extends AView {

    private final JPanel cards = new JPanel(new CardLayout());
    private final JComboBox<ACameraController> camerasComboBox;
    private Set<ACameraController> controller;
    private DefaultListCellRenderer renderer;

    public CameraComboBoxView(Set<ACameraController> controller) {

        this.controller = controller;

        camerasComboBox = new JComboBox();

        setRenderer(controller);

        addItems(controller);

    }

    public final void setRenderer(Set<ACameraController> controller) {
        renderer = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                setOpaque(true);
                if (value instanceof ACameraController) {

                    if (isSelected) {
                        setBackground(list.getSelectionBackground());
                        setForeground(list.getSelectionForeground());
                    } else {
                        setBackground(list.getBackground());
                        setForeground(list.getForeground());
                    }
                    setText(((ACameraController) value).getModel().getName());

                }
                return this;
            }

        };
        camerasComboBox.setRenderer(renderer);
    }

    public final void addItems(Set<ACameraController> controller) {
        for (ACameraController c : controller) {
            camerasComboBox.addItem(c);
        }
    }

    private void setCards() {
        for (ACameraController c : controller) {
            cards.add(c.getView().getPanel(), c.getModel().getName());
        }
    }

    @Override
    public void setPanel() {

        setCards();

        addComponent(panel, gbl, camerasComboBox, 0, 0, width, height, insets);
        addComponent(panel, gbl, cards, 1, 0, width, 4, insets);

    }

    public JPanel getCards() {
        return cards;
    }

    public JComboBox getCamerasComboBox() {
        return camerasComboBox;
    }

}
