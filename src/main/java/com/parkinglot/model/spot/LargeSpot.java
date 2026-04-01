package com.parkinglot.model.spot;

import com.parkinglot.enums.VehicleType;

public class LargeSpot extends ParkingSpot {

    public LargeSpot(int spotNumber) {
        super(spotNumber);
    }

    @Override
    public VehicleType getSpotType() {
        return VehicleType.CAR;
    }
}