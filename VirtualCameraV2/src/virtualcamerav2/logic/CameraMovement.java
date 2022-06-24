package virtualcamerav2.logic;

import virtualcamerav2.interfaces.FigureMovementInterface;
import virtualcamerav2.interfaces.CameraMovementInterface;
import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.MiddleOfProjection;
import virtualcamerav2.entities.Observator;
//it moves the list of all created figures 

public class CameraMovement implements CameraMovementInterface {

    private ArrayList<FigureMovementInterface> figureMovementList = new ArrayList<>();
    private Observator observator;

    public CameraMovement(ArrayList<GeometricFigure> figures, Observator observator) {
        figures.stream().map(figure -> new FigureMovement(figure)).forEachOrdered(figureMovement -> {
            figureMovementList.add(figureMovement);
        });
        this.observator = observator;
    }

    @Override
    public void TranslateUp() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateUp();
        });
        observator.moveUp();
    }

    @Override
    public void TranslateDown() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateDown();
        });
        observator.moveDown();
    }

    @Override
    public void TranslateRight() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateRight();
        });
        observator.moveRight();
    }

    @Override
    public void TranslateLeft() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateLeft();
        });
        observator.moveLeft();
    }

    @Override
    public void TranslateForward() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateForward();
        });
        observator.moveForward();
    }

    @Override
    public void TranslateBackward() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateBackward();
        });
        observator.moveBackward();
    }

    @Override
    public void PivotOX(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOX(degree);
        });
        observator.changAngleYZ(degree);
    }

    @Override
    public void PivotOY(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOY(degree);
        });
        observator.changAngleXZ(degree);
    }

    @Override
    public void PivotOZ(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOZ(degree);
        });
        observator.changAngleXY(degree);
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
