import java.util.ArrayList;
import java.util.List;

public class Main {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	double epsilon = 0.0001;
    	double gridSize = 10;
    	int iteration = 1;
    	int segment = 10;
    	int sampleSize = 10;
    	double[][] 
    			set1 = Utility.squareSet(100),
    			set2 = Utility.squareSet(317),
    			set3 = Utility.squareSet(1000),
    			set4 = Utility.rectangleSet(200, 50),
    	    	set5 = Utility.rectangleSet(200, 500),
    	    	set6 = Utility.rectangleSet(2000, 500),
    			set7 = Utility.circleSet(70),
    			set8 = Utility.circleSet(223),
    	    	set9 = Utility.circleSet(706),
    			set10 = Utility.randomSet(10000, 2, 100),
    			set11 = Utility.randomSet(100000, 2, 100),
    			set12 = Utility.randomSet(1000000, 2, 100),
    			set13 = Utility.cubeSet(22),
    			set14 = Utility.cubeSet(47),
    			set15 = Utility.cubeSet(100),
    			set16 = Utility.prismSet(40, 5, 50),
    			set17 = Utility.prismSet(40, 50, 50),
    			set18 = Utility.prismSet(400, 50, 50),
    			set19 = Utility.cylinderSet(21,10),
    			set20 = Utility.cylinderSet(22,98),
    			set21 = Utility.cylinderSet(22,988),
    			set22 = Utility.randomSet(10000, 3, 100),
    			set23 = Utility.randomSet(100000, 3, 100),
    			set24 = Utility.randomSet(1000000, 3, 100),
    			set25 = Utility.randomSet(1000000, 4, 200),
    			set26 = Utility.randomSet(1000000, 5, 200),
    			set27 = Utility.randomSet(1000000, 100, 200);
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
    
    public static void testSimple2D(double[][] set, int n) {
        List<Point> points = new ArrayList<>();
        for (double[] p : set) 
            points.add(new Point(p[0], p[1]));
        long start = System.nanoTime();
        double result1 = SimpleApprox.calculateApproximateDiameter(points, n); //SIMPLE2D
        long end = System.nanoTime();
		double time = (end - start) / 1_000_000.0;
        System.out.println("Simple2D: " + time);
        System.out.println(result1);
    }
    
    public static void testRound(double[][] set, double epsilon, double round) {
        double[][] roundedPoints = RoundApprox.roundToGrid(set, round);
        long start = System.nanoTime();
        double diameter = RoundApprox.calculateDiameter(roundedPoints, epsilon); //ROUND
        long end = System.nanoTime();
        double time1 = (end - start) / 1_000_000.0;
        System.out.println("Round: " + time1);
        System.out.println(diameter);
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
        double approxDiameter = BasicApprox.diameterBasic(set); //BASIC
        Long end = System.nanoTime();
        double time = (end-start) / 1_000_000.0;
        System.out.println("Basic: " + time);
        System.out.println(approxDiameter);
    }
    
    public static void testNew(double[][] set) {
        Long start = System.nanoTime();
        double approxDiameter = NewApprox.diameterNew(set); //NEW
        Long end = System.nanoTime();
        double time = (end-start) / 1_000_000.0;
        System.out.println("New: " + time);
        System.out.println(approxDiameter);
    }
}
