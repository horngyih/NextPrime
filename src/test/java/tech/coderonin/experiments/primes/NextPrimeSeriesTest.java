package tech.coderonin.experiments.primes;

import org.junit.Ignore;
import org.junit.Test;

public class NextPrimeSeriesTest{

	@Ignore
	@Test
	public void generatePrimes(){
		int count = 0;
		for( int i = 2; i < 10000; i=NextPrime.nextPrime(i) ){
			System.out.print( i + " " );
			count++;
			if( count % 20 == 0 ) System.out.println("\n");
		}
		System.out.println("");
	}
}
