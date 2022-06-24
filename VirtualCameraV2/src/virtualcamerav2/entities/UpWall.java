package virtualcamerav2.entities;

import java.util.Collections;
import javafx.scene.paint.Color;

public class UpWall extends GeometricFigure {

    public UpWall() {
        color = Color.DARKCYAN;
        name = "UpWall";
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the polygon
        Point3D leftFront = new Point3D(-length, -length, 50.0);
        Point3D rightFront = new Point3D(length, -length, 50.0);
        Point3D leftBack = new Point3D(-length, -length, 150.0);
        Point3D rightBack = new Point3D(length, -length, 150.0);

        Collections.addAll(pointList, leftFront, rightFront, rightBack, leftBack);
        Collections.addAll(startPointList, leftFront.copy(), rightFront.copy(), rightBack.copy(), leftBack.copy());
        
    }

}
