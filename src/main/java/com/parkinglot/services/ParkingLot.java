package com.parkinglot.service;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.model.spot.CompactSpot;
import com.parkinglot.model.spot.LargeSpot;
import com.parkinglot.model.spot.ParkingSpot;
import com.parkinglot.model.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot instance;

    private List<CompactSpot> compactSpots;
    private List<LargeSpot> largeSpots;

    private ParkingLot() {
        compactSpots = new ArrayList<>();
        largeSpots = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addCompactSpot(CompactSpot spot) {
        compactSpots.add(spot);
    }

    public void addLargeSpot(LargeSpot spot) {
        largeSpots.add(spot);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findFreeSpot(vehicle.getType());

        if (spot == null) {
            System.out.println("No free spot for: " + vehicle.getLicensePlate());
            return false;
        }

        spot.occupy(vehicle);
        System.out.println(vehicle.getLicensePlate() + " parked at spot " + spot.getSpotNumber());
        return true;
    }

    public void freeSpot(String licensePlate) {
        for (CompactSpot spot : compactSpots) {
            if (!spot.isFree() &&
                    spot.getCurrentVehicle().getLicensePlate().equals(licensePlate)) {
                spot.release();
                System.out.println("Spot " + spot.getSpotNumber() + " is now free!");
                return;
            }
        }

        for (LargeSpot spot : largeSpots) {
            if (!spot.isFree() &&
                    spot.getCurrentVehicle().getLicensePlate().equals(licensePlate)) {
                spot.release();
                System.out.println("Spot " + spot.getSpotNumber() + " is now free!");
                return;
            }
        }

        System.out.println("Vehicle not found: " + licensePlate);
    }

    private ParkingSpot findFreeSpot(VehicleType type) {
        if (type == VehicleType.BIKE) {
            for (CompactSpot spot : compactSpots) {
                if (spot.isFree()) return spot;
            }
        } else if (type == VehicleType.CAR) {
            for (LargeSpot spot : largeSpots) {
                if (spot.isFree()) return spot;
            }
        }
        return null;
    }
}