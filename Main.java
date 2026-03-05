/*
 * Name: Esteban Pereira das Neves
 * Date: 03/03/2026
 * Project: Car Data Analyzer
 * Description: Main program with menu, sorting, searching and statistics
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = CarDataLoader.loadCars("Car_Data.csv");

        ArrayList<Car> working =
                new ArrayList<>(cars.subList(0, 2000));

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {

            System.out.println("\n===== CAR DATA ANALYZER =====");
            System.out.println("1. Sort by Year");
            System.out.println("2. Search by Year Range");
            System.out.println("3. Search by Color");
            System.out.println("4. Show Statistics");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    sortByYearAscending(working);

                    for (int i = 0; i < 10; i++) {
                        System.out.println(working.get(i));
                    }

                    break;

                case 2:

                    System.out.print("Enter start year: ");
                    int startYear = scanner.nextInt();

                    System.out.print("Enter end year: ");
                    int endYear = scanner.nextInt();

                    searchByYearRange(working, startYear, endYear);

                    break;

                case 3:

                    System.out.print("Enter color: ");
                    scanner.nextLine();
                    String color = scanner.nextLine();

                    searchByColor(working, color);

                    break;

                case 4:

                    printAverageMileage(working);
                    printCountsByFuel(working);

                    break;

                case 5:

                    System.out.println("Exiting program.");

                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }

    // Selection Sort by Year
    public static void sortByYearAscending(ArrayList<Car> list) {

        for (int i = 0; i < list.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j).getYear() < list.get(minIndex).getYear()) {
                    minIndex = j;
                }
            }

            Car temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    // Binary Search by Year
    public static Car binarySearchByYear(ArrayList<Car> list, int targetYear) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int midYear = list.get(mid).getYear();

            if (midYear == targetYear) {
                return list.get(mid);
            }
            else if (midYear < targetYear) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return null;
    }

    // Search by Year Range
    public static void searchByYearRange(ArrayList<Car> list, int startYear, int endYear) {

        boolean found = false;

        for (Car car : list) {

            if (car.getYear() >= startYear && car.getYear() <= endYear) {
                System.out.println(car);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No cars found in that range.");
        }
    }

    // Search by Color
    public static void searchByColor(ArrayList<Car> list, String color) {

        boolean found = false;

        for (Car car : list) {

            if (car.getColor().equalsIgnoreCase(color)) {
                System.out.println(car);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Color not found.");
        }
    }

    // Average mileage
    public static void printAverageMileage(ArrayList<Car> list) {

        double sum = 0;

        for (Car car : list) {
            sum += car.getMileageKmpl();
        }

        double avg = sum / list.size();

        System.out.printf("Average mileage: %.2f kmpl\n", avg);
    }

    // Count by fuel type
    public static void printCountsByFuel(ArrayList<Car> list) {

        HashMap<String, Integer> counts = new HashMap<>();

        for (Car car : list) {

            String fuel = car.getFuelType();

            counts.put(fuel, counts.getOrDefault(fuel, 0) + 1);
        }

        System.out.println("Counts by fuel type:");

        for (String fuel : counts.keySet()) {

            System.out.println(fuel + ": " + counts.get(fuel));
        }
    }
}