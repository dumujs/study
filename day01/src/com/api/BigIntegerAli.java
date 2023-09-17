package com.api;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

public class BigIntegerAli {
    public static void main(String[] args) {
        /**
         * big integer
         */
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            BigInteger bi = new BigInteger(5, r);
            System.out.println(bi);
        }
        BigInteger bi = new BigInteger("9999999999999999999999999999999");
        System.out.println(bi);
        BigInteger bi2 = new BigInteger("ABCDEF", 18);
        System.out.println(bi2);
        BigDecimal bd = new BigDecimal("10.0");
        BigDecimal bd2 = new BigDecimal("2.1");
        System.out.println(bd.divide(bd2, 3, RoundingMode.HALF_UP));
    }
}
