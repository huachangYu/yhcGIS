package csu.gis.mygis.geom;

public class GPoint extends Geometry {

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public void setX(double _x) {
        this._x = _x;
    }

    public void setY(double _y) {
        this._y = _y;
    }

    protected double _x = 0.0;
    protected double _y = 0.0;

    public GPoint() {
        _type = Geometry.POINT;
        _x = 0.0;
        _y = 0.0;
    }

    public GPoint(double x, double y) {
        _type = Geometry.POINT;
        _x = x;
        _y = y;
    }

    public GPoint(GPoint pt) {
        _type = Geometry.POINT;
        _x = pt._x;
        _y = pt._y;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("POINT ").append(toRawString());
        return builder.toString();
    }

    public String toRawString() {
        return String.format("%1$.15f %2$.15f", getX(), getY());
    }

    @Override
    public String toRawWKT() {
        return toRawString();
    }

    @Override
    public String toWKT() {
        return "POINT(" + toRawWKT() + ")";
    }

    @Override
    public GEnvelope getEnvelope() {
        return new GEnvelope(
                _x - Geometry.EPSINON,
                _y - Geometry.EPSINON,
                _x + Geometry.EPSINON,
                _y + Geometry.EPSINON);
    }

    @Override
    public Geometry transfer(
            double a,
            double b,
            double d, double e, double f, double h) {
        double x = a * _x + b * _y + d;
        double y = e * _x + f * _y + h;
        return new GPoint(x, y);
    }
    
    public Geometry detransfer(double a,
            double b,
            double d, double e, double f, double h){
        double x=(f*_x-b*_y-d*f+b*h)/(a*f-e*b);
        double y=(e*_x-a*_y-d*e+a*h)/(b*e-a*f);
        return new GPoint(x, y);
    }

}
