package virtualcamerav2.hiddenSurfaceElimination;

import java.util.ArrayList;
import virtualcamerav2.entities.GeometricFigure;

public class PainterAlgorithm {

    ArrayList<GeometricFigure> figures = new ArrayList<>();

    public PainterAlgorithm(ArrayList<GeometricFigure> figures) {
        this.figures = figures;
    }

    public ArrayList<GeometricFigure> SortByZCoordinate() {
        boolean swapped;
        for (int i = 0; i < figures.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < figures.size() - i - 1; j++) {
                if (figures.get(j).getBiggestZ() <= figures.get(j+1).getSmallestZ()) {
                    //we change places since j is being drawn later
                    GeometricFigure temp = figures.get(j);
                    figures.set(j, figures.get(j + 1));
                    figures.set(j + 1, temp);
                    swapped = true;
                } else if (figures.get(j).getSmallestZ() >= figures.get(j+1).getBiggestZ()) {
                    //it is fine since j is being drawn earlier so it's first in the list
                }

                if (swapped == false) {
                    break;
                }
            }
        }
        return figures;
    }
}
