package com.parkinglot.model.spot;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.model.vehicles.Vehicle;

public abstract class ParkingSpot {

    private int spotNumber;
    private boolean isFree;
    private Vehicle currentVehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isFree = true;
        this.currentVehicle = null;
    }

    public abstract VehicleType getSpotType();

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isFree() {
        return isFree;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    // ✅ ADD THIS
    public void occupy(Vehicle vehicle) {
        this.currentVehicle = vehicle;
        this.isFree = false;
    }

    // ✅ ADD THIS
    public void release() {
        this.currentVehicle = null;
        this.isFree = true;
    }
}