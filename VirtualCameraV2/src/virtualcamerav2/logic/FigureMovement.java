package virtualcamerav2.logic;

import virtualcamerav2.entities.MiddleOfProjection;
import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Point3D;

public class FigureMovement {

    private double STEP = 6.0;
    private GeometricFigure figure = new GeometricFigure();
    private ArrayList<Point3D> points3DList = figure.getFigurePoints();
    private Point3D light;
    private MatrixOperations mathHelper = new MatrixOperations();

    public FigureMovement(GeometricFigure figure) {
        this.figure = figure;
        this.points3DList = figure.getFigurePoints();
    }
    
    public FigureMovement(Point3D light) {
        this.light = light;
    }
    
    public void translateUp() {
        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate            
            double currentY = points3DList.get(i).getY();

            //update list of points
            points3DList.get(i).setY(currentY + STEP);
        }
    }
    
    public void translateDown() {
        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate          
            double currentY = points3DList.get(i).getY();

            //update list of points            
            points3DList.get(i).setY(currentY - STEP);
        }
    }
    
    public void translateRight() {
        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate            
            double currentX = points3DList.get(i).getX();

            //update list of points
            points3DList.get(i).setX(currentX - STEP);
        }
    }
    
    public void translateLeft() {
        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate
            double currentX = points3DList.get(i).getX();

            //update list of points
            points3DList.get(i).setX(currentX + STEP);
        }
    }
    
    public void translateForward() {
        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate            
            double currentZ = points3DList.get(i).getZ();

            //update list of points
            points3DList.get(i).setZ(currentZ - STEP);
        }
    }
    
    public void translateBackward() {
        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate
            double currentZ = points3DList.get(i).getZ();

            //update list of points
            points3DList.get(i).setZ(currentZ + STEP);
        }
    }
    
    public void pivotOX(double degree) {
        double[][] MOX = mathHelper.createMatrixMOX(degree);
        double[][] PointVector3D;
        double[][] pivotedPointVector;

        for (int i = 0; i < points3DList.size(); i++) {
            //take current vectors            
            PointVector3D = points3DList.get(i).getPointVector();

            //pivot - multipy            
            pivotedPointVector = mathHelper.multiplyMatrices(MOX, PointVector3D);

            //update point             
            points3DList.get(i).updateCoordinates(
                    pivotedPointVector[0][0],
                    pivotedPointVector[1][0],
                    pivotedPointVector[2][0]);
        }
    }
    
    public void pivotOY(double degree) {
        double[][] MOY = mathHelper.createMatrixMOY(degree);
        double[][] PointVector3D;
        double[][] pivotedPointVector;

        for (int i = 0; i < points3DList.size(); i++) {
            //take current vectors         
            PointVector3D = points3DList.get(i).getPointVector();

            //pivot - multipy          
            pivotedPointVector = mathHelper.multiplyMatrices(MOY, PointVector3D);

            //update point            
            points3DList.get(i).updateCoordinates(
                    pivotedPointVector[0][0],
                    pivotedPointVector[1][0],
                    pivotedPointVector[2][0]);
        }
    }
    
    public void pivotOZ(double degree) {
        double[][] MOZ = mathHelper.createMatrixMOZ(degree);
        double[][] PointVector3D;
        double[][] pivotedPointVector;

        for (int i = 0; i < points3DList.size(); i++) {
            //take current vectors
            PointVector3D = points3DList.get(i).getPointVector();

            //pivot - multipy            
            pivotedPointVector = mathHelper.multiplyMatrices(MOZ, PointVector3D);

            //update point             
            points3DList.get(i).updateCoordinates(
                    pivotedPointVector[0][0],
                    pivotedPointVector[1][0],
                    pivotedPointVector[2][0]);
        }
    }
    
    public void zoomIn() {
        MiddleOfProjection.increaseD();
    }
    
    public void zoomOut() {
        MiddleOfProjection.decreaseD();
    }
    
    // light section
    public void translateUpLight() {
        double currentY = light.getY();
        light.setY(currentY + STEP);
    }
    
    public void translateDownLight() {
        double currentY = light.getY();
        light.setY(currentY - STEP);
    }
    
    public void translateRightLight() {
        double currentX = light.getX();
        light.setX(currentX - STEP);
    }
    
    public void translateLeftLight() {
        double currentX = light.getX();
        light.setX(currentX + STEP);
    }
    
    public void translateForwardLight() {
        double currentZ = light.getZ();
        light.setZ(currentZ - STEP);
    }
    
    public void translateBackwardLight() {
        double currentZ = light.getZ();
        light.setZ(currentZ + STEP);
    }
    
    public void pivotOXLight(double degree) {
        double[][] MOX = mathHelper.createMatrixMOX(degree);
        double[][] PointVector3D;
        double[][] pivotedPointVector;

        PointVector3D = light.getPointVector();
        pivotedPointVector = mathHelper.multiplyMatrices(MOX, PointVector3D);
        light.updateCoordinates(
                pivotedPointVector[0][0],
                pivotedPointVector[1][0],
                pivotedPointVector[2][0]);
    }
    
    public void pivotOYLight(double degree) {
        double[][] MOY = mathHelper.createMatrixMOY(degree);
        double[][] PointVector3D;
        double[][] pivotedPointVector;

        PointVector3D = light.getPointVector();
        pivotedPointVector = mathHelper.multiplyMatrices(MOY, PointVector3D);
        light.updateCoordinates(
                pivotedPointVector[0][0],
                pivotedPointVector[1][0],
                pivotedPointVector[2][0]);
    }
    
    public void pivotOZLight(double degree) {
        double[][] MOZ = mathHelper.createMatrixMOZ(degree);
        double[][] PointVector3D;
        double[][] pivotedPointVector;

        PointVector3D = light.getPointVector();
        pivotedPointVector = mathHelper.multiplyMatrices(MOZ, PointVector3D);
        light.updateCoordinates(
                pivotedPointVector[0][0],
                pivotedPointVector[1][0],
                pivotedPointVector[2][0]);
    }
}