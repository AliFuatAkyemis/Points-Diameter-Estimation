
public class Approx {
	private static double[][] set;
	
	public static void main(String[] args) {
		set = randomSet(1000000,2,100);
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
	
	//Randomized version of fast approximation algorithm:
	public static double diameterRandomized(double[][] points, int t) {
		//O(m*n) each iteration requires 3*m*n operations
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
	
	//Brute Force:
	public static double diameterBruteForce(double[][] points) {
		//O(n^2)
		double dmax = 0, distance = 0;
		for (int i = 0;i < points.length;i++) {
			for (int j = 0;j < points.length;j++) {
				distance = distance(points[i], points[j]);
				if (distance > dmax) dmax = distance;
			}
		}
		return dmax;
	}
	
	//*****************ZulalBozyel*****************//
	
	//*****************MelikeEsraÖz*****************//
	
	//*****************HüseyinMertAfşarlı*****************//
	
	//*****************RamazanŞahin*****************//
	
	//*****************Generator Methods*****************//
	
	//*****************2D Generators*****************//
	
	//Square Generator:
	public static double[][] squareSet(int size) {
		//O(n^2)
		size++;
		double[][] res = new double[size*size][2];
		for (int i = 0;i < size;i++) {
			for (int j = 0;j < size;j++) {
				res[i*size+j][0] = i;
				res[i*size+j][1] = j;
			}
		}
		return res;
	}
	
	//Rectangle Generator:
	public static double[][] rectangleSet(int a, int b) {
		//O(n^2)
		a++;b++;
		double[][] res = new double[a*b][2];
		for (int i = 0;i < a;i++) {
			for (int j = 0;j < b;j++) {
				res[i*b+j][0] = i;
				res[i*b+j][1] = j;
			}
		}
		return res;
	}
	
	//Circle Generator:
	public static double[][] circleSet(int radius) {
		double[][] res = new double[radius][2];
		
		return res;
	}
	
	//*****************3D Generators*****************//
	
	//Cube Generator:
	public static double[][] cubeSet(int size) {
		//O(n^3)
		size++;
		double[][] res = new double[size*size*size][3];
		for (int i = 0;i < size;i++) {
			for (int j = 0;j < size;j++) {
				for (int k = 0;k < size;k++) {
					res[i*size*size+j*size+k][0] = i;
					res[i*size*size+j*size+k][1] = j;
					res[i*size*size+j*size+k][2] = k;
				}
			}
		}
		return res;
	}
	
	//Prism Generator:
	public static double[][] prismSet(int a, int b, int c) {
		//O(n^3)
		a++;b++;c++;
		double[][] res = new double[a*b*c][3];
		for (int i = 0;i < a;i++) {
			for (int j = 0;j < b;j++) {
				for (int k = 0;k < c;k++) {
					res[i*b*c+j*c+k][0] = i;
					res[i*b*c+j*c+k][1] = j;
					res[i*b*c+j*c+k][2] = k;
				}
			}
		}
		return res;
	}
	
	//Sphere Generator:
	public static double[][] sphereSet(int size) {
		//Work in progress!
		return null;
	}
	
	//Cylinder Generator:
	public static double[][] cylinderSet(int radius, int height) {
		//Work in progress!
		return null;
	}
	
	//*****************Multi-Dimensional Generators*****************//
	
	//Random Generator:
	public static double[][] randomSet(int size, int dimension, int max) {
		double[][] res = new double[size][dimension];
		for (int i = 0;i < size;i++) {
			for (int j = 0;j < dimension;j++) {
				res[i][j] = Math.random()*max;
			}
		}
		return res;
	}
	
	//*****************Assistance Methods*****************//
	
	//Distance between 2 given points:
	public static double distance(double[] p1, double[] p2) {
		//O(m)
		double distance = 0;
		for (int i = 0;i < p1.length;i++) {
			distance += Math.pow((p1[i] - p2[i]), 2);
		}
		return Math.sqrt(distance);
	}
	
	//Farthest point in the set to given point:
	public static double[] farthest(double[] point) {
		//O(m*n)
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
	
	//Middle point of given 2 points:
	public static double[] middle(double[] p1, double[] p2) {
		//O(m)
		double[] res = p1;
		for (int i = 0;i < res.length;i++) {
			res[i] += p2[i];
			res[i] /= 2;
		}
		return res;
	}
	
	//toString() method for an array:
	public static String arrayToString(double[] set) {
		//O(n)
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0;i < set.length;i++) {
			sb.append(set[i] + ",");
		} sb.deleteCharAt(sb.length()-1);
		return sb.append("}").toString();
	}
	
	//Display method for an array:
	public static void display(double[] set) {
		//O(n)
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0;i < set.length;i++) {
			sb.append(set[i] + ",");
		} sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.append("}").toString());
	}
	
	//Display method for a 2D array:
	public static void display2D(double[][] set) {
		//O(n)
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0;i < set.length;i++) {
			sb.append(arrayToString(set[i]) + ",");
		} sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.append("}").toString());
	}
}
