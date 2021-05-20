package com.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String INPUT_FILE = "data/cars.txt";
    private static final String OUTPUT_FILE = "data/vystup.txt";

    public static void main(String[] args) {
        // System.out.println("Ahoj\tKarle,\njak se máš?\\ Říkám: \"Jak se máš?\"");

        CarList carList = new CarList();

        // Chceme načíst automobily ze souboru cars.txt
        carList.importFromFile(INPUT_FILE);

        // Vypíšeme načtená auta:
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.getCar(i);
            System.out.println(car.getDescription()+" ("+car.getFuelType()+")");
        }

        // Vypustíme ze seznamu první auto:
        carList.removeCar(0);

        // Přidáme do seznamu další dvě ručně vytvořená auta:
        carList.addCar(
                new Car("Volkswagen", "1A2 34 56",
                        LocalDate.now().plusYears(2))
        );
        carList.addCar(
                new Car("Volkswagen", "1A2 34 56",
                        LocalDate.now().plusYears(2))
        );

        // Vypíšeme upravený seznam do souboru OUTPUT_FILE:
        carList.exportToFile(OUTPUT_FILE);


        //        // Kdybychom neměli k dispozici try-with-resources:
        //        Scanner scanner = null;
        //        try {
        //            scanner = new Scanner(new BufferedReader(new FileReader(INPUT_FILE)));
        //            // ...
        //        } catch (FileNotFoundException e) {
        //            System.err.println("Soubor "+INPUT_FILE+" nebyl nalezen: "+e.getLocalizedMessage());
        //        } finally {
        //            if (scanner != null) {
        //                scanner.close();
        //            }
        //        }

    }

    public static void main1(String[] args) {
        Car car = new Car("Škoda", "3Z1 52 13", LocalDate.of(2021, 5, 12));

        try {
            car.setSeats(-5);
        } catch (CarsException e) {
            System.err.println("Nepodařilo se nastavit počet sedadel! "+e.getLocalizedMessage());
            e.printStackTrace();
        }

        System.out.println(car.getNumOfSeats());
    }
}