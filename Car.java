/*
 * Name: Esteban Pereira das Neves
 * Date: 03/03/2026
 * Project: Car Data Analyzer
 * Description: Car class represents one car record from Car_Data.csv
 */

public class Car {
    
    // Fields that match the columns in the CSV dataset
    private String carID;
    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private String color;
    private double mileageKmpl;

    // Constructor for Car object
    public Car(String carID, String brand, String model, int year,
               String fuelType, String color, double mileageKmpl) {

        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.color = color;
        this.mileageKmpl = mileageKmpl;
    }
    // Getters
    public String getCarID() { return carID; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getFuelType() { return fuelType; }
    public String getColor() { return color; }
    public double getMileageKmpl() { return mileageKmpl; }

    @Override
    public String toString() {
        return carID + ", " + brand + ", " + model + ", " +
               year + ", " + fuelType + ", " +
               color + ", " + mileageKmpl;
    }
}