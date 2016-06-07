package miscellaneous;

/**
 * 
 * @author dharmik patel
 * Check if number is prime or not
 */
public class PrimeNumber {
	public boolean isPrime(int n){
		for(int i=2;i<n;i++){
			if(n%i==0) return true;
		}
		return false;
	}
	//efficient one
	public boolean isPrime1(int n){
		for(int i=2;i<Math.sqrt(n);i++){
			if(n%i==0) return true;
		}
		return false;
	}
	
	public boolean isPrime_best(int n){
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
