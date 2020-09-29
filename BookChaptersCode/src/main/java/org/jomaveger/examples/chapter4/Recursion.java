package org.jomaveger.examples.chapter4;

import java.math.BigInteger;

import java.util.function.Function;

import org.jomaveger.functional.control.TailCall;

public final class Recursion {
	
	public Recursion() {		
	}
	
	public static BigInteger factorialRecursive(Integer x) {
		if (x == 0) {
			return BigInteger.ONE;
		} else {
			return factorialRecursive(x - 1).multiply(BigInteger.valueOf(x));
		}
	}
	
	public static BigInteger acuFact(BigInteger a, Integer n) {
		BigInteger r = BigInteger.ONE; 
		if (n == 0) {
			r = a;
		} else if (n > 0) {
			r = acuFact(a.multiply(BigInteger.valueOf(n)), n - 1);
		}
		return r;
	}
	
	public static BigInteger fact(Integer n) {
		return Recursion.acuFact(BigInteger.ONE, n);
	}
	
	public static BigInteger tfact(Integer n) {
		return Recursion.tacuFact(BigInteger.ONE, n).eval();
	}
	
	public static TailCall<BigInteger> tacuFact(BigInteger a, Integer n) {
		if (n == 0) {
			return TailCall.ret(a);
		} else {
			return TailCall.sus(() -> tacuFact(a.multiply(BigInteger.valueOf(n)), n - 1));
		}
	}
	
	public static BigInteger factIter(Integer n) {
		 BigInteger r;
		 BigInteger a = BigInteger.ONE;
		 
		 while (n > 0) {
			 a = a.multiply(BigInteger.valueOf(n));
			 n = n - 1;
		 }
		 r = a;
		 return r;
	}
	
	public final Function<Integer, Integer> factorial = 
			n -> n == 0 ? 1 : n * this.factorial.apply(n - 1);
			
	public static final Function<Integer, Integer> staticFactorial =
					n -> n == 0 ? 1 : n * Recursion.staticFactorial.apply(n - 1);
					
	public static Integer gcd(Integer x, Integer y) {
		Integer m = 1;
		if (x == y) {
			m = x;
		}
		else if (x > y) {
			m = gcd(x - y, y);
		}
		else if (x < y) {
			m = gcd(x, y - x); 
		}
		return m;
	}
	
	public static Integer gcdIter(Integer x, Integer y) {
		Integer m = 1;
		while (x != y) {
			if (x > y) {
				x = x - y;
			} else if (x < y) {
				y = y - x;
			}
		}
		m = x;
		return m;
	}
	
	public static BigInteger fibonacci(Integer x) {
		if (x == 0 || x == 1) {
			return BigInteger.valueOf(x);
		}
		return fibonacci(x - 1).add(fibonacci(x - 2));
	}
	
	public static BigInteger acuFib(BigInteger acc1, BigInteger acc2, BigInteger x) {
		if (x.equals(BigInteger.ZERO)) {
			return BigInteger.ZERO;
		} else if (x.equals(BigInteger.ONE)) {
			return acc1.add(acc2);
		} else {
			return acuFib(acc2, acc1.add(acc2), x.subtract(BigInteger.ONE));
		}
	}
	
	public static BigInteger fib(Integer x) {
		return acuFib(BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(x));
	}
	
	public static BigInteger tfib(int x) {
		return tacuFib(BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(x)).eval();
	}

	public static TailCall<BigInteger> tacuFib(BigInteger acc1, BigInteger acc2, BigInteger x) {
		if (x.equals(BigInteger.ZERO)) {
			return TailCall.ret(BigInteger.ZERO);
		} else if (x.equals(BigInteger.ONE)) {
			return TailCall.ret(acc1.add(acc2));
		} else {
			return TailCall.sus(() -> tacuFib(acc2, acc1.add(acc2), x.subtract(BigInteger.ONE)));
		}
	}
	
	public static BigInteger fibIter(Integer x) {
		BigInteger r;
		BigInteger acc1 = BigInteger.ONE;
		BigInteger acc2 = BigInteger.ZERO;
		BigInteger temp;
		
		while (x > 1) {			
			temp = acc2;
			acc2 = acc1.add(acc2);
			acc1 = temp;
			x = x - 1;
		}
		
		r = acc1.add(acc2);
		return r;
	}
	
	public static void main(String[] args) {
		System.out.println(Recursion.factorialRecursive(5));
		System.out.println(new Recursion().factorial.apply(5));
		System.out.println(Recursion.staticFactorial.apply(5));
		System.out.println(Recursion.gcd(12,  18));
		System.out.println(Recursion.fibonacci(10));
		System.out.println(Recursion.gcdIter(12,  18));
		System.out.println(Recursion.fact(5));
		System.out.println(Recursion.factIter(5));
		System.out.println(Recursion.fib(10));
		System.out.println(Recursion.fibIter(10));
		System.out.println(Recursion.tfact(5));
		System.out.println(Recursion.tfib(10));
	}

}
