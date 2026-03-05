/*
 * Name: Esteban Pereira das Neves
 * Date: 03/03/2026
 * Project: Car Data Analyzer
 * Description: Loads car data from CSV file into an ArrayList
 */

import java.io.*;
import java.util.*;

public class CarDataLoader {

    public static ArrayList<Car> loadCars(String filename) {

        ArrayList<Car> cars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length < 7) continue;

                try {

                    String carID = parts[0].trim();
                    String brand = parts[1].trim();
                    String model = parts[2].trim();
                    int year = Integer.parseInt(parts[3].trim());
                    String fuelType = parts[4].trim();
                    String color = parts[5].trim();
                    double mileage = Double.parseDouble(parts[6].trim());

                    Car car = new Car(carID, brand, model, year,
                            fuelType, color, mileage);

                    cars.add(car);

                } catch (Exception e) {
                    // skip malformed rows
                }
            }

            System.out.println("Total cars loaded: " + cars.size());

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return cars;
    }
}