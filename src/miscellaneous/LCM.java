package miscellaneous;

public class LCM {
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b,a%b);
	}
	
	public static int lcm(int a, int b) {
		return a * b / gcd(a,b) ;
	}
	
	public static int lcmArray(int[] a) {
		int ans = 1;
		for (int i = 0; i < a.length ; i++) {
			ans = ans * a[i] / gcd(ans,a[i]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(13,7));
		System.out.println(lcm(24,8));
		System.out.println(lcm(44,12));
		
		int[] a = new int[]{2, 7, 3, 9, 4};
		System.out.println(lcmArray(a));
	}
	
	

}
