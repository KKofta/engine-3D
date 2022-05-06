package virtualcamerav2.logic;

public class MatrixOperations {

    private Matrices matrices = new Matrices();

    public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }

    private double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    //perspective projection MRP1 - middle of projection in (0,0,-d), d > 0
    public double[][] projectionMRP1(double[][] vector3D) {
        double[][] MRP1 = matrices.getMRP1();
        //multiply
        double[][] vector2D = multiplyMatrices(MRP1, vector3D);

        //normalisation
        double[][] normalisationMatrix = matrices.normalisationMatrixMRP1(vector3D[2][0]);
        double[][] vector2DNormalized = multiplyMatrices(normalisationMatrix, vector2D);

        return vector2DNormalized;
    }

    //perspective projection MRP2 - middle of projection in (0,0,0)
    public double[][] projectionMRP2(double[][] vector3D) {
        double[][] MRP2 = matrices.getMRP2();
        //multiply
        double[][] vector2D = multiplyMatrices(MRP2, vector3D);

        //normalisation
        double[][] normalisationMatrix = matrices.normalisationMatrixMRP2(vector3D[2][0]);
        double[][] vector2DNormalized = multiplyMatrices(normalisationMatrix, vector2D);

        return vector2DNormalized;
    }

    public double[][] createMatrixMOX(double degree) {
        double radian = Math.toRadians(degree);
        return matrices.MOX(radian);
    }

    public double[][] createMatrixMOY(double degree) {
        double radian = Math.toRadians(degree);
        return matrices.MOY(radian);
    }

    public double[][] createMatrixMOZ(double degree) {
        double radian = Math.toRadians(degree);
        return matrices.MOZ(radian);
    }
}
