package virtualcamerav2.entities;

import javafx.scene.paint.Color;
import java.util.Collections;

public class FrontSquare extends GeometricFigure {

    public FrontSquare() {
        color = Color.RED;
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the polygon
        Point3D leftUp = new Point3D(-length / 2, -length / 2, 25.0);
        Point3D rightUp = new Point3D(length / 2, -length / 2, 25.0);
        Point3D leftDown = new Point3D(-length / 2, length / 2, 25.0);
        Point3D rightDown = new Point3D(length / 2, length / 2, 25.0);

        Collections.addAll(pointList, leftUp, rightUp, rightDown, leftDown);
    }
}
