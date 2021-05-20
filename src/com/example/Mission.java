package com.example;

import java.time.LocalDate;

public class Mission {
    private Car car;
    private String target;
    private LocalDate date;
    private int distance;
    private double fuelConsumption;

    public Mission(Car car, int distance, double fuelConsumption) {
        this(car, "not specified", LocalDate.now(), distance, fuelConsumption);
    }

    public Mission(Car car, String target, LocalDate date, int distance, double fuelConsumption) {
        this.car = car;
        this.target = target;
        this.date = date;
        this.distance = distance;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return getDescription();
    }

    public String getDescription() {
        return "Business mission: "+getCar().getDescription()+" to "+getTarget()+" on "+date.toString();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDistance() {
        return distance;
    }

    /**
     * Distance should be positive. For negative value - sets 0 km.
     * @param distance Must be positive.
     */
    public void setDistance(int distance) {
        if (distance >= 0) {
            this.distance = distance;
        } else {
            this.distance = 0;
        }
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}