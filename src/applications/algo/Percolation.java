package applications.algo;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private WeightedQuickUnionUF wu;
	//used for fullPath..
	//we cant use wu because it will always be true for last row members.. so when row = N col= * we get tru
	//If space comlexity is not constraint use another strucutre. Or you will have to trade in time complexity
	//of method percolate()
	private WeightedQuickUnionUF wufp;
	private int N;
	private boolean sites[][];
	private int countOpensites;
	private int n2 ;
	
	public Percolation(int N){
		this.N = N;
		n2 = N*N;
		//take 2 virtual nodes at top and bottom for efficiency 
		wu = new WeightedQuickUnionUF((n2+2));
		wufp = new WeightedQuickUnionUF((n2+2));
		sites = new boolean[N][N];
		countOpensites = 0;
		for(int i=1; i<=N; i++){
			wu.union(0, i);
			wu.union(n2+1, n2-i+1);
			wufp.union(0, i);
		}
	}
	
	//open a site 
	public void open(int row, int col){
		validargs(row,col);
		if(isOpen(row,col)) return;
		
		countOpensites++;
		sites[row-1][col-1] = true;
		meetNeighbours(row,col);
		
	}
	
	//check if we can reach top from given row col
	public boolean isFull(int row, int col){
		validargs(row, col);
		int p = linearIndex(row,col);
		return wufp.connected(p, 0);	
	}
	
	//check if grid percoaltes
	public boolean percolates(){
		return wu.connected(0, n2+1);
	}
	
	//return if site is open or not
	public boolean isOpen(int row, int col){
		validargs(row,col);
		return sites[row-1][col-1];
		
	}
	
	public int numberOfOpenSites(){
    	
    	// number of open sites
    	return countOpensites;
    }
	
	//check neighbours.. union if any of it is open
	private void meetNeighbours(int row, int col){
		int p = linearIndex(row,col);
		
    	if(col > 1)
    		if(isOpen(row,col-1)){
    			wu.union(p, linearIndex(row,col-1));
    			wufp.union(p, linearIndex(row,col-1));
    		}
    	if(col < N)
    		if(isOpen(row,col+1)){
    			wu.union(p, linearIndex(row,col+1));
    			wufp.union(p, linearIndex(row,col+1));
    		}
    	
    	if(row > 1)
    		if(isOpen(row-1,col)) {
    			wu.union(p, linearIndex(row-1,col));
    			wufp.union(p, linearIndex(row-1,col));
    		}
    	if(row < N)
    		if(isOpen(row+1,col)){
    			wu.union(p, linearIndex(row+1,col));
    			wufp.union(p, linearIndex(row+1,col));
    		}
    	
	}
	
	//convert row col to linear
	private int linearIndex(int row, int col){
		return N*(row-1) + col;
	}
	
	//check if args valid
	private void validargs(int row, int col){
		if(row < 1 || row > N || col < 1 || col > N){
			throw new IllegalArgumentException();
		}
	}

	
	public static void main(String[] args){
		Percolation grid = new Percolation(5);
		System.out.println(grid.numberOfOpenSites());
		grid.open(1, 3);
		grid.open(2, 3);
		grid.open(3, 3);
		grid.open(3, 2);
		grid.open(4, 3);
		grid.open(4, 4);
		grid.open(4, 5);
		grid.open(5, 5);

		
		System.out.println(grid.percolates());
		
		System.out.println("---------------");
		System.out.println(grid.isFull(5,2));
		

		
		
	}

}
