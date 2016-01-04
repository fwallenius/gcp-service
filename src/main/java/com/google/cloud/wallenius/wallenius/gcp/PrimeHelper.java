package com.google.cloud.wallenius.wallenius.gcp;

/**
 *
 * @author wallenius
 */
public class PrimeHelper {

    /**
     *
     * Return the next prime number starting from (not including) the given
     * Integer.
     *
     * @param startValue
     * @return
     */
    public Integer findNextPrime(Integer startValue) {
        return getNext(startValue + 1);
    }
    
    /**
     * 
     * Return a list of the consecutive primes starting from the given integer.
     * 
     * @param startValue
     * @param listSize
     * @return 
     */
    public Integer[] findNextPrimes(Integer startValue, Integer listSize) {
        Integer[] result = new Integer[listSize];
        
        for (int i = 0; i < listSize; i++) {
            result[i] = this.findNextPrime(startValue);
            startValue = result[i];
        }
        
        return result;
    }
    
    private Integer getNext(Integer value) {
        if (isPrime(value)) {
            return value;
        } else {
            return getNext(value + 1);
        }
    }

    private boolean isPrime(Integer n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) {
            return false;
        }
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
