
public class FastApprox {
	//*****************Approximation Algorithms*****************//
	
	//Fast approximation algorithm:
	public static double diameterFast(double[][] points, int t) {
		//O(m*n) if m is much smaller than n each iteration requires 4*m*n operations
		double dmax = 0; int i = 0;
		int k = (int) (Math.random() * points.length);
		double[] p = points[k];
		while (i < t) {
			double rp = Utility.distance(p, Utility.farthest(p, points));
			if (rp > dmax) dmax = rp;
			double rfp = Utility.distance(Utility.farthest(p, points),Utility.farthest(Utility.farthest(p, points), points));
			if (rfp > dmax) dmax = rfp;
			double[] q = Utility.middle(p, Utility.farthest(p, points));
			double rq = Utility.distance(Utility.farthest(q, points), Utility.farthest(Utility.farthest(q, points), points));
			if (rq > dmax) dmax = rq;
			i++;
			p = Utility.farthest(Utility.farthest(p, points), points);
		}
		return dmax;
	}
	
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
	
	//Brute Force:
	public static double diameterBruteForce(double[][] points) {
		//O(n^2)
		double dmax = 0, distance = 0;
		for (int i = 0;i < points.length;i++) {
			for (int j = 0;j < points.length;j++) {
				distance = Utility.distance(points[i], points[j]);
				if (distance > dmax) dmax = distance;
			}
		}
		return dmax;
	}
	
}
