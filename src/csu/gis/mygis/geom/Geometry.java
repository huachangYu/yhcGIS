package csu.gis.mygis.geom;

import java.awt.geom.Area;

public class Geometry {

    public static final int UNKNOWN = 0;
    public static final int POINT = 1;
    public static final int LINESTRING = 2;
    public static final int POLYGON = 3;
    public static final int MULTIPOINT = 4;
    public static final int MULTILINESTRING = 5;
    public static final int MULTIPOLYGON = 6;
    public static final int GEOMETRYCOLLECTION = 7;

    public static final double EPSINON = 0.0000000001f;
    protected int _type = Geometry.UNKNOWN;

    public Geometry() {
        _type = Geometry.UNKNOWN;
    }

    @Override
    public String toString() {
        return "Geometry";
    }

    public int getType() {
        return _type;
    }

    public String toWKT() {

        return "";
    }

    public String toRawWKT() {
        return "";
    }

    public GEnvelope getEnvelope() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double area(){
        return 0.0;
    }
    
    public Geometry transfer(double a,
            double b,
            double d, double e, double f, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
