package engine3D.logic;

import java.util.ArrayList;
import engine3D.entities.GeometricFigure;
import engine3D.entities.MiddleOfProjection;
import engine3D.entities.Point;
//it moves the list of all created figures 
public class CameraMovement {

    private ArrayList<FigureMovement> figureMovementList = new ArrayList<>();
    private Point light;
    private FigureMovement lightMovement;

    public CameraMovement(ArrayList<GeometricFigure> figures, Point light) {
        figures.stream().map(figure -> new FigureMovement(figure)).forEachOrdered(figureMovement -> {
            figureMovementList.add(figureMovement);
        });
        this.light = light;
        this.lightMovement = new FigureMovement(this.light);
    }
    
    public void TranslateUp() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateUp();
        });
    }
    
    public void TranslateDown() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateDown();
        });
    }
    
    public void TranslateRight() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateRight();
        });
    }
    
    public void TranslateLeft() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateLeft();
        });
    }
    
    public void TranslateForward() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateForward();
        });
    }
    
    public void TranslateBackward() {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.translateBackward();
        });
    }
    
    public void PivotOX(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOX(degree);
        });
        lightMovement.pivotOXLight(-degree);
    }
    
    public void PivotOY(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOY(degree);
        });
        lightMovement.pivotOYLight(degree);
    }
    
    public void PivotOZ(double degree) {
        figureMovementList.forEach(cameraMovementOject -> {
            cameraMovementOject.pivotOZ(degree);
        });
        lightMovement.pivotOZLight(-degree);
    }
    
    public void zoomIn() {
        MiddleOfProjection.increaseD();
    }
    
    public void zoomOut() {
        MiddleOfProjection.decreaseD();
    }
}