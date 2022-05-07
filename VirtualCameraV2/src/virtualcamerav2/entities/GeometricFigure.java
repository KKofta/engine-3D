package virtualcamerav2.entities;

import javafx.scene.paint.Color;
import java.util.ArrayList;

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
    
    
}
