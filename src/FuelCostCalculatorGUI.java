import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FuelCostCalculatorGUI extends Application {

    private final double dieselCostPerLitre = 1.34;
    private final double petrolCostPerLitre = 1.29;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fuel Cost Calculator");

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        // Input Fields
        TextField distanceField = new TextField();
        distanceField.setPromptText("Enter distance in miles");

        ComboBox<String> tripTypeBox = new ComboBox<>();
        tripTypeBox.getItems().addAll("One-way", "Round-trip");
        tripTypeBox.setValue("One-way");

        TextField mpgField = new TextField();
        mpgField.setPromptText("Enter MPG");

        ComboBox<String> fuelTypeBox = new ComboBox<>();
        fuelTypeBox.getItems().addAll("Petrol", "Diesel");
        fuelTypeBox.setValue("Petrol");

        Button calculateButton = new Button("Calculate Trip Cost");

        Label resultLabel = new Label();

        calculateButton.setOnAction(e -> {
            try {
                int distance = Integer.parseInt(distanceField.getText());
                double mpg = Double.parseDouble(mpgField.getText());

                if (tripTypeBox.getValue().equals("Round-trip")) {
                    distance *= 2;
                }

                double fuelPricePerLitre = fuelTypeBox.getValue().equals("Diesel") ? dieselCostPerLitre : petrolCostPerLitre;

                double gallonsNeeded = distance / mpg;
                double litresNeeded = gallonsNeeded * 4.54609;
                double tripCost = litresNeeded * fuelPricePerLitre;

                resultLabel.setText(String.format("Trip cost: £%.2f", tripCost));

            } catch (NumberFormatException ex) {
                resultLabel.setText("⚠️ Please enter valid numbers for distance and MPG.");
            }
        });

        root.getChildren().addAll(
                new Label("Distance (miles):"), distanceField,
                new Label("Trip Type:"), tripTypeBox,
                new Label("MPG:"), mpgField,
                new Label("Fuel Type:"), fuelTypeBox,
                calculateButton, resultLabel
        );

        Scene scene = new Scene(root, 1440, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
