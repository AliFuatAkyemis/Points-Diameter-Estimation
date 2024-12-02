import java.util.Arrays;

public class BetterApprox {
    public static double calculateDiameter(double[][] points, double epsilon) {
        int n = points.length;
        int d = points[0].length;
        double maxDiameter = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = Utility.distance(points[i], points[j]);
                if (dist > maxDiameter) {
                    maxDiameter = dist;
                }
            }
        }
        return maxDiameter * (1 + epsilon);
    }
    
    public static double[][] roundToGrid(double[][] points, double gridSize) {
        int n = points.length;
        int d = points[0].length;
        double[][] roundedPoints = new double[n][d];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                roundedPoints[i][j] = Math.round(points[i][j] / gridSize) * gridSize;
            }
        }
        return roundedPoints;
    }
}
