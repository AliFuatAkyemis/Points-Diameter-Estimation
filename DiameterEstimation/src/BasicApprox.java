
public class BasicApprox{
    public static double[] findFarthestPoint(double[] fromPoint, double[][] points) {
        double maxDistance = -1;
        double[] farthestPoint = null;

        for (double[] point : points) {
            double dist = Utility.distance(fromPoint, point);
            if (dist > maxDistance) {
                maxDistance = dist;
                farthestPoint = point;
            }
        }

        return farthestPoint;
    }
    
    public static double algorithmA(double[][]points){
        double[] p = points[0];

        double[] q =findFarthestPoint(p, points);

        double qprime[] = findFarthestPoint(q, points);

        double rq = Utility.distance(q, qprime);

        return rq;
    }   
}

