import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = CarDataLoader.loadCars("Car_Data.csv");

        ArrayList<Car> working =
                new ArrayList<>(cars.subList(0, 2000));

        System.out.println("Working list size: " + working.size());
    }
}