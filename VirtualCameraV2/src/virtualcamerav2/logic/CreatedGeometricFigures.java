package virtualcamerav2.logic;

import java.util.ArrayList;
import virtualcamerav2.entities.BackSquare;
import virtualcamerav2.entities.FrontSquare;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.SkewedRectangle;

public class CreatedGeometricFigures {

    private static GeometricFigure backSquare = new BackSquare();
    private static GeometricFigure frontSquare = new FrontSquare();
    private static GeometricFigure skewedRectangle = new SkewedRectangle();
    private static ArrayList<GeometricFigure> figures = new ArrayList<GeometricFigure>() {
        {
            add(backSquare);
            add(frontSquare);
            add(skewedRectangle);
        }
    };

    public static ArrayList<GeometricFigure> getCreatedFigures() {
        return figures;
    }
}