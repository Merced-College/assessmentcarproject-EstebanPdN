# AI Assistant Guidance for AssessmentCarProject

This is a minimal Java project used in a CPSC‑39 class. The goal is to load and analyze a dataset `Car_Data.csv` containing information about cars. The codebase currently consists of three top‑level `.java` files and a CSV data file.

## Big Picture

- **Data Model**: `Car.java` defines a simple data class with fields matching the columns of `Car_Data.csv`:
  `carID`, `brand`, `model`, `year`, `fuelType`, `color`, `mileageKmpl`.
  It has a constructor, getters, and a `toString` that joins the fields with commas.

- **Data Loading**: `CarDataLoader.java` is intended to read the CSV file and return a list of `Car` objects. The file is currently empty; your task is usually to implement parsing logic using `BufferedReader`, `String.split`, etc.

- **Entry Point**: `Main.java` is the program entry point. It should call the loader and then perform any requested analysis (sorting, filtering, statistics). The skeleton is empty as well; most assignments require adding menu-driven or hard‑coded examples.

- **Data File**: `Car_Data.csv` lives in the project root. Code should open it with a relative path and assume the first line may be a header (students often skip it).

## Build & Run

- No external dependencies; just plain Java (targeting whatever JDK the dev container provides).
- **Compile**: run `javac *.java` from the project root. This will produce `*.class` files in the same directory.
- **Run**: `java Main` after compilation. The program expects `Car_Data.csv` next to the class files.
- There are no unit tests in the repository. Instructors often run the program manually or via `java Main` after building.

## Project Conventions

- No packages are used; all classes reside in the default package. Avoid adding packages unless necessary for new structure.
- File names exactly correspond to class names (`Car.java`, etc.).
- CSV parsing should be robust to whitespace and handle empty lines gracefully.
- When referring to the dataset in code examples, use `new File("Car_Data.csv")` or similar, not hard‑coded absolute paths.

## Common Tasks & Patterns

- **Loading the CSV**: read line-by-line, `String[] fields = line.split(",")`, convert types (`Integer.parseInt`, `Double.parseDouble`).
- **Filtering**: use loops or Java streams (`List<Car> list = cars.stream().filter(c -> c.getYear() > 2010).collect(Collectors.toList());`).
- **Sorting**: students often sort by year or mileage. Use `Collections.sort(cars, Comparator.comparingInt(Car::getYear));`.
- **Printing**: rely on `Car.toString()` for simple output.

## Developer Workflow Notes

- There is no build system (Maven/Gradle); edits are quick to compile/run.
- Debugging can be done by running `Main` in the IDE or using `System.out.println` statements.
- If you create new classes, remember to compile them with `javac` as well.

## Extending the Project

- Add analyses in `Main` or create additional helper classes (e.g. `CarStatistics`).
- Ensure any new source files remain in the root or add package declarations consistently.
- Keep the dataset file immutable; modifications should be done on a copy.

---

If any part of the project structure or expected behavior is unclear, ask for clarification before implementing features.