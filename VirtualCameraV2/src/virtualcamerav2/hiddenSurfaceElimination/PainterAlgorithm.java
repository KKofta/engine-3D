package virtualcamerav2.hiddenSurfaceElimination;

import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Observator;
import virtualcamerav2.entities.Point3D;

public class PainterAlgorithm {
    
    Observator observator;

    public ArrayList<GeometricFigure> SortByPlanes(ArrayList<GeometricFigure> figures, Observator observator) {
        this.observator = observator;
        
        boolean swapped;
        for (int i = 0; i < figures.size() - 1; i++) {
            swapped = false;
            //System.out.println("Iteration: "+i);
            for (int j = 0; j < figures.size() - i - 1; j++) {
                boolean performSwap = checkFigureSide(j, figures);

                if (performSwap) {
                    GeometricFigure temp = figures.get(j);
                    figures.set(j, figures.get(j + 1));
                    figures.set(j + 1, temp);
                    swapped = true;
                    //System.out.println("Swapped");
                }
            }
            if (swapped == false) {
                break;
            }
        }
        //System.out.println("-----------------------------------------------------------------------");
        return figures;
    }

    private boolean checkFigureSide(int index, ArrayList<GeometricFigure> figures) {
        //---------------- start testing area -------------------------
        /*System.out.println("---checkFigureSide--- : "+ figures.get(index).getName() + " | " + figures.get(index+1).getName());
        ArrayList<Point3D> figure1Points = new ArrayList(figures.get(index).getFigureStartPoints());
        ArrayList<Point3D>  figure2Points = new ArrayList(figures.get(index+1).getFigureStartPoints());
        System.out.println("Figure 1:"+figures.get(index).getName());
        System.out.println(Arrays.deepToString(figure1Points.get(0).getPointVector()));
        System.out.println(Arrays.deepToString(figure1Points.get(1).getPointVector()));
        System.out.println(Arrays.deepToString(figure1Points.get(2).getPointVector()));
        System.out.println(Arrays.deepToString(figure1Points.get(3).getPointVector()));
        System.out.println("Figure 2:"+figures.get(index+1).getName());
        System.out.println(Arrays.deepToString(figure2Points.get(0).getPointVector()));
        System.out.println(Arrays.deepToString(figure2Points.get(1).getPointVector()));
        System.out.println(Arrays.deepToString(figure2Points.get(2).getPointVector()));
        System.out.println(Arrays.deepToString(figure2Points.get(3).getPointVector()));
        System.out.println("Observator:");
        System.out.println(observator.getX()+", "+observator.getY() +", "+ observator.getZ());
        observator.showAngles();*/
        //---------------- end testing area -------------------------
        
        int sameSide = 0;
        int otherSide = 0;
        
        double[] plane = figures.get(index).calculatePlaneEquation();
        double locationObservator = plane[0] * observator.getX() + plane[1] * observator.getY() + plane[2] * observator.getZ() + plane[3];

        ArrayList<Point3D> listOfPoints = figures.get(index+1).getFigureStartPoints();
        int numberOfPoints = listOfPoints.size();

        for (int i = 0; i < numberOfPoints; i++) {
            double locationPoint = plane[0] * listOfPoints.get(i).getX() + plane[1] * listOfPoints.get(i).getY() + plane[2] * listOfPoints.get(i).getZ() + plane[3];
            
            //System.out.println(locationPoint + " * " + locationObservator + " = "+ locationPoint*locationObservator);
            if (locationPoint * locationObservator > 0) {
                sameSide++;
            } else if (locationPoint * locationObservator < 0) {
                otherSide++;
            } else {
                sameSide++;
                otherSide++;
            }
        }

        if (sameSide == numberOfPoints) {//we don't swap
            return false;
        } else if (otherSide == numberOfPoints) {//we swap
            return true;
        } else {
            return checkFigureSideReversly(index+1, figures);
        }
    }
    
    private boolean checkFigureSideReversly(int index, ArrayList<GeometricFigure> figures) {
        int sameSide = 0;
        
        double[] plane = figures.get(index).calculatePlaneEquation();
        double locationObservator = plane[0] * observator.getX() + plane[1] * observator.getY() + plane[2] * observator.getZ() + plane[3];

        ArrayList<Point3D> pointList = figures.get(index-1).getFigureStartPoints();
        int numberOfPoints = pointList.size();

        for (int i = 0; i < numberOfPoints; i++) {
            double locationPoint = plane[0] * pointList.get(i).getX() + plane[1] * pointList.get(i).getY() + plane[2] * pointList.get(i).getZ() + plane[3];
            
            if (locationPoint * locationObservator >= 0) {
                sameSide++;
            }
        }

        return sameSide == numberOfPoints;
    }
}
