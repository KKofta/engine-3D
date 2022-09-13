package virtualcamerav2.entities;

import java.util.Collections;

public class Face extends GeometricFigure {
    
    protected Point3D p1;
    protected Point3D p2;
    protected Point3D p3;
    
    public Face(Point3D p1, Point3D p2, Point3D p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        createFace();
    }
    
    private void createFace(){
        Collections.addAll(pointList, this.p3, this.p2, this.p1);
        Collections.addAll(startPointList, this.p3.copy(), this.p2.copy(), this.p1.copy());
    }
}
