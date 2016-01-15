package com.salesforce.dev.framework;

import java.math.BigInteger;
import java.security.SecureRandom;


/**
 * Created by alex on 06/09/2015.
 */
public class RamdonGenerator {
    String ramdomVaue;
    private SecureRandom random;


    private static RamdonGenerator instance = null;
    private RamdonGenerator(){
        this.initializer();
    }
    private void initializer(){
        random = new SecureRandom();
        ramdomVaue= new BigInteger(12, random).toString(32);

    }
    public static RamdonGenerator getInstance(){
        if(instance==null){
            instance = new RamdonGenerator();
        }
        return instance;
    }
    public String getRamdonString(){

        return ramdomVaue;
    }
}
