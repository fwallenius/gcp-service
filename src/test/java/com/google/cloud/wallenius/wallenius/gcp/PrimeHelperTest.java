package com.google.cloud.wallenius.wallenius.gcp;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author wallenius
 */
public class PrimeHelperTest {

    @Test
    public void giving5shouldReturn7() {

        PrimeHelper classUnderTest = new PrimeHelper();
        Integer result = classUnderTest.findNextPrime(5);

        Assert.assertEquals((Integer) 7, result);
    }

    @Test
    public void giving89shouldReturn97() {

        PrimeHelper classUnderTest = new PrimeHelper();
        Integer result = classUnderTest.findNextPrime(89);

        Assert.assertEquals((Integer) 97, result);
    }

    @Test
    public void findLargePrime() {
        
        PrimeHelper classUnderTest = new PrimeHelper();
        Integer result = classUnderTest.findNextPrime(999999999);

        Assert.assertEquals((Integer) 1000000007, result);
    }

    @Test
    public void shouldReturnCorrectlySizedArray() {

        PrimeHelper classUnderTest = new PrimeHelper();
        Integer[] result = classUnderTest.findNextPrimes(-1, 10);
        
        Assert.assertEquals((Integer) 10, (Integer) result.length);
    }
    
    @Test
    public void shouldReturnArrayOfPrimes() {

        PrimeHelper classUnderTest = new PrimeHelper();
        Integer[] expected = new Integer[]{5, 7, 11, 13};
                
        Integer[] result = classUnderTest.findNextPrimes(3, 4);
        Assert.assertArrayEquals(expected, result);
    }
}
