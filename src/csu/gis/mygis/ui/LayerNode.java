package csu.gis.mygis.ui;

import csu.gis.mygis.map.GLayer;
import javax.swing.tree.DefaultMutableTreeNode;

public class LayerNode extends DefaultMutableTreeNode{
    protected GLayer _layer=null;
    
    public LayerNode(){
        super();
    }
    
    public LayerNode(GLayer layer){
        super(layer.getPrefixName());
        _layer = layer;
    }
   
    public GLayer getLayer(){
        return _layer;
    }
}
