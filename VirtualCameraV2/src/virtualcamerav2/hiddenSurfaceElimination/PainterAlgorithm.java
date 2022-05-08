package virtualcamerav2.hiddenSurfaceElimination;

import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Point3D;

public class PainterAlgorithm {

    ArrayList<GeometricFigure> figures = new ArrayList<>();
    double[] observator = new double[]{0, 0, 0, 1};

    public PainterAlgorithm() {
    }

    public ArrayList<GeometricFigure> SortByPlanes(ArrayList<GeometricFigure> figures) {
        this.figures = figures;
        boolean swapped;
        for (int i = 0; i < figures.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < figures.size() - i - 1; j++) {
                boolean performSwap = checkFigureSide(j);

                if (performSwap) {
                    GeometricFigure temp = figures.get(j);
                    figures.set(j, figures.get(j + 1));
                    figures.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        return figures;
    }

    private boolean checkFigureSide(int index) {
        int sameSide = 0;
        int otherSide = 0;
        
        double[] plane = figures.get(index).calculatePlaneEquation();
        double locationObservator = plane[0] * observator[0] + plane[1] * observator[1] + plane[2] * observator[2] + plane[3] * observator[3];
        System.out.println("observator: " + locationObservator);

        ArrayList<Point3D> list = figures.get(index+1).getFigurePoints();
        int numberOfPoints = list.size();

        for (int i = 0; i < numberOfPoints; i++) {
            double locationPoint = plane[0] * list.get(i).getX() + plane[1] * list.get(i).getY() + plane[2] * list.get(i).getZ() + plane[3];
            System.out.println("Point " + i + " : " + locationPoint);

            if (locationPoint * locationObservator > 0) {
                sameSide++;
            } else {
                otherSide++;
            }
        }
        System.out.println("");

        if (sameSide == numberOfPoints) {//we don't swap
            return false;
        } else if (otherSide == numberOfPoints) {//we swap
            return true;
        } else {
            System.out.println("weszlismy");
            return checkFigureSideReversly(index+1);
        }
    }
    
    private boolean checkFigureSideReversly(int index) {
        int sameSide = 0;
        //int otherSide = 0;
        
        double[] plane = figures.get(index).calculatePlaneEquation();
        double locationObservator = plane[0] * observator[0] + plane[1] * observator[1] + plane[2] * observator[2] + plane[3] * observator[3];
        System.out.println("observator: " + locationObservator);

        ArrayList<Point3D> list = figures.get(index-1).getFigurePoints();
        int numberOfPoints = list.size();

        for (int i = 0; i < numberOfPoints; i++) {
            double locationPoint = plane[0] * list.get(i).getX() + plane[1] * list.get(i).getY() + plane[2] * list.get(i).getZ() + plane[3];

            if (locationPoint * locationObservator > 0) {
                sameSide++;
            }
        }

        return sameSide == numberOfPoints;
    }
}
