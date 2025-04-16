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



        System.out.print("Enter the distance of your trip in miles: ");
        int distanceInMiles = scanner.nextInt();

        System.out.print("Enter your vehicle's MPG (miles per gallon): ");
        double mpg = scanner.nextDouble();

        String fuelType = "";
        while (true) {
            System.out.print("Does your car use petrol or diesel? (p/d): ");
            fuelType = scanner.next().toLowerCase();

            if (fuelType.equals("p") || fuelType.equals("d")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'p' for petrol or 'd' for diesel.");
            }
        }

        double gallonsNeeded = distanceInMiles / mpg;
        double litresNeeded = gallonsNeeded * 3.78541;

        double fuelPricePerLitre = fuelType.equals("d") ? dieselCostPerLitre : petrolCostPerLitre;

        double tripCost = litresNeeded * fuelPricePerLitre;

        System.out.printf("Trip cost: £%.2f%n", tripCost);
    }
}