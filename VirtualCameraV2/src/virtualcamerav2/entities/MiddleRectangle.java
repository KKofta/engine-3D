package virtualcamerav2.entities;

import java.util.Collections;
import javafx.scene.paint.Color;

public class MiddleRectangle extends GeometricFigure { 
    
    public MiddleRectangle() {
        color = Color.DARKORANGE;
        createSquare();
    }

    private void createSquare() {
        //initialize 3D points of the polygon
        Point3D leftUp = new Point3D(-length/2, -length/2, 40.0);
        Point3D rightUp = new Point3D(length, -length/2, 40.0);
        Point3D leftDown = new Point3D(-length/2, length/2, 40.0);
        Point3D rightDown = new Point3D(length, length/2, 40.0);
        
        Collections.addAll(pointList, leftUp, rightUp, rightDown, leftDown);
    }
}
