package com.salesforce.dev.framework;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by alex on 06/09/2015.
 */
public class RandomGenerator {
    String randomValue;
    private SecureRandom random;


    private static RandomGenerator instance = null;
    private RandomGenerator(){
        this.initializer();
    }
    private void initializer(){
        random = new SecureRandom();
        randomValue= new BigInteger(12, random).toString(32);

    }
    public static RandomGenerator getInstance(){
        if(instance==null){
            instance = new RandomGenerator();
        }
        return instance;
    }
    public String getRandomString(){

        return randomValue;
    }
}