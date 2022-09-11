package rightCube;

import java.util.Collections;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Point3D;

public class UpWallRight extends GeometricFigure {

    public UpWallRight() {
        name = "UpWallRight";
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the polygon
        Point3D leftFront = new Point3D(length*1.5, -length, 50.0);
        Point3D rightFront = new Point3D(length*1.5+length, -length, 50.0);
        Point3D leftBack = new Point3D(length*1.5, -length, 150.0);
        Point3D rightBack = new Point3D(length*1.5+length, -length, 150.0);

        Collections.addAll(pointList, leftFront, rightFront, rightBack, leftBack);
        //Collections.addAll(startPointList, leftFront.copy(), rightFront.copy(), rightBack.copy(), leftBack.copy());
        
        //test dla wektora normalnego skierowanego na zewnątrz - welug wskazowek zegara
        Collections.addAll(startPointList, rightFront.copy(), leftFront.copy(),  leftBack.copy(), rightBack.copy());
    }

}
