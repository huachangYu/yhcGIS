package csu.gis.mygis.geom;

import java.util.ArrayList;

public class GPolygon extends Geometry {

    public ArrayList<GLinearRing> _rings = new ArrayList<>();

    public GPolygon() {
        _type = Geometry.POLYGON;
    }

    public GPolygon(GPolygon pg) {
        _type = Geometry.POLYGON;
    }

    public GPolygon(GLinearRing ring) {
        _type = Geometry.POLYGON;
        _rings.add(ring);
    }

    public void add(GLinearRing ring) {
        _rings.add(ring);
    }

    @Override
    public String toString() {
        return "POLYGON " + toRawString();
    }

    public String toRawString() {
        StringBuilder builder = new StringBuilder();

        builder.append(_rings.size());
        for (int i = 0; i < _rings.size(); i++) {
            GLinearRing ring = _rings.get(i);
            builder.append(" ").append(ring.toRawString());

        }
        return builder.toString();
    }
    
    @Override
    public String toWKT(){
        return "POLYGON"+toRawWKT();
    }

    @Override
    public String toRawWKT(){
        StringBuilder builder = new StringBuilder();

        builder.append("(");
        for (int i = 0; i < _rings.size(); i++) {
            if(i>0){
                builder.append(",");
            }
            GLinearRing ring = _rings.get(i);
            builder.append(ring.toRawWKT());
        }
        builder.append(")");
        return builder.toString();
    }
    
    
    @Override
    public GEnvelope getEnvelope() {
        GEnvelope ev = _rings.get(0).getEnvelope();
        for(int i=1; i<_rings.size();i++){
            ev.combine(_rings.get(i).getEnvelope());
        }
        return ev;
    }
    
    public double area(){
        double s=0.0;
        for(int i=0;i<_rings.size();i++){
            s+=_rings.get(i).area();
        }
        return Math.abs(s);
    }
    
    @Override
    public Geometry transfer(double a, double b, double d, double e, double f, double h) {
        GPolygon pg = new GPolygon();
        for(int i=0; i<_rings.size(); i++){
            pg.add((GLinearRing) _rings.get(i).transfer(a, b, d, e, f, h));         
        }
        return pg;
    }
}
