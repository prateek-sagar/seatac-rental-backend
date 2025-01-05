package com.seatacrental.seatacrental.processing.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private boolean isBooked;
    private String carName;
    private double rentPayForADay;
    private int bookedForDays;
    private int minimumBookedDays = 3;

    public void setBookedForDays(int days) {
        if (days < minimumBookedDays) {
            throw new IllegalArgumentException("The days must be atleast" + minimumBookedDays);
        }
        bookedForDays = days;
    }

    
}
