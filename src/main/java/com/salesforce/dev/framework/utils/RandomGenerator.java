package com.salesforce.dev.framework.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author alex on 06/09/2015.
 */
public class RandomGenerator {
    String randomValue;
    private SecureRandom random;


    private static RandomGenerator instance = null;

    private RandomGenerator() {
        this.initializer();
    }

    private void initializer() {
        random = new SecureRandom();
        int numBits = 12;
        int radix = 32;
        randomValue = new BigInteger(numBits, random).toString(radix);

    }

    public static RandomGenerator getInstance() {
        if (instance == null) {
            instance = new RandomGenerator();
        }
        return instance;
    }

    public String getRandomString() {
        return randomValue;
    }
}