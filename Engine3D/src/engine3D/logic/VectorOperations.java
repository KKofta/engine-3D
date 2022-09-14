package engine3D.logic;

import engine3D.entities.Point;

public class VectorOperations {
    
    public static double [] normalize(double [] v) {
        double magnitude = Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
        return new double []{v[0]/magnitude - 0, v[1]/magnitude - 0, v[2]/magnitude - 0};
    }
    
    public static double dot(double [] v1, double [] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
    }
    
    public static double cos(double [] v1, double [] v2) {
        double v1Len = Math.sqrt(v1[0] * v1[0] + v1[1] * v1[1] + v1[2] * v1[2]);
        double v2Len = Math.sqrt(v2[0] * v2[0] + v2[1] * v2[1] + v2[2] * v2[2]);
        return dot(v1, v2) / (v1Len * v2Len);
    }
    
    public static double [] getReboundVector(double[] normal, Point light) {
        double t = -(normal[0] * light.getX() + normal[1] * light.getY() + normal[2] * light.getZ()) / (normal[0] * normal[0] + normal[1] * normal[1] + normal[2] * normal[2]);
        double newX = -(2 * (light.getX() + t * normal[0]) - light.getX());
        double newY = -(2 * (light.getY() + t * normal[1]) - light.getY());
        double newZ = -(2 * (light.getZ() + t * normal[2]) - light.getZ());
        return new double[]{newX, newY, newZ};
    }
}
