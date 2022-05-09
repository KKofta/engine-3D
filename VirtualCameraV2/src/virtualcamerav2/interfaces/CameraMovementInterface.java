package virtualcamerav2.interfaces;

public interface CameraMovementInterface {

    public void TranslateUp();

    public void TranslateDown();

    public void TranslateRight();

    public void TranslateLeft();

    public void TranslateForward();

    public void TranslateBackward();

    public void PivotOX(double degree);

    public void PivotOY(double degree);

    public void PivotOZ(double degree);

    public void zoomIn();

    public void zoomOut();
}
