package virtualcamera.logic;

import virtualcamera.entities.MiddleOfProjection;
import virtualcamera.entities.Cube3D;
import virtualcamera.entities.Line3D;
import java.util.ArrayList;

public class CameraMovement implements CameraMovementInterface {

    private Cube3D cube3D = new Cube3D();
    private ArrayList<Line3D> lines3DList = cube3D.getCubeLines();
    private MatrixOperations mathHelper = new MatrixOperations();

    
    @Override
    public ArrayList<Line3D> getLines3DList() {
        return lines3DList;
    }

    @Override
    public void translateUp() {
        double Ty = 2.0;

        for (int i = 0; i < lines3DList.size(); i++) {
            //current values of y coordinate
            double currentStartY = lines3DList.get(i).getLine3DStartPoint().getY();
            double currentEndY = lines3DList.get(i).getLine3DEndPoint().getY();

            //update list of points
            lines3DList.get(i).getLine3DStartPoint().setY(currentStartY + Ty);
            lines3DList.get(i).getLine3DEndPoint().setY(currentEndY + Ty);
        }
    }

    @Override
    public void translateDown() {
        double Ty = 2.0;

        for (int i = 0; i < lines3DList.size(); i++) {
            //current values of y coordinate
            double currentStartY = lines3DList.get(i).getLine3DStartPoint().getY();
            double currentEndY = lines3DList.get(i).getLine3DEndPoint().getY();

            //update list of points
            lines3DList.get(i).getLine3DStartPoint().setY(currentStartY - Ty);
            lines3DList.get(i).getLine3DEndPoint().setY(currentEndY - Ty);
        }
    }

    @Override
    public void translateRight() {
        double Tx = 2.0;

        for (int i = 0; i < lines3DList.size(); i++) {
            //current values of y coordinate
            double currentStartX = lines3DList.get(i).getLine3DStartPoint().getX();
            double currentEndX = lines3DList.get(i).getLine3DEndPoint().getX();

            //update list of points
            lines3DList.get(i).getLine3DStartPoint().setX(currentStartX - Tx);
            lines3DList.get(i).getLine3DEndPoint().setX(currentEndX - Tx);
        }
    }

    @Override
    public void translateLeft() {
        double Tx = 2.0;

        for (int i = 0; i < lines3DList.size(); i++) {
            //current values of y coordinate
            double currentStartX = lines3DList.get(i).getLine3DStartPoint().getX();
            double currentEndX = lines3DList.get(i).getLine3DEndPoint().getX();

            //update list of points
            lines3DList.get(i).getLine3DStartPoint().setX(currentStartX + Tx);
            lines3DList.get(i).getLine3DEndPoint().setX(currentEndX + Tx);
        }
    }

    @Override
    public void translateForward() {
        double Tz = 2.0;

        for (int i = 0; i < lines3DList.size(); i++) {
            //current values of y coordinate
            double currentStartZ = lines3DList.get(i).getLine3DStartPoint().getZ();
            double currentEndZ = lines3DList.get(i).getLine3DEndPoint().getZ();

            //update list of points
            lines3DList.get(i).getLine3DStartPoint().setZ(currentStartZ - Tz);
            lines3DList.get(i).getLine3DEndPoint().setZ(currentEndZ - Tz);
        }
    }

    @Override
    public void translateBackward() {
        double Tz = 2.0;

        for (int i = 0; i < lines3DList.size(); i++) {
            //current values of y coordinate
            double currentStartZ = lines3DList.get(i).getLine3DStartPoint().getZ();
            double currentEndZ = lines3DList.get(i).getLine3DEndPoint().getZ();

            //update list of points
            lines3DList.get(i).getLine3DStartPoint().setZ(currentStartZ + Tz);
            lines3DList.get(i).getLine3DEndPoint().setZ(currentEndZ + Tz);
        }
    }

    @Override
    public void pivotOX(double degree) {
        double[][] MOX = mathHelper.createMatrixMOX(degree);
        double[][] startPointVector3D;
        double[][] endPointVector3D;
        double[][] pivotedStartPointVector;
        double[][] pivotedEndPointVector;

        for (int i = 0; i < lines3DList.size(); i++) {
            //take current vectors
            startPointVector3D = lines3DList.get(i).getLine3DStartPoint().getPointVector();
            endPointVector3D = lines3DList.get(i).getLine3DEndPoint().getPointVector();

            //pivot - multipy
            pivotedStartPointVector = mathHelper.multiplyMatrices(MOX, startPointVector3D);
            pivotedEndPointVector = mathHelper.multiplyMatrices(MOX, endPointVector3D);

            //update point 
            lines3DList.get(i).getLine3DStartPoint().updateCoordinates(
                    pivotedStartPointVector[0][0],
                    pivotedStartPointVector[1][0],
                    pivotedStartPointVector[2][0]);

            lines3DList.get(i).getLine3DEndPoint().updateCoordinates(
                    pivotedEndPointVector[0][0],
                    pivotedEndPointVector[1][0],
                    pivotedEndPointVector[2][0]);
        }
    }

    @Override
    public void pivotOY(double degree) {
        double[][] MOY = mathHelper.createMatrixMOY(degree);
        double[][] startPointVector3D;
        double[][] endPointVector3D;
        double[][] pivotedStartPointVector;
        double[][] pivotedEndPointVector;

        for (int i = 0; i < lines3DList.size(); i++) {
            //take current vectors
            startPointVector3D = lines3DList.get(i).getLine3DStartPoint().getPointVector();
            endPointVector3D = lines3DList.get(i).getLine3DEndPoint().getPointVector();

            //pivot - multipy
            pivotedStartPointVector = mathHelper.multiplyMatrices(MOY, startPointVector3D);
            pivotedEndPointVector = mathHelper.multiplyMatrices(MOY, endPointVector3D);

            //update point 
            lines3DList.get(i).getLine3DStartPoint().updateCoordinates(
                    pivotedStartPointVector[0][0],
                    pivotedStartPointVector[1][0],
                    pivotedStartPointVector[2][0]);

            lines3DList.get(i).getLine3DEndPoint().updateCoordinates(
                    pivotedEndPointVector[0][0],
                    pivotedEndPointVector[1][0],
                    pivotedEndPointVector[2][0]);
        }
    }

    @Override
    public void pivotOZ(double degree) {
        double[][] MOZ = mathHelper.createMatrixMOZ(degree);
        double[][] startPointVector3D;
        double[][] endPointVector3D;
        double[][] pivotedStartPointVector;
        double[][] pivotedEndPointVector;

        for (int i = 0; i < lines3DList.size(); i++) {
            //take current vectors
            startPointVector3D = lines3DList.get(i).getLine3DStartPoint().getPointVector();
            endPointVector3D = lines3DList.get(i).getLine3DEndPoint().getPointVector();

            //pivot - multipy
            pivotedStartPointVector = mathHelper.multiplyMatrices(MOZ, startPointVector3D);
            pivotedEndPointVector = mathHelper.multiplyMatrices(MOZ, endPointVector3D);

            //update point 
            lines3DList.get(i).getLine3DStartPoint().updateCoordinates(
                    pivotedStartPointVector[0][0],
                    pivotedStartPointVector[1][0],
                    pivotedStartPointVector[2][0]);

            lines3DList.get(i).getLine3DEndPoint().updateCoordinates(
                    pivotedEndPointVector[0][0],
                    pivotedEndPointVector[1][0],
                    pivotedEndPointVector[2][0]);
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
