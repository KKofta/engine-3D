package virtualcamerav2.entities;

import java.util.Collections;
import javafx.scene.paint.Color;

public class SkewedRectangle extends GeometricFigure {

    public SkewedRectangle() {
        color = Color.GREEN;
        createRectangle();
    }

    private void createRectangle() {
        //initialize 3D points of the polygon
        Point3D leftUp = new Point3D(length / 2, -length, 50.0);
        Point3D rightUp = new Point3D(4 * length, -length, 150.0);
        Point3D leftDown = new Point3D(length / 2, length, 50.0);
        Point3D rightDown = new Point3D(4 * length, length, 150.0);

        Collections.addAll(pointList, leftUp, rightUp, rightDown, leftDown);
    }
}
