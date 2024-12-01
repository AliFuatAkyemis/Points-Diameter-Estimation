import java.util.ArrayList;
import java.util.List;

public class Main { 
    public static void main(String[] args) {
    	//2D set samples:
    	double[][] set1 = Utility.squareSet(1000), set2 = Utility.rectangleSet(200,5000), set3 = Utility.circleSet(707);
    	
    	System.out.println("SquareSet:");
    	//Simple2D:
        testSimple2D(set1);
		//Fast:
        testFast(set1);
		//Randomized:
        testRandomized(set1);
        System.out.println();
        
        System.out.println("RectangleSet:");
    	//Simple2D:
        testSimple2D(set2);
		//Fast:
        testFast(set2);
		//Randomized:
        testRandomized(set2);
        System.out.println();
        
        System.out.println("CircleSet:");
    	//Simple2D:
        testSimple2D(set3);
		//Fast:
        testFast(set3);
		//Randomized:
        testRandomized(set3);
        System.out.println();
    }
    
    public static void testSimple2D(double[][] set) {
        List<Point> points = new ArrayList<>();
        for (double[] p : set) 
            points.add(new Point(p[0], p[1]));
        int n = 10;
        long start = System.nanoTime();
        double result1 = SimpleApprox.calculateApproximateDiameter(points, n); //SIMPLE2D
        long end = System.nanoTime();
		double time1 = (end - start) / 1_000_000.0;
        System.out.println("Simple2D: " + time1);
//        System.out.println(result1);
    }
    
    public static void testFast(double[][] set) {
		long start = System.nanoTime();
		double result2 = FastApprox.diameterFast(set, 1); //FAST
		long end = System.nanoTime();
		double time2 = (end - start) / 1_000_000.0;
		System.out.println("Fast: " + time2);
//        System.out.println(result2);
    }
    
    public static void testRandomized(double[][] set) {
		long start = System.nanoTime();
		double result3 = FastApprox.diameterRandomized(set, 1); //RANDOMIZED
		long end = System.nanoTime();
		double time3 = (end - start) / 1_000_000.0;
		System.out.println("Randomized: " + time3);
//        System.out.println(result3);
    }
}
