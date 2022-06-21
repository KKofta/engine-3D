package virtualcamerav2.logic;

import java.util.ArrayList;
import virtualcamerav2.entities.BackWall;
import virtualcamerav2.entities.DownWall;
import virtualcamerav2.entities.FrontWall;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.LeftWall;
import virtualcamerav2.entities.RightWall;
import virtualcamerav2.entities.UpWall;

public class CreatedGeometricFigures {

    private static GeometricFigure frontWall = new FrontWall();
    private static GeometricFigure backWall = new BackWall();
    private static GeometricFigure upWall = new UpWall();
    private static GeometricFigure downWall = new DownWall();
    private static GeometricFigure leftWall = new LeftWall();
    private static GeometricFigure rightWall = new RightWall();
    private static ArrayList<GeometricFigure> figures = new ArrayList<GeometricFigure>() {
        {
            add(frontWall);
            add(upWall);
            add(backWall);
            add(downWall);
            add(leftWall);
            add(rightWall);
        }
    };

    public static ArrayList<GeometricFigure> getCreatedFigures() {
        return figures;
    }
}
