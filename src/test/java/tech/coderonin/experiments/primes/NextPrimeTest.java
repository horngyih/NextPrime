package tech.coderonin.experiments.primes;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NextPrimeTest {

	@Parameters
	public static Iterable<Object[]> testParameters(){
		return Arrays.asList(
			new Object[]{ 3635, 3637, false },
			new Object[]{ 3631, 3637, true },
			new Object[]{ 3632, 3637, false },
			new Object[]{ 4483, 4493, true }
		);
	}

	int candidate;
	int nextCandidate;
	boolean expectPrime;

	public NextPrimeTest( int m, int n, boolean isPrime ){
		this.candidate = m;
		this.nextCandidate = n;
		this.expectPrime = isPrime;
	}


	@Test
	public void shouldCheckIsPrime(){
		long start = System.nanoTime();
		boolean isPrime = NextPrime.isPrime(candidate);
		long end = System.nanoTime();
		System.out.printf( "Candidate %d is %s%n", candidate, (isPrime?"Prime":"Not Prime") );
		System.out.printf( "Time elapsed %d%n", ( end - start ) );
		assertEquals( "Should detect that the candidate is " + (this.expectPrime?"Prime":"Not Prime"), expectPrime, isPrime );

		start = System.nanoTime();
		int nextPrime = NextPrime.nextPrime(candidate);
		System.out.printf( "Next prime after candidate is %d%n", NextPrime.nextPrime(candidate) );
		end = System.nanoTime();
		assertEquals( "Should compute the next prime after candidate", nextCandidate, nextPrime );

	}
}
