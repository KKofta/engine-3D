package engine3D.entities;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import engine3D.logic.VectorOperations;

public class GeometricFigure {
    
    protected ArrayList<Point> pointList = new ArrayList<>();
    protected ArrayList<Point> startPointList = new ArrayList<>();
    protected double [] polygonPoints = new double [6];
    protected final Color BASE_COLOR = Color.color(18.0/256.0, 168.0/256.0, 240.0/256.0);
    protected Color lighteningColor;
    protected String name;
    
    public Color updateAndGetColor(Point light){
        double [] vectorLight = new double []{light.getX(), light.getY(), light.getZ()};
        double [] vectorLightNormalized = VectorOperations.normalize(vectorLight);

        double [] vectorNormal = calculateNormalVectorChanged();
        double [] vectorNormalNormalized = VectorOperations.normalize(vectorNormal);
        
        double dotProductNL = VectorOperations.dot(vectorNormalNormalized, vectorLightNormalized);
        
        double cos = 0;
        if (dotProductNL > Light.MIN.value) {
            //the cosine between the vector from plane to camera and the vector of light after reflection from the plane
            cos = Math.pow(VectorOperations.cos(new double []{0 - pointList.get(0).getX(), 0 - pointList.get(0).getY(), 0 - pointList.get(0).getZ()},
                VectorOperations.getReboundVector(vectorNormalNormalized, light)), Light.N.value);
        }
        double lightRatio = Light.SA.value + Light.IP.value * (Light.KD.value * dotProductNL + Light.KS.value * cos);
        lightRatio = Math.max(Light.MIN.value, Math.min(Light.MAX.value, lightRatio));
        
        lighteningColor = Color.color( BASE_COLOR.getRed() * lightRatio, BASE_COLOR.getGreen() * lightRatio, BASE_COLOR.getBlue() * lightRatio );
        
        return lighteningColor;
    }
    
    public ArrayList<Point> getFigurePoints() {
        return pointList;
    }
    
    public ArrayList<Point> getFigureStartPoints() {
        return startPointList;
    }
    
    public void setPolygonPoint(double p, int i){
        polygonPoints[i] = p;
    }
    
    public double [] getPolygonPoints(){
        return polygonPoints;
    }
  
    public Color getColor(){
        return lighteningColor;
    }
    
    //calculate normal vector of a plane which was changed by pivots etc
    public double [] calculateNormalVectorChanged() {
        //we need at least 3 points to determine a plane        
        Point P = pointList.get(0);
        Point Q = pointList.get(1);
        Point R = pointList.get(2);

        double [] vectorPQ = new double []{Q.getX() - P.getX(), Q.getY() - P.getY(), Q.getZ() - P.getZ()};
        double [] vectorPR = new double []{R.getX() - P.getX(), R.getY() - P.getY(), R.getZ() - P.getZ()};        
        
        //n = PQ x PR. Normal vector n=(a,b,c)
        double a = vectorPQ[1]*vectorPR[2] - vectorPQ[2]*vectorPR[1];
        double b = vectorPQ[0]*vectorPR[2] - vectorPQ[2]*vectorPR[0];
        double c = vectorPQ[0]*vectorPR[1] - vectorPQ[1]*vectorPR[0];
        
        return new double []{a,b,c};
    }
    
    public double [] calculatePlaneEquation() {
        //we need at least 3 points to determine a plane        
        Point P = startPointList.get(0);
        
        double [] normalVector = calculateNormalVectorChanged();
        
        double a = normalVector[0];
        double b = normalVector[1];
        double c = normalVector[2];
        
        //calculaing plane from normal vector and point P. a*x + b*y + c*z = d => d - ?
        double d = a*P.getX() + b*P.getY() + c*P.getZ();
        
        //a*x + b*y + c*z - d = 0 
        return new double []{a,b,c,-d};
    }
}
