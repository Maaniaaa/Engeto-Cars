package com.example;

import java.time.LocalDate;
import java.util.IllegalFormatException;

public class Car {

    private static final String FILE_ITEM_DELIMITER = "\t";
    private String brand;
    private String make;
    private int numOfSeats;
    private String licenseNumber;
    private int power;
    private LocalDate nextCheckDate;
    private FuelType fuelType;

    public static Car parseText(String record) {
        String[] items = record.split(FILE_ITEM_DELIMITER);

        if (items.length != 7) throw new CarsException("Špatný počet položek  na řádku: "+record);

        String brand = items[0];
        String make;
        int numOfSeats;
        String licenseNumber;
        int power;
        LocalDate nextCheckDate;
        FuelType fuelType;
    }

    public Car(String brand, String licenseNumber, LocalDate nextCheckDate) {
        this(brand, "", 5, licenseNumber, 0, nextCheckDate, FuelType.PETROL);
    }

    public Car(String brand, String make, int numOfSeats, String licenseNumber, int power, LocalDate nextCheckDate, FuelType fuel) {
        this.brand = brand;
        this.make = make;
        this.numOfSeats = numOfSeats;
        this.licenseNumber = licenseNumber;
        this.power = power;
        this.nextCheckDate = nextCheckDate;
        this.fuelType = fuel;
    }

    public void setNumOfSeats(String numberAsText) {
        numOfSeats = Integer.parseInt(numberAsText);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setSeats(int seats) throws CarsException {
        if (seats <=0) throw new CarsException("Zadán počet sedadal menší než 0");
        this.numOfSeats = seats;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public LocalDate getNextCheckDate() {
        return nextCheckDate;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Pokud je nextCheckDate starší než dnešní datum, použijeme místo něj dnešní datum.
     * @param nextCheckDate
     */
    public void setNextCheckDate(LocalDate nextCheckDate) {
        if (nextCheckDate.isBefore(LocalDate.now())) {
            this.nextCheckDate = LocalDate.now();
        } else {
            this.nextCheckDate = nextCheckDate;
        }
    }

    public String getDescription() {
        return getBrand()+" "+getMake()+" ("+getLicenseNumber()+"): "+getNumOfSeats()+" seats";
    }
}
