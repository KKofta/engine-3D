package virtualcamerav2.entities;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class GeometricFigure {
    
    protected final double length = 50;
    protected ArrayList<Line3D> lineList = new ArrayList<>();
    protected ArrayList<Point3D> pointList = new ArrayList<>();
    protected double [] polygonPoints = new double [8];
    protected Color color = Color.BLACK;
    
    public ArrayList<Line3D> getFigureLines() {
        return lineList;
    }
    
    public ArrayList<Point3D> getFigurePoints() {
        return pointList;
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
    
    public double getBiggestZ(){
        return calculateBiggestZ();
    }
    
    public double getSmallestZ(){
        return calculateSmallestZ();
    }
    
    private double calculateBiggestZ(){
        double biggestZ = Integer.MIN_VALUE;
        for(Point3D point : pointList){
            if(point.getZ() > biggestZ){
                biggestZ = point.getZ();
            }
        }
        return biggestZ;
    }
    
    private double calculateSmallestZ(){
        double smallestZ = Integer.MAX_VALUE;
        for(Point3D point : pointList){
            if(point.getZ() < smallestZ){
                smallestZ = point.getZ();
            }
        }
        return smallestZ;
    }
    
    public double [] calculatePlaneEquation() {
        //we need at least 3 points to determine a plane
        Point3D P = pointList.get(0);
        Point3D Q = pointList.get(1);
        Point3D R = pointList.get(2);

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
}
