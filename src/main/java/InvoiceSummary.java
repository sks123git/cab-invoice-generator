import java.util.Objects;

public class InvoiceSummary {
    private final int userId;
    private final int numberOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int userId, int numberOfRides, double totalFare) {
        this.userId=userId;
    this.numberOfRides = numberOfRides;
    this.totalFare = totalFare;
    this.averageFare = this.totalFare/2;
    }

    public int getUserId() {
        return userId;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }

    @Override
    public String toString() {
        return this.userId + " " + this.numberOfRides+ " " + this.totalFare + " " + this.averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFare, averageFare) == 0;
    }
}
