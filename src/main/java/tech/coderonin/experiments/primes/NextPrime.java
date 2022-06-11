package tech.coderonin.experiments.primes;

public class NextPrime{

	public static boolean isPrime( int n ) {
		if( n == 2 || n== 3 ) return true;
		if( n <= 1 || n % 2 == 0 || n % 3 == 0 ) return false;

		for( int i=5; i*i < n; i+= 6 ){
			if( n % i == 0 || n % ( i + 2 ) == 0 ) return false;
		}
		return true;
	}

	public static int nextPrime( int n ){
		if( isPrime(n) ){
			return computeNextPrime(n);
		} else {
			int nextPrime = n;
			do{
				++nextPrime;
			} while( !isPrime(nextPrime) );
			return nextPrime;
		}
	}

	public static int computeNextPrime( int n ){
		int k = 0;
		if( (n-1)%6 == 0 ){
			k = (n-1)/6;
		} else {
			k = (n+1)/6;
		}
		k+=1;

		int k_up = (6*k)+1;
		int k_down = (6*k)-1;

		if( isPrime(k_up) && isPrime(k_down) ){
			if( k_up > k_down ){
				return k_down;
			} else {
				return k_up;
			}
		} else if( isPrime(k_up) ){
			return k_up;
		} else if( isPrime(k_down) ){
			return k_down;
		} else {
			return nextPrime(k_down);
		}
	}

}
