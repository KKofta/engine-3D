package virtualcamerav2.entities;

import java.util.Collections;
import javafx.scene.paint.Color;

public class SkewedRectangle extends GeometricFigure {

    public SkewedRectangle() {
        color = Color.GREEN;
        createRectangle();
    }

    private void createRectangle() {
        //initialize 3D points of the front wall 
        Point3D frontLeftUp3 = new Point3D(length / 2, -length, 50.0);
        Point3D frontRightUp3 = new Point3D(4 * length, -length, 150.0);
        Point3D frontLeftDown3 = new Point3D(length / 2, length, 50.0);
        Point3D frontRightDown3 = new Point3D(4 * length, length, 150.0);

        //initialize 3D lines of the front wall
        Line3D frontUp3 = new Line3D(frontLeftUp3, frontRightUp3);
        Line3D frontDown3 = new Line3D(frontLeftDown3, frontRightDown3);
        Line3D frontLeft3 = new Line3D(frontLeftUp3, frontLeftDown3);
        Line3D frontRight3 = new Line3D(frontRightUp3, frontRightDown3);

        Collections.addAll(lineList, frontUp3, frontDown3, frontLeft3, frontRight3);
        Collections.addAll(pointList, frontLeftUp3, frontRightUp3, frontRightDown3, frontLeftDown3);
    }
}
