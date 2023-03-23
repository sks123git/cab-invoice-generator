public class Ride {
    public final double distance;
    public final int time;
    public Ride(double distance, int time){
        this.distance = distance;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Distance: "+ this.distance + " Time: " + this.time;
    }
}
