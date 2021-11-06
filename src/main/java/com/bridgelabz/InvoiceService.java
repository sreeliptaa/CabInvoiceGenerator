package com.bridgelabz;

/**
 * Purpose : To calculate Cab Invoice Service Problem
 *
 * @author Sreelipta
 * @since 2021-11-04
 */

public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double MINIMUM_FARE = 5.0;
    private RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

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
     * Purpose : To calculate total fare for multiple rides for enhanced invoice
     *
     * @param rides : This parameter takes multiple rides
     * @return total fare of rides and length of ride
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * purpose : To get the enhanced invoice summary based on userID
     *
     * @param userId : takes userId as parameter
     * @return the fare of rides based on userId
     */

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    /**
     * Purpose : To initialize the enhanced ride details by using userId
     *
     * @param userId : takes userId as first parameter
     * @param rides  : takes multiple rides as second parameter
     */

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }
}
