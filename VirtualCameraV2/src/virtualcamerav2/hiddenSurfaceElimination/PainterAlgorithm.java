package virtualcamerav2.hiddenSurfaceElimination;

import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Point3D;

public class PainterAlgorithm {
    
    double[] observator = new double[]{0, 0, 0, 1};

    public ArrayList<GeometricFigure> SortByPlanes(ArrayList<GeometricFigure> figures) {
        boolean swapped;
        for (int i = 0; i < figures.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < figures.size() - i - 1; j++) {
                boolean performSwap = checkFigureSide(j, figures);

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

    private boolean checkFigureSide(int index, ArrayList<GeometricFigure> figures) {
        int sameSide = 0;
        int otherSide = 0;
        
        double[] plane = figures.get(index).calculatePlaneEquation();
        double locationObservator = plane[0] * observator[0] + plane[1] * observator[1] + plane[2] * observator[2] + plane[3] * observator[3];

        ArrayList<Point3D> list = figures.get(index+1).getFigurePoints();
        int numberOfPoints = list.size();

        for (int i = 0; i < numberOfPoints; i++) {
            double locationPoint = plane[0] * list.get(i).getX() + plane[1] * list.get(i).getY() + plane[2] * list.get(i).getZ() + plane[3];
            
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
        double locationObservator = plane[0] * observator[0] + plane[1] * observator[1] + plane[2] * observator[2] + plane[3] * observator[3];

        ArrayList<Point3D> list = figures.get(index-1).getFigurePoints();
        int numberOfPoints = list.size();

        for (int i = 0; i < numberOfPoints; i++) {
            double locationPoint = plane[0] * list.get(i).getX() + plane[1] * list.get(i).getY() + plane[2] * list.get(i).getZ() + plane[3];
            
            if (locationPoint * locationObservator >= 0) {
                sameSide++;
            }
        }

        return sameSide == numberOfPoints;
    }
}
