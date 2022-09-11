package virtualcamerav2.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import virtualcamerav2.entities.Face;
import virtualcamerav2.entities.GeometricFigure;
import virtualcamerav2.entities.Point3D;

public class FileReader {
    private final ArrayList<Point3D> points;
    private final ArrayList<GeometricFigure> faces;
    
    public FileReader(String path) {
        points = new ArrayList<>();
        faces = new ArrayList<>();
        readFile(path);
    }
    
    private void readFile(String path) {
        File file = new File(path);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                extractDataFromLine(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + path);
        }
    }
    
    private void extractDataFromLine(String nextLine) {
        String[] parts = nextLine.replace("//","").split(" ");
        switch (parts[0]){
            case "v":
                points.add(new Point3D(Double.parseDouble(parts[1]),Double.parseDouble(parts[2]),Double.parseDouble(parts[3])));
                break;
            case "f":
                //faces.add(new Face(points.get(Integer.parseInt(parts[1])-1), points.get(Integer.parseInt(parts[2])-1), points.get(Integer.parseInt(parts[3])-1)));
                faces.add(new Face(points.get(Integer.parseInt(parts[1])-1).copy(), points.get(Integer.parseInt(parts[2])-1).copy(), points.get(Integer.parseInt(parts[3])-1).copy()));
                break;
        }
    }
    
    public ArrayList<GeometricFigure> getFaces() {
        return faces;
    }

    public ArrayList<Point3D> getPoints() {
        return points;
    }
}
