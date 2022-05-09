package virtualcamerav2.logic;

import virtualcamerav2.interfaces.FigureMovementInterface;
import virtualcamerav2.interfaces.CameraMovementInterface;
import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.MiddleOfProjection;
//it moves the list of all created figures 

public class CameraMovement implements CameraMovementInterface {

    ArrayList<FigureMovementInterface> figureMovementList = new ArrayList<>();

    public CameraMovement(ArrayList<GeometricFigure> figures) {
        figures.stream().map(figure -> new FigureMovement(figure)).forEachOrdered(figureMovement -> {
            figureMovementList.add(figureMovement);
        });
    }

    @Override
    public void TranslateUp() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateUp();
        });
    }

    @Override
    public void TranslateDown() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateDown();
        });
    }

    @Override
    public void TranslateRight() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateRight();
        });
    }

    @Override
    public void TranslateLeft() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateLeft();
        });
    }

    @Override
    public void TranslateForward() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateForward();
        });
    }

    @Override
    public void TranslateBackward() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateBackward();
        });
    }

    @Override
    public void PivotOX(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOX(degree);
        });
    }

    @Override
    public void PivotOY(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOY(degree);
        });
    }

    @Override
    public void PivotOZ(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOZ(degree);
        });
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
