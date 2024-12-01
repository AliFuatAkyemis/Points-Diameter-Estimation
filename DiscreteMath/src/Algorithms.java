
public class Algorithms {
	private static double[][] set;
	private static Utility u = new Utility();
	
	public static void main(String[] args) {
		set = u.randomSet(500000,2,100);
		double start = 0, end = 0, time1 = 0, time2 = 0, time3 = 0, result1 = 0, result2 = 0, result3 = 0;
		start = System.currentTimeMillis();
		result1 = diameterFast(set, 1);
		end = System.currentTimeMillis();
		time1 = end - start;
		start = System.currentTimeMillis();
		result2 = diameterRandomized(set, 1);
		end = System.currentTimeMillis();
		time2 = end - start;
//		start = System.currentTimeMillis();
//		result3 = diameterBruteForce(set);
//		end = System.currentTimeMillis();
//		time3 = end - start;
		System.out.println("Fast: " + time1);
//		System.out.println(result1);
		System.out.println("Randomized: " + time2);
//		System.out.println(result2);
//		System.out.println("Brute Force: " + time3);
//		System.out.println(result3);
	}
	
	//*****************Approximation Algorithms*****************//
	
	//*****************AliFuatAkyemiş*****************//
	
	//Fast approximation algorithm:
	public static double diameterFast(double[][] points, int t) {
		//O(m*n) if m is much smaller than n each iteration requires 4*m*n operations
		double dmax = 0; int i = 0;
		int k = (int) (Math.random() * points.length);
		double[] p = points[k];
		while (i < t) {
			double rp = u.distance(p, u.farthest(p, set));
			if (rp > dmax) dmax = rp;
			double rfp = u.distance(u.farthest(p, set),u.farthest(u.farthest(p, set), set));
			if (rfp > dmax) dmax = rfp;
			double[] q = u.middle(p, u.farthest(p, set));
			double rq = u.distance(u.farthest(q, set), u.farthest(u.farthest(q, set), set));
			if (rq > dmax) dmax = rq;
			i++;
			p = u.farthest(u.farthest(p, set), set);
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
			double rp = u.distance(p, u.farthest(p, set));
			if (rp > dmax) dmax = rp;
			double[] q = u.middle(p, u.farthest(p, set));
			double rq = u.distance(u.farthest(q, set), u.farthest(u.farthest(q, set), set));
			if (rq > dmax) dmax = rq;
			i++;
			k = (int) (Math.random() * 2);
			switch (k) {
			case 0:
				p = u.farthest(p, set);
				break;
			case 1:
				p = u.farthest(u.farthest(q, set), set);
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
				distance = u.distance(points[i], points[j]);
				if (distance > dmax) dmax = distance;
			}
		}
		return dmax;
	}
	
	//*****************ZulalBozyel*****************//
	
	//*****************MelikeEsraÖz*****************//
	
	//*****************HüseyinMertAfşarlı*****************//
	
	//*****************RamazanŞahin*****************//
	
}
