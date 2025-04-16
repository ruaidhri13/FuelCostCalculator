import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int litres;
        String fuelType;
        double dieselCostPerLitre = 1.54;
        double petrolCostPerLitre = 1.37;
        double totalFuelPrice;
        boolean isValidFuelType = false;

        Scanner scanner = new Scanner(System.in);


        System.out.println("Diesel: £" + dieselCostPerLitre +
                            " Petrol: £" + petrolCostPerLitre + "\n"); // Displays the price of each fuel type

        while (!isValidFuelType) {
            System.out.println("Diesel or Petrol");
            fuelType = scanner.nextLine();

            if (fuelType.equalsIgnoreCase("Diesel") || fuelType.equalsIgnoreCase("Petrol")) {
                isValidFuelType = true;
            }
            else
                System.out.println("Invalid fuel type");
        }


        System.out.println("Enter the number of litres you want to insert: ");

        litres = scanner.nextInt();

        totalFuelPrice = Math.round(litres * petrolCostPerLitre);

        System.out.println("Total Cost: £" + totalFuelPrice);


        System.out.println("Fuel Calculator");
    }
}