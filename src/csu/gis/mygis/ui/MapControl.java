package csu.gis.mygis.ui;

import csu.gis.mygis.geom.GEnvelope;
import csu.gis.mygis.geom.GLineString;
import csu.gis.mygis.geom.GLinearRing;
import csu.gis.mygis.geom.GPoint;
import csu.gis.mygis.geom.GPolygon;
import csu.gis.mygis.geom.Geometry;
import csu.gis.mygis.map.GLayer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class MapControl extends JPanel implements MouseWheelListener,
        MouseMotionListener, MouseListener, Runnable {

    protected ArrayList<GLayer> _layers = new ArrayList<>();
    protected GPoint _center = new GPoint(0, 0);
    protected double _scale = 1.0f;
    protected double _a, _b, _d, _e, _f, _h;

    public static final int DRAW_NOTHING = 0;
    public static final int DRAW_POINT = 1;
    public static final int DRAW_LINESTRING = 2;
    private int _currentDrawOperation = MapControl.DRAW_NOTHING;
    private GLineString _temporaryLine = new GLineString();
    protected ArrayList<Geometry> _drawedGeometries = new ArrayList<>();

    private boolean mapDragging = true;

    protected MapMousePosition _positionLabel = null;
    protected JMenu _menuPaint = null;

    private boolean isMousePaint = false;
    private ArrayList<GPoint> _mousePoints = new ArrayList<>();

    private GPoint mousePointGeo = new GPoint();
    private GPoint ptStart = new GPoint();
    private GPoint ptEnd = new GPoint();
    private GPoint lastRelesedPoint = new GPoint();
    private GLineString lastLine = new GLineString();

    public MapControl() {
        super();
        addMouseWheelListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
        Thread tMap = new Thread(this);
        tMap.start();
    }

    public void setBuddy(MapMousePosition mmp) {
        _positionLabel = mmp;
    }

    public GPoint getMousePoint() {
        return mousePointGeo;
    }

    public void setIsMousePaint(boolean isMousePaint) {
        this.isMousePaint = isMousePaint;
    }

    public void setMapDragging(boolean bln) {
        mapDragging = bln;
    }

    public GLayer loadLayer(String absolutePath) {
        GLayer layer = new GLayer(absolutePath);
        _layers.add(layer);

        if (_layers.size() == 1) {
            GEnvelope ev = _layers.get(0).getEnvelope();
            _center = ev.getCenter();
            double sw = (double) this.getWidth() / ev.getWidth();
            double sh = (double) this.getHeight() / ev.getHeight();
            _scale = Math.min(sw, sh);
        }

        recalculateAffineParams();
        return layer;
    }

    public void drawLayer(Graphics g, GLayer layer) {
        if (layer.isVisible()) {
            for (int i = 0; i < layer.numGeometries(); i++) {
                drawGeometry(g, layer.get(i));
            }
        }
    }

    private void drawGeometry(Graphics g, Geometry geo) {
        Geometry mygeo = geo.transfer(_a, _b, _d, _e, _f, _h);
        if (mygeo.getType() == Geometry.POINT) {
            drawPoint(g, (GPoint) mygeo);
        } else if (mygeo.getType() == Geometry.LINESTRING) {
            drawLineString(g, (GLineString) mygeo);
        } else if (mygeo.getType() == Geometry.POLYGON) {
            drawPolygon(g, (GPolygon) mygeo);
        }
    }

    private void drawPoint(Graphics g, GPoint pt) {
        int r = 5;
        int x = (int) (pt.getX()) - r;
        int y = (int) (pt.getY()) - r;
        g.setColor(Color.red);
        g.drawOval(x, y, 2 * r, 2 * r);
        g.fillOval(x, y, 2 * r, 2 * r);
    }

    public void redrawMap(Graphics g) {
        recalculateAffineParams();
        if (isMousePaint) {
            for (int i = 0; i < _layers.size(); i++) {
                drawLayer(g, _layers.get(i));
            }
            for (int i = 0; i < _mousePoints.size() - 1; i++) {
                g.drawLine((int) _mousePoints.get(i).getX(), (int) _mousePoints.get(i).getY(),
                        (int) _mousePoints.get(i + 1).getX(), (int) _mousePoints.get(i + 1).getY());
            }
        } else {
            for (int i = 0; i < _layers.size(); i++) {
                drawLayer(g, _layers.get(i));
            }
        }
        drawTemporaryGeometries(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        redrawMap(g);
    }

    public void recalculateAffineParams() {
        _a = _scale;
        _b = 0.0f;
        _d = getWidth() * 0.5 - _scale * _center.getX();
        _e = 0.0f;
        _f = -_scale;
        _h = getHeight() * 0.5 + _scale * _center.getY();
    }

    private void drawLineString(Graphics g, GLineString ls) {
        int[] xPoints = new int[ls.numPoints()];
        int[] yPoints = new int[ls.numPoints()];
        for (int i = 0; i < ls.numPoints(); i++) {
            GPoint pt = ls.getPoint(i);
            xPoints[i] = (int) pt.getX();
            yPoints[i] = (int) pt.getY();
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2.0f));
        g.setColor(Color.black);
        g.drawPolyline(xPoints, yPoints, ls.numPoints());
        g2.setStroke(new BasicStroke(1.0f));
    }

    public void zoomIn(double mutiple) {
        _scale *= mutiple;
        repaint();
    }

    public void zoomOut(double mutiple) {
        _scale *= mutiple;
        repaint();
    }

    private void drawPolygon(Graphics g, GPolygon pg) {
        for (int i = 0; i < pg._rings.size(); i++) {
            drawLinearRing(g, pg._rings.get(i));
        }
    }

    private void drawLinearRing(Graphics g, GLinearRing lr) {
        int[] xPoints = new int[lr.numPoints()];
        int[] yPoints = new int[lr.numPoints()];
        for (int i = 0; i < lr.numPoints(); i++) {
            GPoint pt = lr.getPoint(i);
            xPoints[i] = (int) pt.getX();
            yPoints[i] = (int) pt.getY();
        }
        g.setColor(Color.blue);
        g.drawPolygon(xPoints, yPoints, lr.numPoints());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int wheelRotation = e.getWheelRotation();
        if (wheelRotation > 0) {
            zoomIn(1.5);
        } else if (wheelRotation < 0) {
            zoomOut(0.67);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        GPoint pt = new GPoint(e.getX(), e.getY());
        ptEnd = (GPoint) pt.detransfer(_a, _b, _d, _e, _f, _h);

        if (mapDragging) {
            double dx = ptEnd.getX() - ptStart.getX();
            double dy = ptEnd.getY() - ptStart.getY();
            _center.setX(_center.getX() - dx);
            _center.setY(_center.getY() - dy);
            repaint();
            ptStart = ptEnd;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        GPoint ptScreen = new GPoint(e.getX(), e.getY());
        mousePointGeo = (GPoint) ptScreen.detransfer(_a, _b, _d, _e, _f, _h);
        _positionLabel.setLabel(mousePointGeo);

        lastLine = new GLineString();
        lastLine.append(lastRelesedPoint);
        lastLine.append(mousePointGeo);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == e.BUTTON3) {
            if (_currentDrawOperation == DRAW_LINESTRING) {
                _currentDrawOperation = DRAW_NOTHING;
                _menuPaint.getItem(1).setSelected(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GPoint pt = new GPoint(e.getX(), e.getY());
        ptStart = (GPoint) pt.detransfer(_a, _b, _d, _e, _f, _h);
        if (isMousePaint) {
            _mousePoints.add(pt);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point pt = e.getPoint();
        GPoint gpt = new GPoint(pt.getX(), pt.getY());
        GPoint mypt = (GPoint) gpt.detransfer(_a, _b, _d, _e, _f, _h);
        if (_currentDrawOperation == MapControl.DRAW_POINT) {
            _drawedGeometries.add(mypt);
            repaint();
        } else if (_currentDrawOperation == MapControl.DRAW_LINESTRING) {
            _temporaryLine.append(mypt);
        }
        lastRelesedPoint = mypt;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(MapControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.repaint();
        }
    }

    public void setCurrentDrawOperation(int mp) {
        _currentDrawOperation = mp;
    }

    private void drawTemporaryGeometries(Graphics g) {
        for (int i = 0; i < _drawedGeometries.size(); i++) {
            Geometry geo = _drawedGeometries.get(i);
            drawGeometry(g, geo);
        }
        drawGeometry(g, _temporaryLine);

        if (_currentDrawOperation == DRAW_LINESTRING) {
            if(!(lastLine.getPoint(0).getX() == 0.0 && lastLine.getPoint(0).getY() == 0.0)){
                drawGeometry(g, lastLine);
            }
        }
    }

    public void setBuddy(JMenu menu) {
        _menuPaint = menu;
    }
}
