package csu.gis.mygis.map;

import csu.gis.mygis.geom.GEnvelope;
import csu.gis.mygis.geom.Geometry;
import csu.gis.mygis.geom.GeometryFactory;
import csu.gis.mygis.test.TestGeometry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GLayer {

    protected ArrayList<Geometry> _geometries = new ArrayList<>();
    private boolean _visible = true;
    private String _fileName = null;

    public GLayer() {
    }

    public GLayer(String filename) {
        readGeometries(filename);
        _fileName = filename;
    }

    public Geometry get(int i) {
        return _geometries.get(i);
    }

    public int numGeometries() {
        return _geometries.size();
    }

    private void readGeometries(String filename) {

        InputStreamReader reader = null;
        try {
            File file = new File(filename);
            reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferreader = new BufferedReader(reader);
            String line;
            while ((line = bufferreader.readLine()) != null) {
                Geometry geo = GeometryFactory.decode(line);
                _geometries.add(geo);
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

    public GEnvelope getEnvelope() {
        GEnvelope ev = _geometries.get(0).getEnvelope();
        for (int i = 0; i < _geometries.size(); i++) {
            ev.combine(_geometries.get(i).getEnvelope());
        }
        return ev;
    }

    public String getFileName() {
        return _fileName;
    }

    public void setFileName(String _fileName) {
        this._fileName = _fileName;
    }

    public boolean isVisible() {
        return _visible;
    }

    public void setVisible(boolean _visible) {
        this._visible = _visible;
    }

    public String getPrefixName() {
        File file = new File(getFileName());
        String fileprefix = file.getName();
        fileprefix = fileprefix.substring(0, fileprefix.indexOf("."));
        return fileprefix;
    }

    public void changeVisible() {
        _visible=!_visible;
    }

    public boolean getVisible() {
        return _visible;
    }
}
