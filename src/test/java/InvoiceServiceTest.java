
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator;
    @Before
            public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void  givenDistanceAndTime_ShouldReturnTotalFare(){
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public  void givenLessDistanceAndTime_ShouldReturnMinimumFare(){
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] ride1 = {new Ride(2.0, 5),
        new Ride(0.1,1)};
        double result = invoiceGenerator.calculateFare(ride1);
        Assert.assertEquals(30.0, result, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummaryFromRideRepository() {
        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1,1)};
        InvoiceSummary result = invoiceGenerator.calculateFare(1,ride1);
        Assert.assertEquals(30.0, result.getTotalFare(), 0.0);
    }
}
