import java.util.List;
import java.util.ArrayList;

public class LowDimApprox {
    // Approximate the diameter of the point set
    public static double approximateDiameter(double[][] points, double epsilon) {
        double[][] snappedPoints = snapToGrid(points, epsilon);
        List<double[]> diametricalPairs = findPotentialDiametricalPairs(snappedPoints, epsilon);

        double maxDiameter = 0;
        for (double[] pair : diametricalPairs) {
            double[] p1 = {pair[0], pair[1]};
            double[] p2 = {pair[2], pair[3]};
            double diameter = Utility.distance(p1, p2);
            maxDiameter = Math.max(maxDiameter, diameter);
        }

        return maxDiameter;
    }

    // Snap points to the nearest epsilon-grid
    public static double[][] snapToGrid(double[][] points, double epsilon) {
        double[][] snappedPoints = new double[points.length][2];
        for (int i = 0; i < points.length; i++) {
            snappedPoints[i][0] = Math.round(points[i][0] / epsilon) * epsilon;
            snappedPoints[i][1] = Math.round(points[i][1] / epsilon) * epsilon;
        }
        return snappedPoints;
    }

    // Identify potential diametrical pairs by projection
    public static List<double[]> findPotentialDiametricalPairs(double[][] points, double epsilon) {
        List<double[]> pairs = new ArrayList<>();

        double[][] directions = {
            {1, 0},  // x-axis
            {0, 1},  // y-axis
            {1, 1},  // diagonal
            {-1, 1}  // anti-diagonal
        };

        for (double[] dir : directions) {
            double maxProj = Double.NEGATIVE_INFINITY;
            double minProj = Double.POSITIVE_INFINITY;
            double[] maxPoint = null, minPoint = null;

            for (double[] point : points) {
                double projection = projectPoint(point, dir);
                if (projection > maxProj) {
                    maxProj = projection;
                    maxPoint = point;
                }
                if (projection < minProj) {
                    minProj = projection;
                    minPoint = point;
                }
            }

            if (maxPoint != null && minPoint != null) {
                pairs.add(new double[]{maxPoint[0], maxPoint[1], minPoint[0], minPoint[1]});
            }
        }
        return pairs;
    }

    // Project a point onto a given direction
    public static double projectPoint(double[] point, double[] direction) {
        return point[0] * direction[0] + point[1] * direction[1];
    }
}
