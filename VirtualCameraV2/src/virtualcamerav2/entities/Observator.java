package virtualcamerav2.entities;

public class Observator extends Point3D {
    
    private double angleXZ = 0; 
    private double angleYZ = 0; 
    private double angleXY = 0; 
    private final double DISTANCE = 6.0;
    
    private double radianXZ = Math.toRadians(angleXZ);
    private double radianYZ = Math.toRadians(angleYZ);
    private double radianXY = Math.toRadians(angleXY);

    public Observator(double x, double y, double z) {
        super(x, y, z);
    }
    
    public void moveRight(){
        super.setX(super.getX() + Math.cos(radianXZ)*DISTANCE);
        super.setZ(super.getZ() + Math.sin(radianXZ)*DISTANCE);
    }
    
    public void moveLeft(){
        super.setX(super.getX() -  Math.cos(radianXZ)*DISTANCE);
        super.setZ(super.getZ() - Math.sin(radianXZ)*DISTANCE);
    }
    
    public void moveUp(){
        super.setY(super.getY() - Math.cos(radianYZ)*DISTANCE);
        super.setZ(super.getZ() + Math.sin(radianYZ)*DISTANCE);
    }
    
    public void moveDown(){
        super.setY(super.getY() + Math.cos(radianYZ)*DISTANCE);
        super.setZ(super.getZ() - Math.sin(radianYZ)*DISTANCE);
    }
    
    public void moveForward(){
        super.setX(super.getX() - Math.sin(radianXZ)*Math.cos(radianYZ)*DISTANCE);
        super.setY(super.getY() + Math.sin(radianYZ)*DISTANCE);
        super.setZ(super.getZ() + Math.cos(radianXZ)*Math.cos(radianYZ)*DISTANCE);
    }
    
    public void moveBackward(){
        super.setX(super.getX() + Math.sin(radianXZ)*Math.cos(radianYZ)*DISTANCE);
        super.setY(super.getY() - Math.sin(radianYZ)*DISTANCE);
        super.setZ(super.getZ() - Math.cos(radianXZ)*Math.cos(radianYZ)*DISTANCE);
    }
    
    public void changAngleXZ(double degree){
        angleXZ += degree;
        radianXZ = Math.toRadians(angleXZ);
    }
    
    public void changAngleYZ(double degree){
        angleYZ += degree;
        radianYZ = Math.toRadians(angleYZ);
    }
    
    public void changAngleXY(double degree){
        angleXY += degree;
        radianXY = Math.toRadians(angleXY);
    }
    
    //test method
    public void showAngles(){
        System.out.println("XZ: "+angleXZ + " YZ: "+angleYZ + " XY: "+angleXY);
    }

}
