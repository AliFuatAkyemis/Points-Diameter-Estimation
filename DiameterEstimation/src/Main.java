import java.util.ArrayList;
import java.util.List;

public class Main { 
	private static double[][] set;

    public static void main(String[] args) {
        set = Utility.squareSet(100);
		long start = 0, end = 0;
		double time1 = 0, time2 = 0, time3 = 0;
        //--------------------------------MelikeEsraÖz--------------------------------//
        List<Point> points = new ArrayList<>();
        for (double[] p : set) {
            points.add(new Point(p[0], p[1]));
        }
        int n = 10;
        start = System.nanoTime();
        SimpleApprox.calculateApproximateDiameter(points, n); //SIMPLE
        end = System.nanoTime();
		time1 = (end - start) / 1_000_000.0;
        //----------------------------------------------------------------------------//
        
        //--------------------------------AliFuatAkyemiş--------------------------------//
		start = System.nanoTime();
		FastApprox.diameterFast(set, 1); //FAST
		end = System.nanoTime();
		time2 = (end - start) / 1_000_000.0;
		start = System.nanoTime();
		FastApprox.diameterRandomized(set, 1); //RANDOMIZED
		end = System.nanoTime();
		time3 = (end - start) / 1_000_000.0;
        //----------------------------------------------------------------------------//
        
        //--------------------------------RamazanŞahin--------------------------------//

        

        //----------------------------------------------------------------------------//
        
        //--------------------------------HüseyinMertAfşarlı--------------------------------//



        //----------------------------------------------------------------------------//
        
        //--------------------------------ZülalBozyel--------------------------------//



        //----------------------------------------------------------------------------//

        System.out.println("Simple2D: " + time1);
		System.out.println("Fast: " + time2);
		System.out.println("Randomized: " + time3);
    }
}
