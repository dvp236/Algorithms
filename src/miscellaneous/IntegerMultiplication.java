package miscellaneous;

import java.math.BigInteger;

/*
 * 
 * Carry out Multiplication of large numbers
 * for example below numbers 
 * x= 3141592653589793238462643383279502884197169399375105820974944592
 * y= 2718281828459045235360287471352662497757247093699959574966967627
 * 
 * 
 */

public class IntegerMultiplication {
	
	//we will use karatsuba's multiplication algorithm to do multiplication
	public static BigInteger karatsubaMultiply(BigInteger x, BigInteger y){
		int l = Math.max(x.bitLength() , y.bitLength());
		
		//base case, if number is fairly short then multiply directly 
		if(l <= 100) 
			return x.multiply(y);
		
		l=(l/2)+(l%2);
		//x = 1234 , l=2 ,  a = 12 , b = 1234-1200
		BigInteger a = x.shiftRight(l);
		BigInteger b = x.subtract(a.shiftLeft(l));
		BigInteger c = y.shiftRight(l);
		BigInteger d = y.subtract(c.shiftLeft(l));
		
		//get all intermediate multiplications using recursion
		BigInteger ac = karatsubaMultiply(a, c);
		BigInteger bd = karatsubaMultiply(b, d);
		BigInteger adbc = karatsubaMultiply(a.add(b), c.add(d));
		
		//combine all terms according to karatsuba's formula
		return bd.add(adbc.subtract(ac).subtract(bd).shiftLeft(l)).add(ac.shiftLeft(2*l));
		
	
	}
	
	public static void main(String[] args){
		System.out.println("hello");
		
		BigInteger a = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
		BigInteger b = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
		
		System.out.println(karatsubaMultiply(a, b));
	}

}
