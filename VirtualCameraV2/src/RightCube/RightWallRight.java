package RightCube;

import java.util.Collections;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Point3D;

public class RightWallRight extends GeometricFigure {

    public RightWallRight() {
        name = "RightWallRight";
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the polygon        
        Point3D frontUp = new Point3D(length*1.5+length, -length, 50.0);
        Point3D backUp = new Point3D(length*1.5+length, -length, 150.0);
        Point3D frontDown = new Point3D(length*1.5+length, length, 50.0);
        Point3D backDown = new Point3D(length*1.5+length, length, 150.0);

        Collections.addAll(pointList, frontUp, backUp, backDown, frontDown);
        Collections.addAll(startPointList, frontUp.copy(), backUp.copy(), backDown.copy(), frontDown.copy());
    }
}
