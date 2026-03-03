/*
 * Name: Esteban Pereira das Neves
 * Date: 03/03/2026
 * Project: Car Data Analyzer
 * Description: Main class - handles sorting, searching, stats and menu
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Car> cars = CarDataLoader.loadCars("Car_Data.csv");

        ArrayList<Car> working =
                new ArrayList<>(cars.subList(0, 2000));

        boolean running = true;

        while (running) {

            System.out.println("\n===== CAR DATA ANALYZER =====");
            System.out.println("1. Search by Year");
            System.out.println("2. Sort by Year (ascending)");
            System.out.println("3. Show Statistics");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    // Must sort first before binary search
                    sortByYearAscending(working);

                    System.out.print("Enter year to search: ");
                    int year = scanner.nextInt();

                    Car found = binarySearchByYear(working, year);

                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Year not found.");
                    }
                    break;

                case 2:
                    sortByYearAscending(working);
                    System.out.println("Sorted by year ascending.");
                    for (int i = 0; i < 10; i++) {
                        System.out.println(working.get(i));
                    }
                    break;

                case 3:
                    printAverageMileage(working);
                    printCountsByFuel(working);
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    // Selection Sort by Year (ascending)
    public static void sortByYearAscending(ArrayList<Car> list) {

        for (int i = 0; i < list.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j).getYear() < list.get(minIndex).getYear()) {
                    minIndex = j;
                }
            }

            // Swap
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

        return null; // not found
    }

    // Average mileage (Step 5 requirement)
    private static void printAverageMileage(ArrayList<Car> list) {

        double sum = 0;

        for (Car c : list) {
            sum += c.getMileageKmpl();
        }

        double avg = list.isEmpty() ? 0 : sum / list.size();

        System.out.printf("Average mileage: %.2f kmpl\n", avg);
    }

    // Count by fuel type (Step 5 requirement)
    private static void printCountsByFuel(ArrayList<Car> list) {

        Map<String, Integer> counts = new HashMap<>();

        for (Car c : list) {
            counts.put(c.getFuelType(),
                    counts.getOrDefault(c.getFuelType(), 0) + 1);
        }

        System.out.println("Counts by fuel type:");

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}