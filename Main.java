/*
 * Name: Esteban Pereira das Neves
 * Date: 03/03/2026
 * Project: Car Data Analyzer
 * Description: Main class
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> cars = CarDataLoader.loadCars("Car_Data.csv");

        ArrayList<Car> working =
                new ArrayList<>(cars.subList(0, 2000));

        // Sorting by year ascending
        sortByYearAscending(working);

        // Print first 10 cars after sorting
        for (int i = 0; i < 10; i++) {
            System.out.println(working.get(i));
        }

        // Test Binary Search
        Car found = binarySearchByYear(working, 2010);

        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Year not found.");
        }
    }

    // Selection sort by year 
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
}