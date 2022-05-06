package virtualcamerav2.entities;

public class Line3D {

    private Point3D startPoint;
    private Point3D endPoint;

    public Line3D(Point3D startPoint, Point3D endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point3D getLine3DStartPoint() {
        return startPoint;
    }

    public Point3D getLine3DEndPoint() {
        return endPoint;
    }
}
