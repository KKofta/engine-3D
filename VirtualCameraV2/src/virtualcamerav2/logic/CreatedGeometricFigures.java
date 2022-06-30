package virtualcamerav2.logic;

import RightCube.BackWallRight;
import RightCube.DownWallRight;
import RightCube.FrontWallRight;
import RightCube.LeftWallRight;
import RightCube.RightWallRight;
import RightCube.UpWallRight;
import java.util.ArrayList;
import frontCube.BackWall;
import frontCube.DownWall;
import frontCube.FrontWall;
import virtualcamerav2.entities.GeometricFigure;
import frontCube.LeftWall;
import frontCube.RightWall;
import frontCube.UpWall;

public class CreatedGeometricFigures {

    //front cube
    private static GeometricFigure frontWall = new FrontWall();
    private static GeometricFigure backWall = new BackWall();
    private static GeometricFigure upWall = new UpWall();
    private static GeometricFigure downWall = new DownWall();
    private static GeometricFigure leftWall = new LeftWall();
    private static GeometricFigure rightWall = new RightWall();    
    //right cube
    private static GeometricFigure frontWallRight = new FrontWallRight();
    private static GeometricFigure backWallRight = new BackWallRight();
    private static GeometricFigure leftWallRight = new LeftWallRight();
    private static GeometricFigure rightWallRight = new RightWallRight();
    private static GeometricFigure upWallRight = new UpWallRight();
    private static GeometricFigure downWallRight = new DownWallRight();
    
    private static ArrayList<GeometricFigure> figures = new ArrayList<GeometricFigure>() {
        {
            add(frontWall);
            add(upWall);
            add(backWall);
            add(downWall);
            add(leftWall);
            add(rightWall);   
            add(frontWallRight);
            add(leftWallRight);
            add(backWallRight);
            add(rightWallRight);
            add(upWallRight);
            add(downWallRight);
        }
    };

    public static ArrayList<GeometricFigure> getCreatedFigures() {
        return figures;
    }
}
