# Find Next Prime

The repository is a simple project that produces a utility class NextPrime that has two static methods:-
isPrime(n) -> determines if the provided n is a Prime Number
nextPrime(n) -> find that the provided n is Prime Number and return it, if not return the next Prime Number AFTER n

The isPrime uses the simple [Primality Test](https://en.wikipedia.org/wiki/Primality_test) algorithm.

The following is the provided algorithm in Javascript, this implementation is adapted this into Java:-
```javascript
  function isPrime(num) {
    if (num == 2 || num == 3)
        return true;
    if (num <= 1 || num % 2 == 0 || num % 3 == 0)
        return false;  
    for (let i = 5; i * i <= num ; i+=6)
      if (num % i == 0 || num % (i + 2) == 0)
        return false;
	  return true;
  }
```
