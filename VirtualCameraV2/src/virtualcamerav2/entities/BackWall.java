package virtualcamerav2.entities;

import java.util.Collections;
import javafx.scene.paint.Color;

public class BackWall extends GeometricFigure {

    public BackWall() {
        color = Color.DARKCYAN;
        name = "BackWall";
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the polygon
        Point3D leftUp = new Point3D(-length, -length, 150.0);
        Point3D rightUp = new Point3D(length, -length, 150.0);
        Point3D leftDown = new Point3D(-length, length, 150.0);
        Point3D rightDown = new Point3D(length, length, 150.0);

        Collections.addAll(pointList, leftUp, rightUp, rightDown, leftDown);
        Collections.addAll(startPointList, leftUp.copy(), rightUp.copy(), rightDown.copy(), leftDown.copy());
    }
}
