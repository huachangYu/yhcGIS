package csu.gis.mygis.test;

import csu.gis.mygis.geom.Geometry;
import csu.gis.mygis.geom.GeometryFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestGeometry {

    public static void main(String[] args) {

        String path = "D:\\biancheng\\java\\yhcMyGIS\\";

//      TestGeometry.testRead(path + "city.mygis");
//      TestGeometry.testRead(path + "railway.mygis");
        TestGeometry.testRead(path + "county.mygis");
//      System.out.println("Welcome to MyGIS!");

    }

    public static void testRead(String filename) {
        InputStreamReader reader = null;
        try {
            File file = new File(filename);
            reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferreader = new BufferedReader(reader);
            String line;
            while ((line = bufferreader.readLine()) != null) {
                Geometry geo = GeometryFactory.decode(line);
                System.out.println(geo.area());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestGeometry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestGeometry.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(TestGeometry.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
