package virtualcamera.entities;

public class Point3D {

    private double x;
    private double y;
    private double z;
    private double[][] vector = new double[4][1];

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        updateVector();
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void setX(double x) {
        this.x = x;
        updateVector();
    }

    public void setY(double y) {
        this.y = y;
        updateVector();
    }

    public void setZ(double z) {
        this.z = z;
        updateVector();
    }

    public void updateCoordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        updateVector();
    }

    public double[][] getPointVector() {
        return vector;
    }

    private void updateVector() {
        vector[0][0] = this.x;
        vector[1][0] = this.y;
        vector[2][0] = this.z;
        vector[3][0] = 1;
    }

}
