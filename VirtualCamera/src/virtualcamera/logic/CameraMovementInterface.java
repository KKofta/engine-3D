package virtualcamera.logic;

import java.util.ArrayList;
import virtualcamera.entities.Line3D;

public interface CameraMovementInterface {
    public void translateUp();
    public void translateDown();
    public void translateLeft();
    public void translateRight();
    public void translateForward();
    public void translateBackward();
    public void pivotOX(double degree);
    public void pivotOY(double degree);
    public void pivotOZ(double degree);
    public void zoomIn();
    public void zoomOut();
    public ArrayList<Line3D> getLines3DList(); 
}
