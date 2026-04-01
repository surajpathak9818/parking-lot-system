package com.parkinglot.model.spot;

import com.parkinglot.enums.VehicleType;

public class CompactSpot extends ParkingSpot {

    public CompactSpot(int spotNumber) {
        super(spotNumber);
    }

    @Override
    public VehicleType getSpotType() {
        return VehicleType.BIKE;
    }
}