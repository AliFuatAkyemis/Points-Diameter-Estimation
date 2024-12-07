
public class NewApprox {
	public static double diameterNew(double[][] set) {
		//O(m^2*n)
		int dim = set[0].length, size = 2*dim;
		double[][] refs = new double[size][dim];
		double dmax = Double.NEGATIVE_INFINITY;
		for (int i = 0;i < size;i++) {
			for (int j = 0;j < dim;j++) {
				double max = Double.NEGATIVE_INFINITY, min = Double.POSITIVE_INFINITY;
				double[] pointMax = null, pointMin = null;
				for (int k = 0;k < set.length;k++) {
					if (max < set[k][j]) {
						max = set[k][j];
						pointMax = set[k];
					}
					if (min > set[k][j]) {
						min = set[k][j];
						pointMin = set[k];
					}
				}
				refs[j] = pointMax;refs[j+1] = pointMin;
			}
		}
		//Brute Force
		for (int i = 0;i < size;i++) {
			for (int j = 0;j < dim;j++) {
				double dist = Utility.distance(refs[i], refs[j]);
				if (dist > dmax) dmax = dist;
			}
		}
		return dmax;
	}
}
