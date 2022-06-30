package virtualcamerav2.logic;

public class VectorOperations {
    
    public static double [] normalize(double [] v) {
        double magnitude = Math.sqrt(v[0] * v[0] + v[1] * v[1] + v[2] * v[2]);
        return new double []{v[0]/magnitude - 0, v[1]/magnitude - 0, v[2]/magnitude - 0};
    }

    //iloczyn skalarny
    public static double dot(double [] v1, double [] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
    }
    
    public static double cos(double [] v1, double [] v2) {
        double v1Len = Math.sqrt(v1[0] * v1[0] + v1[1] * v1[1] + v1[2] * v1[2]);
        double v2Len = Math.sqrt(v2[0] * v2[0] + v2[1] * v2[1] + v2[2] * v2[2]);
        return dot(v1, v2) / (v1Len * v2Len);
    }
}
