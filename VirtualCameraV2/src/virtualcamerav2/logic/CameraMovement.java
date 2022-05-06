package virtualcamerav2.logic;

import virtualcamerav2.entities.MiddleOfProjection;
import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Point3D;

public class CameraMovement implements CameraMovementInterface {
    
    private GeometricFigure figure = new GeometricFigure();
    private ArrayList<Point3D> points3DList = figure.getFigurePoints();
    private MatrixOperations mathHelper = new MatrixOperations();
    
    public CameraMovement(GeometricFigure figure){
        this.figure = figure;
        this.points3DList = figure.getFigurePoints();
    }
    
    @Override
    public void translateUp() {
        double Ty = 2.0;

        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate            
            double currentY = points3DList.get(i).getY();

            //update list of points
            points3DList.get(i).setY(currentY + Ty);
        }
    }

    @Override
    public void translateDown() {
        double Ty = 2.0;

        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate          
            double currentY = points3DList.get(i).getY();

            //update list of points            
            points3DList.get(i).setY(currentY - Ty);
        }
    }


    @Override
    public void translateRight() {
        double Tx = 2.0;

        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate            
            double currentX = points3DList.get(i).getX();

            //update list of points
            points3DList.get(i).setX(currentX - Tx);
        }
    }

    @Override
    public void translateLeft() {
        double Tx = 2.0;

        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate
            double currentX = points3DList.get(i).getX();

            //update list of points
            points3DList.get(i).setX(currentX + Tx);
        }
    }

    @Override
    public void translateForward() {
        double Tz = 2.0;

        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate            
            double currentZ = points3DList.get(i).getZ();

            //update list of points
            points3DList.get(i).setZ(currentZ - Tz);
        }
    }

    @Override
    public void translateBackward() {
        double Tz = 2.0;

        for (int i = 0; i < points3DList.size(); i++) {
            //current values of y coordinate
            double currentZ = points3DList.get(i).getZ();

            //update list of points
            points3DList.get(i).setZ(currentZ + Tz);
        }
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public void zoomIn() {
        MiddleOfProjection.increaseD();
    }

    @Override
    public void zoomOut() {
        MiddleOfProjection.decreaseD();
    }
}
