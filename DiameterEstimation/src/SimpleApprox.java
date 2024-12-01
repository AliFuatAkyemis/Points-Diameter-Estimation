import java.util.List;

public class SimpleApprox {
    public static double calculateApproximateDiameter(List<Point> points, int n) {
        if (points.size() < 2) return 0;

        Point origin = points.get(0);
        double[] maxDistances = new double[6 * n];

        for (Point p : points) {
            double angle = p.angle(origin);
            int sectorIndex = (int) ((angle + Math.PI) / (2 * Math.PI) * 6 * n);
            sectorIndex = Math.min(sectorIndex, 6 * n - 1);
            double dist = origin.distance(p);
            maxDistances[sectorIndex] = Math.max(maxDistances[sectorIndex], dist);
        }

        double maxDistance = 0;
        for (int i = 0; i < maxDistances.length; i++) {
            for (int j = i + 1; j < maxDistances.length; j++) {
                maxDistance = Math.max(maxDistance, maxDistances[i] + maxDistances[j]);
            }
        }

        return maxDistance;
    }
}
