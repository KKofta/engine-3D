package engine3D.hiddenSurfaceElimination;

import java.util.ArrayList;
import engine3D.entities.GeometricFigure;
import engine3D.entities.Point;

public class PainterAlgorithm {
    
    private double [] observator  = new double[]{0,0,0};

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
        double locationObservator = plane[0] * observator[0] + plane[1] * observator[1] + plane[2] * observator[2] + plane[3];

        ArrayList<Point> listOfPoints = figures.get(index+1).getFigureStartPoints();
        int numberOfPoints = listOfPoints.size();

        for (int i = 0; i < numberOfPoints; i++) {
            double locationPoint = plane[0] * listOfPoints.get(i).getX() + plane[1] * listOfPoints.get(i).getY() + plane[2] * listOfPoints.get(i).getZ() + plane[3];
            
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
        double locationObservator = plane[0] * observator[0] + plane[1] * observator[1] + plane[2] * observator[2] + plane[3];

        ArrayList<Point> pointList = figures.get(index-1).getFigureStartPoints();
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
