package virtualcamerav2.logic;

import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.MiddleOfProjection;
import virtualcamerav2.entities.Observator;
import virtualcamerav2.entities.Point3D;
//it moves the list of all created figures 

public class CameraMovement {

    private ArrayList<FigureMovement> figureMovementList = new ArrayList<>();
    private Observator observator;
    private Point3D light;
    private FigureMovement lightMovement;

    public CameraMovement(ArrayList<GeometricFigure> figures, Observator observator, Point3D light) {
        figures.stream().map(figure -> new FigureMovement(figure)).forEachOrdered(figureMovement -> {
            figureMovementList.add(figureMovement);
        });
        this.observator = observator;
        this.light = light;
        lightMovement = new FigureMovement(this.light);
    }
    
    public void TranslateUp() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateUp();
        });
        observator.moveUp();
        //lightMovement.translateUpLight();
    }
    
    public void TranslateDown() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateDown();
        });
        observator.moveDown();
        //lightMovement.translateDownLight();
    }
    
    public void TranslateRight() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateRight();
        });
        observator.moveRight();
        //lightMovement.translateRightLight();
    }
    
    public void TranslateLeft() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateLeft();
        });
        observator.moveLeft();
        //lightMovement.translateLeftLight();
    }
    
    public void TranslateForward() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateForward();
        });
        observator.moveForward();
        //lightMovement.translateForwardLight();
    }
    
    public void TranslateBackward() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateBackward();
        });
        observator.moveBackward();
        //lightMovement.translateBackwardLight();
    }
    
    public void PivotOX(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOX(degree);
        });
        observator.changAngleYZ(degree);
        //lightMovement.pivotOXLight(degree);
    }
    
    public void PivotOY(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOY(degree);
        });
        observator.changAngleXZ(degree);
        //lightMovement.pivotOYLight(degree);
    }
    
    public void PivotOZ(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOZ(degree);
        });
        observator.changAngleXY(degree);
        //lightMovement.pivotOZLight(degree);
    }
    
    public void zoomIn() {
        MiddleOfProjection.increaseD();
    }
    
    public void zoomOut() {
        MiddleOfProjection.decreaseD();
    }
}