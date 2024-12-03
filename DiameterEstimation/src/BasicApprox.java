//first initialize the point set
//choose an arbitrary point from set (lets named p this point)
//find the farthest point to the p(name is q)
//find the farthest point to the q(name is q')
//Return the distance r_q=d(q,q')

/// The distance r_q =d(q,q') is returned as the approximation of the diameter.
/// The theorem guarantess that r_q<= d_p<=3^1/2.r_q, so the true diameter lies between r_q and 3^1/2.r_q


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
    //Distance between 2 given points:
		public static double distance(double[] p1, double[] p2) {
			//O(m)
			double distance = 0;
			for (int i = 0;i < p1.length;i++) {
				distance += Math.pow((p1[i] - p2[i]), 2);
			}
			return Math.sqrt(distance);
		}

    
    public static double algorithmA(double[][]points){
        double[] p = points[0];

        double[] q =findFarthestPoint(p, points);

        double qprime[] = findFarthestPoint(q, points);

        double rq = Utility.distance(q, qprime);

        return rq;
    }   
}

