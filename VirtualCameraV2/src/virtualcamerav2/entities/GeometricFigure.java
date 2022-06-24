package virtualcamerav2.entities;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class GeometricFigure {
    
    protected final double length = 50;
    protected ArrayList<Point3D> pointList = new ArrayList<>();
    protected ArrayList<Point3D> startPointList = new ArrayList<>();
    protected double [] polygonPoints = new double [8];
    protected Color color = Color.BLACK;
    protected String name;
    
    public ArrayList<Point3D> getFigurePoints() {
        return pointList;
    }
    
    public ArrayList<Point3D> getFigureStartPoints() {
        return startPointList;
    }
    
    public void setPolygonPoint(double p, int i){
        polygonPoints[i] = p;
    }
    
    public double [] getPolygonPoints(){
        return polygonPoints;
    }
    
    public Color getColor(){
        return color;
    }
    
    public double [] calculatePlaneEquation() {
        //we need at least 3 points to determine a plane        
        Point3D P = startPointList.get(0);
        Point3D Q = startPointList.get(1);
        Point3D R = startPointList.get(2);

        double [] vectorPQ = new double []{Q.getX() - P.getX(), Q.getY() - P.getY(), Q.getZ() - P.getZ()};
        double [] vectorPR = new double []{R.getX() - P.getX(), R.getY() - P.getY(), R.getZ() - P.getZ()};        
        
        //n = PQ x PR. Normal vector n=(a,b,c)
        double a = vectorPQ[1]*vectorPR[2] - vectorPQ[2]*vectorPR[1];
        double b = vectorPQ[0]*vectorPR[2] - vectorPQ[2]*vectorPR[0];
        double c = vectorPQ[0]*vectorPR[1] - vectorPQ[1]*vectorPR[0];
        
        //calculaing plane from normal vector and point P. a*x + b*y + c*z = d => d - ?
        double d = a*P.getX() + b*P.getY() + c*P.getZ();
        
        //a*x + b*y + c*z - d = 0 
        return new double []{a,b,c,-d};
    }
    
    //testing method
    public String getName(){
        return name;
    }
}
