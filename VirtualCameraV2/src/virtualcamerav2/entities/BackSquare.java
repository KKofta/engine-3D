package virtualcamerav2.entities;

import javafx.scene.paint.Color;
import java.util.Collections;

public class BackSquare extends GeometricFigure {

    public BackSquare() {
        color = Color.BLUE;
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the front wall 
        Point3D frontLeftUp = new Point3D(-length, -length, 100.0);
        Point3D frontRightUp = new Point3D(length, -length, 100.0);
        Point3D frontLeftDown = new Point3D(-length, length, 100.0);
        Point3D frontRightDown = new Point3D(length, length, 100.0);

        //initialize 3D lines of the front wall
        Line3D frontUp = new Line3D(frontLeftUp, frontRightUp);
        Line3D frontDown = new Line3D(frontLeftDown, frontRightDown);
        Line3D frontLeft = new Line3D(frontLeftUp, frontLeftDown);
        Line3D frontRight = new Line3D(frontRightUp, frontRightDown);
        
        Collections.addAll(lineList, frontUp, frontDown, frontLeft, frontRight);
        Collections.addAll(pointList, frontLeftUp, frontRightUp, frontRightDown, frontLeftDown);
    }
}
