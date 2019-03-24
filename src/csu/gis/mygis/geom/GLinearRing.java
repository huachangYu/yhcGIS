package csu.gis.mygis.geom;

public class GLinearRing extends GLineString{
    
    public GLinearRing(){
        super();
    }
    
    public GLinearRing(GLinearRing ring){
        super(ring);
    }
    
    public double area(){
        double s=0.0;
        for(int i=0;i<_points.size()-1;i++){
            double temp=0.5*(_points.get(i+1).getX()-_points.get(i).getX())*(_points.get(i+1).getY()+_points.get(i).getY());
            s+=temp;
        }
        return s;
    }
    
    @Override
    public Geometry transfer(double a, double b, double d, double e, double f, double h) {
        GLineString lr = new GLinearRing();
        for(int i=0; i<_points.size(); i++){
            lr.append((GPoint) _points.get(i).transfer(a, b, d, e, f, h));         
        }
        return lr;
    }
}
