package miscellaneous;

/**
 * 
 * @author dharmik patel
 * check if Number is power of two
 *
 */
public class PowerOfTwo {
	
	//Complexity: O(log(n))
	public static boolean isPowerOfTwo(int n){
		if(n<=1){
			return true;
		}
		
		if(n%2 == 1) return false;
		
		return isPowerOfTwo(n/2);
	}
	
	//Complexity : O(1)
	public static boolean isPowerOfTwo1(int n){
		int x = n;
		return(x>0 && (x&(x-1))==0);
	}
	
	public static void main(String[] args){
		System.out.println(isPowerOfTwo1(3));
	}

}
