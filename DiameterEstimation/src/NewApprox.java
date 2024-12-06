
public class NewApprox {
	public static double diameterNew(double[][] set, int n) {
		double[][] sample = new double[set.length][set[0].length];
		for (int i = 0;i < n;i++) {
			sample[i] = set[(int) (Math.random()*set.length)];
		}
		double estimation = Double.NEGATIVE_INFINITY;
		for (int i = 0;i < sample.length;i++) {
			for (int j = 0;j < sample.length;j++) {
				double dist = Utility.distance(sample[i], sample[j]);
				if (dist > estimation) estimation = dist;
			}
		}
		return estimation;
	}
}
