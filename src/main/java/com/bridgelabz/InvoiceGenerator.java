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
    private static final double MINIMUM_FARE = 5.0;

    /**
     * Purpose : To calculate the minimum fare
     *
     * @param distance : this is the first parameter
     * @param time     : this is the second parameter
     * @return the minimum fare
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * Purpose : To calculate total fare for multiple rides
     *
     * @param rides : This parameter takes multiple rides
     * @return  total fare of all rides.
     */
    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
