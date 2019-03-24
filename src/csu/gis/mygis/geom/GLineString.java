package csu.gis.mygis.geom;

import java.util.ArrayList;

public class GLineString extends Geometry {

    protected ArrayList<GPoint> _points = new ArrayList<GPoint>();

    public GLineString() {
        _type = Geometry.LINESTRING;
    }

    public GLineString(GLineString ls) {
        _type = Geometry.LINESTRING;
        for (GPoint pt : ls._points) {
            _points.add(new GPoint(pt));
        }
    }

    public GLineString append(GPoint pt) {
        _points.add(new GPoint(pt));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LINESTRING ");
        builder.append(toRawString());
        return builder.toString();
    }

    public String toRawString() {
        StringBuilder builder = new StringBuilder();
        builder.append(_points.size());
        for (GPoint pt : _points) {
            builder.append(" ").append(pt.toRawString());
        }
        return builder.toString();
    }

    @Override
    public String toRawWKT(){
        
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for(int i=0; i<_points.size(); i++){
            if(i>0){
                builder.append(",");
            }
            builder.append(_points.get(i).toRawWKT());
        }
        builder.append(")");
        return builder.toString();
    }
    
    @Override
    public String toWKT(){
        return "LINESTRING" + toRawWKT();
    }

    @Override
    public GEnvelope getEnvelope() {
        GEnvelope ev = _points.get(0).getEnvelope();
        for(int i=1; i<_points.size();i++){
            ev.combine(_points.get(i).getEnvelope());
        }
        return ev;
    }

    @Override
    public Geometry transfer(double a, double b, double d, double e, double f, double h) {
        GLineString ls = new GLineString();
        for(int i=0; i<_points.size(); i++){
            ls.append((GPoint) _points.get(i).transfer(a, b, d, e, f, h));         
        }
        return ls;
    }

    public int numPoints() {
        return _points.size();
    }

    public GPoint getPoint(int i) {
        return _points.get(i);
    }
}
