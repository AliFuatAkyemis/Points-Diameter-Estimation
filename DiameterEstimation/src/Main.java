import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	//2D set samples:
    	double epsilon = 0.0001;
    	int iteration = 1;
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
    			set12 = Utility.randomSet(1000000, 2, 100),
    			set13 = Utility.cubeSet(22),
    			set14 = Utility.cubeSet(47),
    			set15 = Utility.cubeSet(100),
    			set16 = Utility.prismSet(40, 5, 50),
    			set17 = Utility.prismSet(40, 50, 50),
    			set18 = Utility.prismSet(400, 50, 50),
    			set19 = Utility.cylinderSet(iteration, iteration),
    			set20 = Utility.cylinderSet(iteration, iteration),
    			set21 = Utility.cylinderSet(iteration, iteration),
    			set22 = Utility.randomSet(10000, 3, 100),
    			set23 = Utility.randomSet(100000, 3, 100),
    			set24 = Utility.randomSet(1000000, 3, 100);
    	
    	
    }
    
    public static void testFast(double[][] set, int iteration) {
		long start = System.nanoTime();
		double result2 = FastApprox.diameterFast(set, iteration); //FAST
		long end = System.nanoTime();
		double time = (end - start) / 1_000_000.0;
		System.out.println("Fast: " + time);
        System.out.println(result2);
    }
    
    public static void testRandomized(double[][] set, int iteration) {
		long start = System.nanoTime();
		double result3 = RandomizedApprox.diameterRandomized(set, iteration); //RANDOMIZED
		long end = System.nanoTime();
		double time = (end - start) / 1_000_000.0;
		System.out.println("Randomized: " + time);
        System.out.println(result3);
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
    
    public static void testLowDim(double[][] set, double epsilon) {
        Long start = System.nanoTime();
        double approxDiameter = LowDimApprox.approximateDiameter(set, epsilon); //LOWDIMENSION
        Long end = System.nanoTime();
        double time = (end-start) / 1_000_000.0;
        System.out.println("LowDimesion: " + time);
        System.out.println(approxDiameter);
    }
    
    public static void testBasic(double[][] set) {
        Long start = System.nanoTime();
        double approxDiameter = BasicApprox.algorithmA(set); //BASIC
        Long end = System.nanoTime();
        double time = (end-start) / 1_000_000.0;
        System.out.println("Basic: " + time);
        System.out.println(approxDiameter);
    }
}
