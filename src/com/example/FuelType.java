package com.example;

public enum FuelType {
    PETROL("benzín"),
    DIESEL("nafta"),
    PLUGIN_HYBRID("plug-in hybrid"),
    LPG("LPG");

    private String description;

//    private FuelType(String description) {
//        this.description = description;
//    }

    FuelType(String description) {
        this.description = description;
    }

    public String toString() {
        return description;
    }
}
