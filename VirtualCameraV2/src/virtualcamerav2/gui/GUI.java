package virtualcamerav2.gui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Observator;
import virtualcamerav2.entities.Point3D;
import virtualcamerav2.hiddenSurfaceElimination.PainterAlgorithm;
import virtualcamerav2.logic.CreatedGeometricFigures;
import virtualcamerav2.logic.MatrixOperations;
import virtualcamerav2.logic.CameraMovement;

public class GUI extends Application {

    private final double WIDTH = 900.0;
    private final double HEIGHT = 650.0;
    private final double middleX = WIDTH / 2.0;
    private final double middleY = HEIGHT / 2.0;

    private ArrayList<GeometricFigure> figures = CreatedGeometricFigures.getCreatedFigures();
    private Observator observator = new Observator(0,0,0);
    private Point3D light = new Point3D(1,2,3);
    private CameraMovement cameraMovement = new CameraMovement(figures, observator, light);
    private PainterAlgorithm painterAlgorithm = new PainterAlgorithm();
    private ArrayList<Polygon> polygons = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        sortFigures();
        projectAndDrawAllPolygons();

        Group root = new Group();
        root.getChildren().addAll(polygons);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.UP) {
                cameraMovement.TranslateUp();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DOWN) {
                cameraMovement.TranslateDown();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.RIGHT) {
                cameraMovement.TranslateRight();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.LEFT) {
                cameraMovement.TranslateLeft();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.W) {
                cameraMovement.TranslateForward();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.S) {
                cameraMovement.TranslateBackward();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT1) {
                cameraMovement.PivotOX(2);
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT2) {
                cameraMovement.PivotOX(-2);
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT3) {
                cameraMovement.PivotOY(2);
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT4) {
                cameraMovement.PivotOY(-2);
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT5) {
                cameraMovement.PivotOZ(2);
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT6) {
                cameraMovement.PivotOZ(-2);
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.Q) {
                cameraMovement.zoomIn();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.A) {
                cameraMovement.zoomOut();
                applyChangesToGraphics(root);
            }
            event.consume();
        });

        primaryStage.setTitle("Virtual Camera");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void applyChangesToGraphics(Group root) {
        root.getChildren().removeAll(polygons);
        sortFigures();
        clearPolygons();
        projectAndDrawAllPolygons();
        root.getChildren().addAll(polygons);
    }

    private void sortFigures() {
        figures = painterAlgorithm.SortByPlanes(figures, observator);
    }

    private void projectAndDrawAllPolygons() {
        figures.forEach(figure -> {
            projectAndDrawSinglePolygon(figure);
        });
    }

    private void projectAndDrawSinglePolygon(GeometricFigure figure) {
        MatrixOperations mathHelper = new MatrixOperations();
        double[][] pointVector3D;
        double[][] pointVectorNormalized2D;

        for (int i = 0; i < figure.getFigurePoints().size(); i++) {
            //take vectors           
            pointVector3D = figure.getFigurePoints().get(i).getPointVector();

            //rzutowanie            
            pointVectorNormalized2D = mathHelper.projectionMRP2(pointVector3D);

            //drawing            
            double X = centreXCoordinate(pointVectorNormalized2D[0][0]);
            double Y = centreYCoordinate(pointVectorNormalized2D[1][0]);

            updatePolygonPoints(figure, X, Y, i);
        }
        drawPolygon(figure);
    }

    private void updatePolygonPoints(GeometricFigure figure, double X, double Y, int i) {
        if (i == 0) {
            figure.setPolygonPoint(X, 0);
            figure.setPolygonPoint(Y, 1);
        } else {
            figure.setPolygonPoint(X, i * 2);
            figure.setPolygonPoint(Y, i * 2 + 1);
        }
    }

    private void drawPolygon(GeometricFigure figure) {
        Polygon polygon = new Polygon(figure.getPolygonPoints());
        polygon.setFill(figure.updateAndGetColor(observator, light));
        polygon.setStroke(Color.BLACK);
        polygons.add(polygon);
    }

    private void clearPolygons() {
        polygons.clear();
    }

    private double centreXCoordinate(double x) {
        return x + middleX;
    }

    private double centreYCoordinate(double y) {
        return y + middleY;
    }
}
