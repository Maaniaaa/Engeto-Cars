package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String INPUT_FILE = "cars.txt";

    public static void main(String[] args) {
       //načítání ze souboru cars.txt
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(INPUT_FILE)))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Soubor " + INPUT_FILE + " nenalezen " + e.getLocalizedMessage());
        }
    }

    public static void main1(String[] args) {
       /* ArrayList<Car> listOfCars = new ArrayList<>();
        ArrayList<Mission> listOfMissions = new ArrayList<>();

        listOfCars.add(new Car("Škoda", "3Z1 52 13", LocalDate.of(2021, 5, 12)));
        listOfCars.add(new Car("Škoda", "3Z1 52 14", LocalDate.of(2021, 4, 15)));
        listOfCars.add(new Car("Škoda", "3Z1 52 15", LocalDate.of(2021, 4, 15)));

        listOfMissions.add(new Mission(listOfCars.get(0), 325, 325/100*6.5));
        listOfMissions.add(new Mission(listOfCars.get(1), 215, 215/100*6.45));
        listOfMissions.add(new Mission(listOfCars.get(0), 421, 421/100*5.84));

        // ...

        // Vypišme pracovní cesty s délkou přes 300 km (a přesně 300 km):
        for (Mission mission : listOfMissions) {
            int missionDistance = mission.getDistance();
            if (missionDistance > 300) {
                System.out.println(mission.getDescription() + " ("+missionDistance+" km)");
            } else if (missionDistance == 300) {
                System.out.println(mission.getDescription() + " (přesně 300 km)");
            }
        }

        // Porovnání čísel ==


        // Porovnávání textů
        String target = "Brn";
        target += "o";
        System.out.println(target);
        // Takhle to má být:
        if (target.equals("Brno")) {
            System.out.println("Zajeď si i do Engeta! ;)");
        }
        // TAKHLE NE!!!
        if (target == "Brno") { // POZOR!!! To znamená, jestli jsou to stejné objekty
            System.out.println("Zajeď si i do Engeta! ;)");
        } else {
            System.out.println("Tady Engeto není.");
        }
        // Porovnání „wrappovaných“ čísla: Double, Integer
        Double desetinne = Double.valueOf(0.1);
        if (desetinne.equals(Double.valueOf(0.1))) {
            System.out.println("Hurá, je to stejné!");
        }
        // U našich vlastních tříd se chová equals() stejně jako ==
        Car car1 = new Car("Škoda", "3Z1 52 13", LocalDate.of(2021, 5, 12));
        Car car2 = new Car("Škoda", "3Z1 52 13", LocalDate.of(2021, 5, 12));
        if (car1.equals(car1)) {
            System.out.println("Jsou stejné");
        } else {
            System.out.println("Jsou jiné");
        }

        car1.setFuelType(FuelType.PLUGIN_HYBRID);
        if (car1.getFuelType() == car2.getFuelType()) {
            System.out.println("Mají stejný typ paliva");
        }
        System.out.println(car1.getDescription() + " používá palivo "+ car1.getFuelType().toString());

        // Tento if-else if-else je hodně dlouhý a nepřehledný:
        Integer value = 0;

        if (value == 0) {
            // A
        } else if (value == 1 || value == 2)  {
            // A
            // B
        } else if (value == 3) {
            // A
            // C
        } else if (value == 4) {
            // C
        } else  {
            // C
            // D
        }
        // Dá se napsat i pomocí switch
        switch (value) {
            case 0:
                System.out.println("Nula");
                break;
            case 1:
                System.out.println("Jedna");
                break;
            case 11:
                System.out.println("Eso");
                break;
            default:
                System.out.println("Něco jiného!");
        }*/

        Car car = new Car("Škoda", "3Z1 52 13", LocalDate.of(2021, 5, 12));
        try {
            car.setSeats(-5);
        } catch (CarsException e) {
            System.err.println("Nepodařilo se nastavit počet sedadel. " +e.getLocalizedMessage());
        }
        System.out.println(car.getNumOfSeats());
    }
}
