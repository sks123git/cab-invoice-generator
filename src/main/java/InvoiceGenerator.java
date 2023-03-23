import java.util.HashMap;

public class InvoiceGenerator {
    HashMap<Integer,Ride[]> rideRepository = new HashMap<>();
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_COST_PER_KILOMETER = 10;
    private static final int MINIMUM_FARE = 5;

    //For premium
    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final int PREMIUM_MINIMUM_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_MINIMUM_FARE = 20;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare,MINIMUM_FARE);

    }
    public double calculateFarePremium(double distance, int time) {
        double totalFare = distance * PREMIUM_MINIMUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME;
        return Math.max(totalFare,PREMIUM_MINIMUM_FARE);

    }
    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride: rides) {
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return totalFare;
    }
    public InvoiceSummary calculateFare(int userid, Ride[] rides,String riderType) {
        double totalFare = 0;
        if(riderType.equals("Premium")){
            for (Ride ride: rides) {
                totalFare += this.calculateFare(ride.distance,ride.time);
            }
        }

        for (Ride ride: rides) {
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        rideRepository.put(userid,rides);
        return new InvoiceSummary(userid,rides.length,totalFare);
    }
}
