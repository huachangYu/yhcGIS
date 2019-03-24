package csu.gis.mygis.ui;

import csu.gis.mygis.map.GLayer;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ContentControl extends JTree implements MouseListener {

    private MapControl _mapControl = null;
    
    private DefaultMutableTreeNode _root = null;
    private DefaultTreeModel _model = null;
    private PopupMenu _contextMenu = null;
    private MenuItem _setVisibleMenu = null;

    public ContentControl() {
        super();
        _model = (DefaultTreeModel) this.getModel();
        _root = new DefaultMutableTreeNode("图层");
        _model.setRoot(_root);

        _contextMenu = new PopupMenu();
        this.add(_contextMenu);

        _setVisibleMenu = new MenuItem("可视/不可视");
        _setVisibleMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentControl.this.onSetVisible();
            }
        });
        _contextMenu.add(_setVisibleMenu);
        this.addMouseListener(this);
    }

    public void addLayer(GLayer layer) {
        LayerNode node = new LayerNode(layer);
        _root.add(node);
        _model.reload(_root);
    }

    public void setBuddy(MapControl Control) {
        _mapControl = Control;
    }

    protected void onSetVisible(){
        DefaultMutableTreeNode node
                = (DefaultMutableTreeNode) getLastSelectedPathComponent();
        if (node == null) {
            return;
        }

        if (node instanceof LayerNode ) {
            LayerNode ld = (LayerNode)node;
            GLayer layer= ld.getLayer();
            layer.setVisible(!layer.getVisible());
            if(this._mapControl != null){
                this._mapControl.repaint();
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        DefaultMutableTreeNode node
                = (DefaultMutableTreeNode) getLastSelectedPathComponent();
        if (node == null) {
            return;
        }

        if (node instanceof LayerNode
                && e.getButton() == MouseEvent.BUTTON3) {
            _contextMenu.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
