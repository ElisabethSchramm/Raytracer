package gui;

import javax.swing.JPanel;

public abstract class AComponents extends GridbagLayout {

    protected JPanel panel;

    public AComponents() {
        this.panel = new JPanel(gbl);
    }

    public JPanel getPanel(){
        return panel;
    }
    
    public abstract void setPanel();
}
