package com.bridgelabz;

/**
 * Purpose : To calculate Cab Invoice Service Problem
 *
 * @author Sreelipta
 * @since 2021-11-04
 */

public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;

    /**
     * Purpose : To calculate the total fare
     *
     * @param distance : this is the first parameter
     * @param time     : this is the second parameter
     * @return the total fare
     */
    public double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
    }
}
