import java.util.Arrays;

public class TransitCalculator {

    // fare options
    String[] fareOptions = { "Pay-per-ride", "7-day Unlimited Rides", "30-day Unlimited Rides" };
    // fare prices
    double[] fares = { 2.75, 33.00, 127.00 };

    // keep track of # of days
    int days;
    // individual rides
    int rides;

    public TransitCalculator(int numDays, int numRides) {
        days = numDays;
        rides = numRides;
    }

    public double unlimited7Price() {
        // num of weeks for card
        double numOfWeeks = Math.ceil(days / 7.0);
        // total cost of 7 day fare
        double total7DayCost = numOfWeeks * fares[1];

        return total7DayCost / rides;
    }

    public double[] getRidePrices() {
        // price per ride for pay-per-ride
        double payPerRide = fares[0];
        // price per ride for 7-day unlimited
        double priceForSevenDay = unlimited7Price();
        // price per ride for 30-day unlimited
        double priceForThirtyDay = fares[2] / rides;
        double[] prices = { payPerRide, priceForSevenDay, priceForThirtyDay };
        return prices;
    }

    public String getBestFare() {

        double[] ridePrices = getRidePrices();
        int winningIndex = 0;

        for (int i = 0; i < ridePrices.length; i++) {

            if (ridePrices[i] < ridePrices[winningIndex]) {

                winningIndex = i;
            }
        }

        return "You should get the " + fareOptions[winningIndex] + " option at $"
                + Math.round(ridePrices[winningIndex] * 100.0) / 100.0 + " per ride.";
    }

    public static void main(String[] args) {
        TransitCalculator myRide = new TransitCalculator(26, 54);
        System.out.println(myRide.getBestFare());
    }
}