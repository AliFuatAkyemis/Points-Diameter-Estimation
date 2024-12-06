
public class BasicApprox{    
    public static double diameterBasic(double[][]points){
        double[] p = points[0];

        double[] q = Utility.farthest(p, points);
        
        double qprime[] = Utility.farthest(q, points);

        double rq = Utility.distance(q, qprime);

        return rq;
    }   
}

