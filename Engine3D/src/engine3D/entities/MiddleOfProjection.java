package engine3D.entities;

public class MiddleOfProjection {

    private static double D = 400.0;

    public static void increaseD() {
        D += 10.0;
    }

    public static void decreaseD() {
        D -= 10.0;
    }
    
    public static double getD(){
        return D;
    }
}
