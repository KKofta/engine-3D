package virtualcamerav2.entities;

import javafx.scene.paint.Color;
import java.util.Collections;

public class BackSquare extends GeometricFigure {

    public BackSquare() {
        color = Color.BLUE;
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the polygon
        Point3D leftUp = new Point3D(-length, -length, 100.0);
        Point3D rightUp = new Point3D(length, -length, 100.0);
        Point3D leftDown = new Point3D(-length, length, 100.0);
        Point3D rightDown = new Point3D(length, length, 100.0);
        
        Collections.addAll(pointList, leftUp, rightUp, rightDown, leftDown);
    }
}
