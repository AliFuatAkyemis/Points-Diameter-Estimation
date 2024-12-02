import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	//2D set samples:
    	double epsilon = 0.0001;
    	double[][] 
    			set1 = Utility.squareSet(100),
    			set2 = Utility.squareSet(317),
    			set3 = Utility.squareSet(1000),
    			set4 = Utility.rectangleSet(200, 50),
    	    	set5 = Utility.rectangleSet(200, 500),
    	    	set6 = Utility.rectangleSet(2000, 500),
    			set7 = Utility.circleSet(70),
    			set8 = Utility.circleSet(225),
    	    	set9 = Utility.circleSet(707),
    			set10 = Utility.randomSet(10000, 2, 100),
    			set11 = Utility.randomSet(100000, 2, 100),
    			set12 = Utility.randomSet(1000000, 2, 100);
    	
    	System.out.printf("SquareSet(10000):\n");
        System.out.println("--------------------------");
    	//Simple2D:
        testSimple2D(set1);
        System.out.println("--------------------------");
		//Fast:
        testFast(set1);
        System.out.println("--------------------------");
		//Randomized:
        testRandomized(set1);
        System.out.println("--------------------------");
        //Better:
        testBetter(set1, epsilon);
        System.out.println("--------------------------");
        System.out.println();

//    	System.out.printf("SquareSet(100000):\n");
//        System.out.println("--------------------------");
//    	//Simple2D:
//        testSimple2D(set2);
//        System.out.println("--------------------------");
//		//Fast:
//        testFast(set2);
//        System.out.println("--------------------------");
//		//Randomized:
//        testRandomized(set2);
//        System.out.println("--------------------------");
//        //Better:
//        testBetter(set2, epsilon);
//        System.out.println("--------------------------");
//        System.out.println();
//
//    	System.out.printf("SquareSet(1000000):\n");
//        System.out.println("--------------------------");
//    	//Simple2D:
//        testSimple2D(set3);
//        System.out.println("--------------------------");
//		//Fast:
//        testFast(set3);
//        System.out.println("--------------------------");
//		//Randomized:
//        testRandomized(set3);
//        System.out.println("--------------------------");
//        //Better:
//        testBetter(set3, epsilon);
//        System.out.println("--------------------------");
//        System.out.println();
    }
    
    public static void testSimple2D(double[][] set) {
        List<Point> points = new ArrayList<>();
        for (double[] p : set) 
            points.add(new Point(p[0], p[1]));
        int n = 10;
        long start = System.nanoTime();
        double result1 = SimpleApprox.calculateApproximateDiameter(points, n); //SIMPLE2D
        long end = System.nanoTime();
		double time = (end - start) / 1_000_000.0;
        System.out.println("Simple2D: " + time);
        System.out.println(result1);
    }
    
    public static void testFast(double[][] set) {
		long start = System.nanoTime();
		double result2 = FastApprox.diameterFast(set, 1); //FAST
		long end = System.nanoTime();
		double time = (end - start) / 1_000_000.0;
		System.out.println("Fast: " + time);
        System.out.println(result2);
    }
    
    public static void testRandomized(double[][] set) {
		long start = System.nanoTime();
		double result3 = FastApprox.diameterRandomized(set, 1); //RANDOMIZED
		long end = System.nanoTime();
		double time = (end - start) / 1_000_000.0;
		System.out.println("Randomized: " + time);
        System.out.println(result3);
    }
    
    public static void testBetter(double[][] set, double epsilon) {
		long start = System.nanoTime();
        double diameter = BetterApprox.calculateDiameter(set, epsilon); //BETTER
		long end = System.nanoTime();
		double time1 = (end - start) / 1_000_000.0;
        double[][] roundedPoints = BetterApprox.roundToGrid(set, 10.0);
        start = System.nanoTime();
        double roundedDiameter = BetterApprox.calculateDiameter(roundedPoints, epsilon); //BETTER(ROUNDED)
        end = System.nanoTime();
        double time2 = (end - start) / 1_000_000.0;
        System.out.println("Better: " + time1);
        System.out.println(diameter);
        System.out.println("Better(Rounded): " + time2);
        System.out.println(roundedDiameter);
    }
}
