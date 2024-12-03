//first initialize the point set
//define epsilon
//snapping points to an e-grid
//projecting onto directions
    //1.projection along the x-axis
    //2.projection along the y-axis
    //3.projection along the diagonal
//calculate approximate diameter
//e-approximation bound


import java.util.*;

public class LowDimApprox {

    // Generate a random set of points in n-dimensional space
    public static double[][] randomSet(int size, int dimension, int max) {
        double[][] res = new double[size][dimension];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < dimension; j++) {
                res[i][j] = Math.random() * max;
            }
        }
        return res;
    }

    // Calculate the Euclidean distance between two points
    public static double distance(double[] p1, double[] p2) {
        double distance = 0;
        for (int i = 0; i < p1.length; i++) {
            distance += Math.pow((p1[i] - p2[i]), 2);
        }
        return Math.sqrt(distance);
    }

    // Brute force method to calculate the diameter of the set
    public static double diameterBruteForce(double[][] points) {
        double dmax = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {  // Avoid duplicate pairs
                double dist = distance(points[i], points[j]);
                if (dist > dmax) dmax = dist;
            }
        }
        return dmax;
    }

    public static void main(String[] args) {
        // Generate a random set of 2D points
        double[][] points = randomSet(1000, 2, 10);
        double epsilon = 0.1;  // Approximation factor

        // Brute force calculation
        double bruteStart = System.nanoTime();
        double brute = diameterBruteForce(points);
        double bruteEnd = System.nanoTime();
        System.out.println("Brute Force Time: " + (bruteEnd - bruteStart) + " ns");
        System.out.printf("Actual Diameter: %.4f%n", brute);

        // Approximate diameter calculation
        double approxStart = System.nanoTime();
        double approxDiameter = approximateDiameter(points, epsilon);
        double approxEnd = System.nanoTime();
        System.out.println("Approximation Time: " + (approxEnd - approxStart) + " ns");
        System.out.printf("Approximate Diameter: %.4f%n", approxDiameter);

        System.out.println("Approximation Ratio: " + (brute / approxDiameter));
    }

    // Approximate the diameter of the point set
    public static double approximateDiameter(double[][] points, double epsilon) {
        double[][] snappedPoints = snapToGrid(points, epsilon);
        List<double[]> diametricalPairs = findPotentialDiametricalPairs(snappedPoints, epsilon);

        double maxDiameter = 0;
        for (double[] pair : diametricalPairs) {
            double[] p1 = {pair[0], pair[1]};
            double[] p2 = {pair[2], pair[3]};
            double diameter = distance(p1, p2);
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
