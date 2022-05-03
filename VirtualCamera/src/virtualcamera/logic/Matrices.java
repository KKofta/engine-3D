package virtualcamera.logic;

import virtualcamera.entities.MiddleOfProjection;

public class Matrices {
    
    double d = MiddleOfProjection.getD();

    //MRP1 matrix for perspective projection MRP1 - middle of projection in (0,0,-d), d > 0
    private double[][] MRP1 = new double[][]{
        {1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 1 / d, 1}
    };

    public double[][] getMRP1() {
        return MRP1;
    }

    public double[][] normalisationMatrixMRP1(double zp) {
        double[][] normalisationMatrix = new double[][]{
            {d / (zp + d), 0, 0, 0},
            {0, d / (zp + d), 0, 0},
            {0, 0, d / (zp + d), 0},
            {0, 0, 0, d / (zp + d)}
        };
        return normalisationMatrix;
    }

    //MRP2 matrix for perspective projection MRP2 - middle of projection in (0,0,0)
    private double[][] MRP2 = new double[][]{
        {1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 1 / d, 0}
    };

    public double[][] getMRP2() {
        return MRP2;
    }

    public double[][] normalisationMatrixMRP2(double zp) {
        double[][] normalisationMatrix = new double[][]{
            {d / zp, 0, 0, 0},
            {0, d / zp, 0, 0},
            {0, 0, d / zp, 0},
            {0, 0, 0, d / zp}
        };
        return normalisationMatrix;
    }

    //matrix for pivot around OX
    public double[][] MOX(double radian) {
        double[][] MOX = new double[][]{
            {1, 0, 0, 0},
            {0, Math.cos(radian), -Math.sin(radian), 0},
            {0, Math.sin(radian), Math.cos(radian), 0},
            {0, 0, 0, 1}
        };
        return MOX;
    }

    //matrix for pivot around OY
    public double[][] MOY(double radian) {
        double[][] MOY = new double[][]{
            {Math.cos(radian), 0, Math.sin(radian), 0},
            {0, 1, 0, 0},
            {-Math.sin(radian), 0, Math.cos(radian), 0},
            {0, 0, 0, 1}
        };
        return MOY;
    }

    //matrix for pivot around OZ
    public double[][] MOZ(double radian) {
        double[][] MOZ = new double[][]{
            {Math.cos(radian), -Math.sin(radian), 0, 0},
            {Math.sin(radian), Math.cos(radian), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        return MOZ;
    }
}
