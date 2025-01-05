package com.seatacrental.seatacrental;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.seatacrental.seatacrental.processing.module.Car;

@SpringBootTest
public class CarTest {
    private final Car car = new Car();

    @Test
    public void getACar() {
        assertInstanceOf(Car.class, car);
    }

    @Test
    public void bookACar() {
        boolean carBookingStatus = true;
        car.setBooked(false);
        assertTrue((car.isBooked() != carBookingStatus), "Car is not Booked");
    }

    @Test
    public void testName() {
        String name = "Toyota";
        car.setCarName(name);
        assertTrue((name == car.getCarName()));
    }

    @Test
    public void testRentPay() {
        car.setRentPayForADay(0.5);
        assertEquals(0.5, car.getRentPayForADay());
    }

    @Test
    public void testBookedDays() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    car.setBookedForDays(2);
                });

        assertTrue(exception.getMessage() instanceof String);
    }

    @Test
    public void testBookedDaysNotThrows() {
        assertDoesNotThrow(() -> car.setBookedForDays(3), "Yeah does not Exception");
    }

    
}
