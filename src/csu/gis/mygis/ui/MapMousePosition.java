package csu.gis.mygis.ui;

import csu.gis.mygis.geom.GPoint;
import javax.swing.JLabel;

public class MapMousePosition extends JLabel{
    public void setLabel(GPoint pt){
        String str=String.format("¾­¶È%1$.9f  Î³¶È%2$.9f",pt.getX(),pt.getY());
        setText(str);
    }
}
