package virtualcamerav2.gui;

import virtualcamerav2.logic.CameraMovement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import virtualcamerav2.entities.BackSquare;
import virtualcamerav2.entities.FrontSquare;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.SkewedRectangle;
import virtualcamerav2.hiddenSurfaceElimination.PainterAlgorithm;
import virtualcamerav2.logic.CameraMovementInterface;
import virtualcamerav2.logic.MatrixOperations;

public class GUI extends Application {

    private final double WIDTH = 900.0;
    private final double HEIGHT = 650.0;
    private final double middleX = WIDTH / 2.0;
    private final double middleY = HEIGHT / 2.0;

    private GeometricFigure backSquare = new BackSquare();
    private GeometricFigure frontSquare = new FrontSquare();
    private GeometricFigure skewedRectangle = new SkewedRectangle();
    private ArrayList<GeometricFigure> figures = new ArrayList<GeometricFigure>() {
        {
            add(backSquare);
            add(frontSquare);
            add(skewedRectangle);
        }
    };

    private CameraMovementInterface cameraMovement = new CameraMovement(backSquare);
    private CameraMovementInterface cameraMovement2 = new CameraMovement(frontSquare);
    private CameraMovementInterface cameraMovement3 = new CameraMovement(skewedRectangle);

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
                cameraMovement.translateUp();
                cameraMovement2.translateUp();
                cameraMovement3.translateUp();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DOWN) {
                cameraMovement.translateDown();
                cameraMovement2.translateDown();
                cameraMovement3.translateDown();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.RIGHT) {
                cameraMovement.translateRight();
                cameraMovement2.translateRight();
                cameraMovement3.translateRight();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.LEFT) {
                cameraMovement.translateLeft();
                cameraMovement2.translateLeft();
                cameraMovement3.translateLeft();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.W) {
                cameraMovement.translateForward();
                cameraMovement2.translateForward();
                cameraMovement3.translateForward();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.S) {
                cameraMovement.translateBackward();
                cameraMovement2.translateBackward();
                cameraMovement3.translateBackward();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT1) {
                cameraMovement.pivotOX(1);//pivot down
                cameraMovement2.pivotOX(1);//pivot down
                cameraMovement3.pivotOX(1);//pivot down
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT2) {
                cameraMovement.pivotOX(-1);//pivot up
                cameraMovement2.pivotOX(-1);//pivot up
                cameraMovement3.pivotOX(-1);//pivot up
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT3) {
                cameraMovement.pivotOY(1);//pivot left
                cameraMovement2.pivotOY(1);//pivot left
                cameraMovement3.pivotOY(1);//pivot left
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT4) {
                cameraMovement.pivotOY(-1);//pivot right
                cameraMovement2.pivotOY(-1);//pivot right
                cameraMovement3.pivotOY(-1);//pivot right
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT5) {
                cameraMovement.pivotOZ(1);//piviot left
                cameraMovement2.pivotOZ(1);//piviot left
                cameraMovement3.pivotOZ(1);//piviot left
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT6) {
                cameraMovement.pivotOZ(-1);//pivot right
                cameraMovement2.pivotOZ(-1);//pivot right
                cameraMovement3.pivotOZ(-1);//pivot right
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.Q) {
                cameraMovement.zoomIn();
                cameraMovement2.zoomIn();
                cameraMovement3.zoomIn();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.A) {
                cameraMovement.zoomOut();
                cameraMovement2.zoomOut();
                cameraMovement3.zoomOut();
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
    
    private void sortFigures(){
        PainterAlgorithm painterAlgorithm = new PainterAlgorithm(figures);
        figures = painterAlgorithm.SortByZCoordinate();
        //painterAlgorithm.SortByZCoordinate(figures);
    }

    private void projectAndDrawAllPolygons() {        
        for (GeometricFigure figure : figures) {
            projectAndDrawSinglePolygon(figure);
        }
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
        polygon.setFill(figure.getColor());
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
