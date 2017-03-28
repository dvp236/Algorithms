package applications.algo;



import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private double[] trialsList;
	private final int n2;
	private final int T;
	
	public PercolationStats(int n, int trials) {
		
		// perform trials independent experiments on an n-by-n grid
		if (n <= 0 || trials <= 0) { 
            throw new java.lang.IllegalArgumentException();
		}
		T = trials;
		n2 = n*n;
		Percolation grid;
		trialsList = new double[trials];
		 
		for(int j=0;j<trials;j++) {
	
			grid = new Percolation(n);
			 
			while(!grid.percolates()) {
				 
				int row = StdRandom.uniform(1, n+1);
				int col = StdRandom.uniform(1, n+1);
				 
				grid.open(row, col);
				 
			 }
			 trialsList[j] = grid.numberOfOpenSites()/(double)n2;
		 }
		
		 
	 }
	
	
     
	 public double mean() {
		 
		 // sample mean of percolation threshold
		 return StdStats.mean(trialsList);
     }
	 
     public double stddev()  {
    	 // sample standard deviation of percolation threshold
    	 return StdStats.stddev(trialsList);
     }
     
     public double confidenceLo()  {
    	 // low  endpoint of 95% confidence interval
    	 double xb= mean();
    	 double s = stddev();
    	 
    	 return xb - (1.96d)*(s)/Math.sqrt(T);
	   
     }
    
     public double confidenceHi()    {
    	 // high endpoint of 95% confidence interval
    	 double xb = mean();
    	 double s = stddev();
    	 
    	 return xb + (1.96d)*(s)/Math.sqrt(T);
     }

  
     public static void main(String[] args) {
    	
    	 int n = Integer.parseInt(args[0]);
    	 int T = Integer.parseInt(args[1]);
//    	 
//    	 PercolationStats ps = new PercolationStats(n, T);
//    	 String mean = String.format("%-24s= %s","mean",ps.mean());
//    	 String stddev = String.format("%-24s= %s","stddev",ps.stddev());
//    	 String confResult = "["+ps.confidenceLo()+", "+ps.confidenceHi()+"]";
//    	 String conf = String.format("%-24s= %s","95% confidence interval",confResult);
//    	 
//    	 
//    	 System.out.println(mean);
//    	 System.out.println(stddev);
//    	 System.out.println(conf);
     }

}
