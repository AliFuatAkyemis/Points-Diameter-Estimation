
public class RandomizedApprox {
	//Randomized version of fast approximation algorithm:
	public static double diameterRandomized(double[][] points, int t) {
		//O(m*n) each iteration requires 3*m*n operations
		double dmax = 0; int i = 0;
		int k = (int) (Math.random() * points.length);
		double[] p = points[k];
		while (i < t) {
			double rp = Utility.distance(p,Utility.farthest(p, points));
			if (rp > dmax) dmax = rp;
			double[] q = Utility.middle(p, Utility.farthest(p, points));
			double rq = Utility.distance(Utility.farthest(q, points), Utility.farthest(Utility.farthest(q, points), points));
			if (rq > dmax) dmax = rq;
			i++;
			k = (int) (Math.random() * 2);
			switch (k) {
			case 0:
				p = Utility.farthest(p, points);
				break;
			case 1:
				p = Utility.farthest(Utility.farthest(q, points), points);
				break;
			}
		}
		return dmax;
	}
}
