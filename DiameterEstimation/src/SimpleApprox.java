import java.util.List;

public class SimpleApprox {
    public static double calculateApproximateDiameter(List<Point> points, int n) {
        if (points.size() < 2) return 0;
        double sumX = 0, sumY = 0;
        for (Point p : points) {
        	sumX += p.x;sumY += p.y;
        }
        Point origin = new Point((sumX/points.size()), (sumY/points.size()));
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

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public double angle(Point origin) {
        return Math.atan2(this.y - origin.y, this.x - origin.x);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
