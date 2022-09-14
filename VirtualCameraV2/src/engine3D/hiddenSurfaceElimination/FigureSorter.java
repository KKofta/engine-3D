package engine3D.hiddenSurfaceElimination;

import java.util.Comparator;
import engine3D.entities.GeometricFigure;

public class FigureSorter implements Comparator<GeometricFigure>  {

    @Override
    public int compare(GeometricFigure g1, GeometricFigure g2) {
        return findWhichIsFirst(g1, g2);
    }
    
    private int findWhichIsFirst(GeometricFigure g1, GeometricFigure g2) {
        double x1 = (g1.getFigurePoints().get(0).getX() + g1.getFigurePoints().get(1).getX() + g1.getFigurePoints().get(2).getX())/3;
        double y1 = (g1.getFigurePoints().get(0).getY() + g1.getFigurePoints().get(1).getY() + g1.getFigurePoints().get(2).getY())/3;
        double z1 = (g1.getFigurePoints().get(0).getZ() + g1.getFigurePoints().get(1).getZ() + g1.getFigurePoints().get(2).getZ())/3;
        
        double x2 = (g2.getFigurePoints().get(0).getX() + g2.getFigurePoints().get(1).getX() + g2.getFigurePoints().get(2).getX())/3;
        double y2 = (g2.getFigurePoints().get(0).getY() + g2.getFigurePoints().get(1).getY() + g2.getFigurePoints().get(2).getY())/3;
        double z2 = (g2.getFigurePoints().get(0).getZ() + g2.getFigurePoints().get(1).getZ() + g2.getFigurePoints().get(2).getZ())/3;

        double d1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2) + Math.pow(z1, 2));
        double d2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2) + Math.pow(z2, 2));
        return (int) (d2 - d1);
    }
    
}
