package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CarList {

    private ArrayList<Car> data = new ArrayList<>();

    public void addCar(Car car) {
        data.add(car);
    }

    public Car getCar(int index) {
        return data.get(index);
    }

    public void removeCar(int index) {
        data.remove(index);
    }

    public int size() {
        return data.size();
    }

    public void clear() {
        data.clear();
    }

    public void importFromFile(String pathToFile) {
        // Pokud chci stávající vozidla zrušit a pak až načítat nové, volal bych:
        //data.clear();
        try (
                Scanner scanner = new Scanner(
                        new BufferedReader(new FileReader(pathToFile))
                )
        ) {
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                data.add(Car.parseCar(nextLine));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Soubor "+pathToFile+" nebyl nalezen: "+e.getLocalizedMessage());
        } catch (CarsException e) {
            System.err.println("Chyba v souboru "+pathToFile+": "+e.getLocalizedMessage());
        }
    }

    public void exportToFile(String outputFile) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(outputFile)))
        ) {
            for (Car car: data) {
                writer.println(car.prepareToWrite());
            }
        } catch (IOException e) {
            System.err.println(
                    "Chyba při zápisu do souboru "+outputFile
                            +": "+e.getLocalizedMessage());
        }
    }
}