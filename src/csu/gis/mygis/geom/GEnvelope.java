package csu.gis.mygis.geom;

public class GEnvelope {

    public GEnvelope() {
    }

    public GEnvelope(double _minX, double _minY, double _maxX, double _maxY) {
        this._minX = _minX;
        this._minY = _minY;
        this._maxX = _maxX;
        this._maxY = _maxY;
    }

    public void combine(GEnvelope ev){
        _minX = Math.min(_minX, ev._minX);
        _minY = Math.min(_minY, ev._minY);
        _maxX = Math.max(_maxX, ev._maxX);
        _maxY = Math.max(_maxY, ev._maxY);
        
    }
    
    public double getMaxX() {
        return _maxX;
    }

    public double getMaxY() {
        return _maxY;
    }

    public double getMinX() {
        return _minX;
    }

    public double getMinY() {
        return _minY;
    }

    public void setMaxX(double _maxX) {
        this._maxX = _maxX;
    }

    public void setMaxY(double _maxY) {
        this._maxY = _maxY;
    }

    public void setMinX(double _minX) {
        this._minX = _minX;
    }

    public void setMinY(double _minY) {
        this._minY = _minY;
    }
    
    protected double _minX,_minY,_maxX,_maxY;

    public GPoint getCenter() {
        return new GPoint((_minX+_maxX)*0.5,(_minY+_maxY)*0.5);
    }

    public double getWidth() {
        return _maxX - _minX;
    }
    
    public double getHeight(){
        return _maxY - _minY;
    }
}
