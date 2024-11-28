
public class Approx {
	static double[][] set;
	
	public static void main(String[] args) {
		double[][] points = {{0,0,0},{0,1,0},{1,0,0},{1,1,0},{1,2,0},{2,1,0},{2,2,0},{3,4,5}};
		set = points;
		double[] p = {0,0};
		System.out.println(distance(p, points[3]));
		System.out.println(distance(p, farthest(p)));
		System.out.println(diameterFast(set, 1));
		System.out.println(diameterRandomized(set, 1));
	}
	
	public static double distance(double[] p1, double[] p2) {
		double distance = 0;
		for (int i = 0;i < p1.length;i++) {
			distance += Math.pow((p1[i] - p2[i]), 2);
		}
		return Math.sqrt(distance);
	}
	
	public static double[] farthest(double[] point) {
		double[] res = new double[point.length];
		double max = 0;
		for (int i = 0;i < set.length;i++) {
			double dist = distance(point, set[i]);
			if (max < dist) {
				res = set[i];
				max = dist; 
			}
		}
		return res;
	}
	
	public static double[] middle(double[] p1, double[] p2) {
		double[] res = p1;
		for (int i = 0;i < res.length;i++) {
			res[i] += p2[i];
			res[i] /= 2;
		}
		return res;
	}
	
	public static double diameterFast(double[][] points, int t) {
		double dmax = 0; int i = 0;
		int k = (int) (Math.random() * points.length);
		double[] p = points[k];
		while (i < t) {
			double rp = distance(p, farthest(p));
			if (rp > dmax) dmax = rp;
			double rfp = distance(farthest(p),farthest(farthest(p)));
			if (rfp > dmax) dmax = rfp;
			double[] q = middle(p, farthest(p));
			double rq = distance(farthest(q), farthest(farthest(q)));
			if (rq > dmax) dmax = rq;
			i++;
			p = farthest(farthest(p));
		}
		return dmax;
	}
	
	public static double diameterRandomized(double[][] points, int t) {
		double dmax = 0; int i = 0;
		int k = (int) (Math.random() * points.length);
		double[] p = points[k];
		while (i < t) {
			double rp = distance(p, farthest(p));
			if (rp > dmax) dmax = rp;
			double[] q = middle(p, farthest(p));
			double rq = distance(farthest(q), farthest(farthest(q)));
			if (rq > dmax) dmax = rq;
			i++;
			k = (int) (Math.random() * 2);
			switch (k) {
			case 0:
				p = farthest(p);
				break;
			case 1:
				p = farthest(farthest(q));
				break;
			}
		}
		return dmax;
	}
}
