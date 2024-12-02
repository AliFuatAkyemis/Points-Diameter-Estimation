
public class ApproximateDiameter {
    public static double approximateDiameter(double[][] points, double epsilon) {
        // Step 1: Snap points to epsilon-grid
        double[][] snappedPoints = snapToGrid(points, epsilon);
        
        // Step 2: Project onto multiple directions
        double maxDiameter = 0;
        double[] directionsX = {1, 0, 1};  // Projections: x-axis, y-axis, diagonal (x+y)
        double[] directionsY = {0, 1, 1};
        
        for (int i = 0; i < directionsX.length; i++) {
            double maxProjection = Double.NEGATIVE_INFINITY;
            double minProjection = Double.POSITIVE_INFINITY;
            
            for (double[] point : snappedPoints) {
                double projection = point[0] * directionsX[i] + point[1] * directionsY[i];
                maxProjection = Math.max(maxProjection, projection);
                minProjection = Math.min(minProjection, projection);
            }
            
            double diameter = maxProjection - minProjection;
            maxDiameter = Math.max(maxDiameter, diameter);
        }
        
        return maxDiameter;
    }
    
    public static double[][] snapToGrid(double[][] points, double epsilon) {
        double[][] snappedPoints = new double[points.length][2];
        for (int i = 0; i < points.length; i++) {
            snappedPoints[i][0] = Math.round(points[i][0] / epsilon) * epsilon;
            snappedPoints[i][1] = Math.round(points[i][1] / epsilon) * epsilon;
        }
        return snappedPoints;
    }
}
