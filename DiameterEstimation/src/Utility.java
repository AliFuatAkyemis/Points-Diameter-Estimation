
public class Utility {
	
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
			if (radius == 0) return null;
			int size = circleSize(radius);
			double[][] res = new double[size][2];
			for (int i = 1;i <= radius;i++) {
				circleLoop(res, i, circleSize(i-1));
			}
			return res;
		}
		
		//Circle Assist:
		private static double circleFunc(double x, double radius) {
			return Math.sqrt((radius*radius)-(x*x));
		}

		//Circle Assist:
		private static int circleSize(int radius) {
			if (radius == 0) return 0;
			int res = 0;
			for (int i = 1;i <= radius;i++) {
				res += 4*i;
			}
			return res;
		}

		//Circle Assist:
		private static void circleLoop(double[][] set, int radius, int lastIndex) {
			set[lastIndex][0] = -radius;set[lastIndex][1] = 0;
			set[lastIndex+1][0] = radius;set[lastIndex+1][1] = 0;
			for (int i = -radius+1, j = lastIndex+2;i < radius;i++,j += 2) {
				double y = circleFunc(i, radius);
				set[j][0] = i;set[j][1] = y;
				set[j+1][0] = i;set[j+1][1] = -y;
			}
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
			height++;
			double[][] temp = circleSet(radius);
			double[][] res = new double[temp.length*height][3];
			for (int i = 0;i < temp.length;i++) {
				double[] point = temp[i];
				for (int j = i*height, k = 0;k < height;j++,k++) {
					res[j][0] = point[0];
					res[j][1] = point[1];
					res[j][2] = k;
				}
			}
			return res;
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
		public static double[] farthest(double[] point, double[][] set) {
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
			if (set == null) return "null";
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
			if (set == null) System.out.println("null");;
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			for (int i = 0;i < set.length;i++) {
				sb.append(set[i] + ",");
			} sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.append("}").toString());
		}
		
		//Display method for Set:
		public static void displaySet(double[][] set) {
			//O(n)
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			for (int i = 0;i < set.length;i++) {
				sb.append(arrayToString(set[i]) + ",");
			} sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.append("}").toString());
		}
}
