package virtualcamerav2.entities;

import javafx.scene.paint.Color;
import java.util.Collections;

public class FrontSquare extends GeometricFigure {

    public FrontSquare() {
        color = Color.RED;
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the front wall 
        Point3D frontLeftUp2 = new Point3D(-length / 2, -length / 2, 25.0);
        Point3D frontRightUp2 = new Point3D(length / 2, -length / 2, 25.0);
        Point3D frontLeftDown2 = new Point3D(-length / 2, length / 2, 25.0);
        Point3D frontRightDown2 = new Point3D(length / 2, length / 2, 25.0);

        //initialize 3D lines of the front wall
        Line3D frontUp2 = new Line3D(frontLeftUp2, frontRightUp2);
        Line3D frontDown2 = new Line3D(frontLeftDown2, frontRightDown2);
        Line3D frontLeft2 = new Line3D(frontLeftUp2, frontLeftDown2);
        Line3D frontRight2 = new Line3D(frontRightUp2, frontRightDown2);

        Collections.addAll(lineList, frontUp2, frontDown2, frontLeft2, frontRight2);
        Collections.addAll(pointList, frontLeftUp2, frontRightUp2, frontRightDown2, frontLeftDown2);
    }
}
