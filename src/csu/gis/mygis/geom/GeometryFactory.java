package csu.gis.mygis.geom;

public class GeometryFactory {
    
    public static Geometry decode(String mygisstr){
        String type = mygisstr.substring(0, mygisstr.indexOf(" "));
        Geometry geo = null;
        if(type.equals("POINT")){
            geo = GeometryFactory.decodePoint(mygisstr);
        }else if(type.equals("LINESTRING")){
            geo = GeometryFactory.decodeLineString(mygisstr);
        }else if(type.equals("POLYGON")){
            geo = GeometryFactory.decodePolygon(mygisstr);
        }
        return geo;
    }

    private static Geometry decodePoint(String mygisstr) {
        String[] data = mygisstr.split(" ");
        double x = Double.valueOf(data[1]);
        double y = Double.valueOf(data[2]);
        return new GPoint(x,y);
    }

    private static Geometry decodeLineString(String mygisstr) {
        String[] data = mygisstr.split(" ");
        int p = 1;
        int npoints = Integer.valueOf(data[p]); 
        p ++;
        GLineString ls = new GLineString();
        for(int i=0;i<npoints; i++){
            double x = Double.valueOf(data[p++]);
            double y = Double.valueOf(data[p++]);
            ls.append(new GPoint(x,y));
        }
        return ls;
    }

    private static Geometry decodePolygon(String mygisstr) {
        String[] data = mygisstr.split(" ");
        int p = 1;
        int nrings = Integer.valueOf(data[p++]);
        GPolygon pg = new GPolygon();
        for(int i=0; i<nrings; i++){
            GLinearRing ring = new GLinearRing();
            int npoints = Integer.valueOf(data[p++]);
            for( int j=0; j<npoints; j++){
                double x = Double.valueOf(data[p++]);
                double y = Double.valueOf(data[p++]);
                ring.append(new GPoint(x,y));
            } 
            pg.add(ring);
        }
        return pg;
    }
}
