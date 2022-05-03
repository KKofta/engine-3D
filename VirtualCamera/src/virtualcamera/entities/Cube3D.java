package virtualcamera.entities;

import java.util.ArrayList;
import java.util.Collections;

public class Cube3D {

    private final double length = 50;
    private ArrayList<Line3D> lineList = new ArrayList<>();

    public Cube3D() {
        createCube();
    }

    private void createCube() {
        //initialize 3D points of the front wall 
        Point3D frontLeftUp = new Point3D(-length, -length, 50.0);
        Point3D frontRightUp = new Point3D(length, -length, 50.0);
        Point3D frontLeftDown = new Point3D(-length, length, 50.0);
        Point3D frontRightDown = new Point3D(length, length, 50.0);

        //initialize 3D points of the back wall
        Point3D backLeftUp = new Point3D(-length, -length, 150.0);
        Point3D backRightUp = new Point3D(length, -length, 150.0);
        Point3D backLeftDown = new Point3D(-length, length, 150.0);
        Point3D backRightDown = new Point3D(length, length, 150.0);

        //initialize 3D lines of the front wall
        Line3D frontUp = new Line3D(frontLeftUp, frontRightUp);
        Line3D frontDown = new Line3D(frontLeftDown, frontRightDown);
        Line3D frontLeft = new Line3D(frontLeftUp, frontLeftDown);
        Line3D frontRight = new Line3D(frontRightUp, frontRightDown);

        //initialize 3D lines of the back wall
        Line3D backUp = new Line3D(backLeftUp, backRightUp);
        Line3D backDown = new Line3D(backLeftDown, backRightDown);
        Line3D backLeft = new Line3D(backLeftUp, backLeftDown);
        Line3D backRight = new Line3D(backRightUp, backRightDown);

        //initialize 3D lines the 'middle'
        Line3D middleLeftUp = new Line3D(frontLeftUp, backLeftUp);
        Line3D middleRightUp = new Line3D(frontRightUp, backRightUp);
        Line3D middleLeftDown = new Line3D(frontLeftDown, backLeftDown);
        Line3D middleRightDown = new Line3D(frontRightDown, backRightDown);

        //initialize list of lines
        Collections.addAll(lineList, frontUp, frontDown, frontLeft, frontRight,
                backUp, backDown, backLeft, backRight,
                middleLeftUp, middleRightUp, middleLeftDown, middleRightDown);
    }

    public ArrayList<Line3D> getCubeLines() {
        return lineList;
    }

}
