package virtualcamera.gui;

import virtualcamera.logic.CameraMovement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import virtualcamera.entities.Line3D;
import virtualcamera.logic.CameraMovementInterface;
import virtualcamera.logic.MatrixOperations;

public class GUI extends Application {

    private final double WIDTH = 900.0;
    private final double HEIGHT = 650.0;
    private final double middleX = WIDTH / 2.0;
    private final double middleY = HEIGHT / 2.0;
    private ArrayList<Line> drawingLines = new ArrayList<>();
    private CameraMovementInterface cameraMovement = new CameraMovement();
    private ArrayList<Line3D> lines3DList;

    @Override
    public void start(Stage primaryStage) {
        projectAndDraw();

        Group root = new Group();
        root.getChildren().addAll(drawingLines);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.UP) {
                cameraMovement.translateUp();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DOWN) {
                cameraMovement.translateDown();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.RIGHT) {
                cameraMovement.translateRight();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.LEFT) {
                cameraMovement.translateLeft();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.W) {
                cameraMovement.translateForward();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.S) {
                cameraMovement.translateBackward();
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT1) {
                cameraMovement.pivotOX(1);//pivot down
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT2) {
                cameraMovement.pivotOX(-1);//pivot up
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT3) {
                cameraMovement.pivotOY(1);//pivot left
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT4) {
                cameraMovement.pivotOY(-1);//pivot right
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT5) {
                cameraMovement.pivotOZ(1);//piviot left
                applyChangesToGraphics(root);
            } else if (event.getCode() == KeyCode.DIGIT6) {
                cameraMovement.pivotOZ(-1);//pivot right
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
        root.getChildren().removeAll(drawingLines);
        clearLines();
        projectAndDraw();
        root.getChildren().addAll(drawingLines);
    }

    private void projectAndDraw() {
        lines3DList = cameraMovement.getLines3DList();
        MatrixOperations mathHelper = new MatrixOperations();

        double[][] startPointVector3D;
        double[][] endPointVector3D;
        double[][] startPointVector2DNormalized;
        double[][] endPointVector2DNormalized;

        for (int i = 0; i < lines3DList.size(); i++) {
            //take vectors
            startPointVector3D = lines3DList.get(i).getLine3DStartPoint().getPointVector();
            endPointVector3D = lines3DList.get(i).getLine3DEndPoint().getPointVector();

            //rzutowanie
            startPointVector2DNormalized = mathHelper.projectionMRP2(startPointVector3D);
            endPointVector2DNormalized = mathHelper.projectionMRP2(endPointVector3D);

            //drawing
            double startX = centreXCoordinate(startPointVector2DNormalized[0][0]);
            double startY = centreYCoordinate(startPointVector2DNormalized[1][0]);
            double endX = centreXCoordinate(endPointVector2DNormalized[0][0]);
            double endY = centreYCoordinate(endPointVector2DNormalized[1][0]);

            drawLine(startX, startY, endX, endY);
        }
    }

    private void drawLine(double startX, double startY, double endX, double endY) {
        Line line = new Line(startX, startY, endX, endY);
        drawingLines.add(line);
    }

    private void clearLines() {
        drawingLines.clear();
    }

    private double centreXCoordinate(double x) {
        return x + middleX;
    }

    private double centreYCoordinate(double y) {
        return y + middleY;
    }
}
