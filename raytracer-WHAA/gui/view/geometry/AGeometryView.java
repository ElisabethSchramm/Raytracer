package gui.view.geometry;

import gui.view.AView;
import gui.view.material.AMaterialView;
import java.awt.Insets;

public class AGeometryView extends AView{

    private final AMaterialView material;

    public AGeometryView(AMaterialView material) {
        this.material = material;
        
    }
    
    
    @Override
    public void setPanel() {

        if(material !=null){
        Insets insets = new Insets(0, 0, 0, 5);
        addComponent(panel, gbl, material.getPanel(), x, y, width, height, insets);
        }
    }
    
}
