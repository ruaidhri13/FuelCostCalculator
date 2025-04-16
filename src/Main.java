import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        tripCalculation();
    }

    public static void tripCalculation() {
        Scanner scanner = new Scanner(System.in);

        final double dieselCostPerLitre = 1.54;
        final double petrolCostPerLitre = 1.37;

        System.out.println("Fuel Prices:");
        System.out.println("Diesel: £" + dieselCostPerLitre);
        System.out.println("Petrol: £" + petrolCostPerLitre + "\n");

        // 1. Get trip distance
        int distanceInMiles;
        while (true) {
            System.out.print("Enter the distance of your destination in miles: ");
            distanceInMiles = scanner.nextInt();
            if (distanceInMiles > 0) break;
            System.out.println("Please enter a valid distance greater than 0.");
        }

        // 2. Ask if it's one way or round trip
        String isOneWay;
        while (true) {
            System.out.print("Is this a round trip? (y/n): ");
            isOneWay = scanner.next().toLowerCase();
            if (isOneWay.equals("y") || isOneWay.equals("n")) break;
            System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
        }

        if (isOneWay.equals("y")) {
            distanceInMiles *= 2;
        }

        // 3. Ask for MPG
        System.out.print("Enter your vehicle's MPG (miles per gallon): ");
        double mpg = scanner.nextDouble();

        // 4. Ask for fuel type
        String fuelType = "";
        while (true) {
            System.out.print("Does your car use petrol or diesel? (p/d): ");
            fuelType = scanner.next().toLowerCase();
            if (fuelType.equals("p") || fuelType.equals("d")) break;
            System.out.println("Invalid input. Please enter 'p' or 'd'.");
        }

        double fuelPricePerLitre = fuelType.equals("d") ? dieselCostPerLitre : petrolCostPerLitre;

        // 5. Do the calculations
        double gallonsNeeded = distanceInMiles / mpg;
        double litresNeeded = gallonsNeeded * 3.78541;
        double tripCost = litresNeeded * fuelPricePerLitre;

        System.out.printf("Trip cost: £%.2f%n", tripCost);
    }
}
