package com.parkinglot;

import com.parkinglot.model.spot.CompactSpot;
import com.parkinglot.model.spot.LargeSpot;
import com.parkinglot.model.vehicles.Bike;
import com.parkinglot.model.vehicles.Car;
import com.parkinglot.service.ParkingLot;

public class Main {
    public static void main(String[] args) {

        ParkingLot lot = ParkingLot.getInstance();

        lot.addLargeSpot(new LargeSpot(1));
        lot.addLargeSpot(new LargeSpot(2));
        lot.addCompactSpot(new CompactSpot(3));
        lot.addCompactSpot(new CompactSpot(4));

        System.out.println("=== Parking Lot Ready ===\n");

        Car car1 = new Car("DL01AB1234");
        Car car2 = new Car("DL02CD5678");
        Bike bike1 = new Bike("DL03EF9999");

        lot.parkVehicle(car1);
        lot.parkVehicle(car2);
        lot.parkVehicle(bike1);

        System.out.println();

        Car car3 = new Car("DL04GH0000");
        lot.parkVehicle(car3);

        System.out.println();

        lot.freeSpot("DL01AB1234");
        lot.parkVehicle(car3);

        System.out.println();

        ParkingLot lot2 = ParkingLot.getInstance();
        System.out.println("Same instance? " + (lot == lot2));
    }
}