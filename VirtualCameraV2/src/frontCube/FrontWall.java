package frontCube;

import java.util.Collections;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Point3D;

public class FrontWall extends GeometricFigure {

    public FrontWall() {
        name = "FrontWall";
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the polygon
        Point3D leftUp = new Point3D(-length, -length, 50.0);
        Point3D rightUp = new Point3D(length, -length, 50.0);
        Point3D leftDown = new Point3D(-length, length, 50.0);
        Point3D rightDown = new Point3D(length, length, 50.0);

        Collections.addAll(pointList, leftUp, rightUp, rightDown, leftDown);
        Collections.addAll(startPointList, leftUp.copy(), rightUp.copy(), rightDown.copy(), leftDown.copy());
    }
}
