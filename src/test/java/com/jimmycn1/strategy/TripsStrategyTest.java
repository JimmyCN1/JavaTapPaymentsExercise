package com.jimmycn1.strategy;

import com.jimmycn1.domain.CommuterTrip;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.TripStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.jimmycn1.calculator.Fixtures.createTapOffEvent;
import static com.jimmycn1.calculator.Fixtures.createTapOnEvent;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TripsStrategyTest {
  private TripsStrategy objectUnderTest = new TripsStrategy();
  
  @Test
  public void shouldCreateTwoTripsForTheDay() {
    List<TapEvent> tapEvents = Arrays.asList(
            createTapOnEvent().build(),
            createTapOffEvent().build(),
            createTapOnEvent().build(),
            createTapOffEvent().build()
    );
    
    List<CommuterTrip> trips = objectUnderTest.createTripsPerVehicleForTheDay(tapEvents);
    
    assertEquals(trips.size(), 2);
    assertEquals(trips.get(0).getStarted(), LocalDateTime.of(2020, 11, 10, 14, 0));
    assertEquals(trips.get(0).getFinished(), LocalDateTime.of(2020, 11, 10, 15, 0));
    assertEquals(trips.get(0).getDurationSeconds(), 3600);
    assertEquals(trips.get(0).getFromStop().stopNumber, "Stop1");
    assertEquals(trips.get(0).getToStop().stopNumber, "Stop2");
    assertEquals(trips.get(0).getChargeAmount(), 3.25);
    assertEquals(trips.get(0).getCompanyId(), "company1");
    assertEquals(trips.get(0).getVehicleId(), "vehicle1");
    assertEquals(trips.get(0).getPan(), "55000055555555592");
    assertEquals(trips.get(0).getStatus(), TripStatus.COMPLETED);
  
    assertEquals(trips.get(1).getStarted(), LocalDateTime.of(2020, 11, 10, 14, 0));
    assertEquals(trips.get(1).getFinished(), LocalDateTime.of(2020, 11, 10, 15, 0));
    assertEquals(trips.get(1).getDurationSeconds(), 3600);
    assertEquals(trips.get(1).getFromStop().stopNumber, "Stop1");
    assertEquals(trips.get(1).getToStop().stopNumber, "Stop2");
    assertEquals(trips.get(1).getChargeAmount(), 3.25);
    assertEquals(trips.get(1).getCompanyId(), "company1");
    assertEquals(trips.get(1).getVehicleId(), "vehicle1");
    assertEquals(trips.get(1).getPan(), "55000055555555592");
    assertEquals(trips.get(1).getStatus(), TripStatus.COMPLETED);
  }
  
  @Test
  public void shouldCreateListOfTripsWithFinalIncompleteTrip() {
    List<TapEvent> tapEvents = Arrays.asList(
            createTapOnEvent().build(),
            createTapOffEvent().build(),
            createTapOnEvent().build()
    );
  
    List<CommuterTrip> trips = objectUnderTest.createTripsPerVehicleForTheDay(tapEvents);
  
    assertEquals(trips.size(), 2);
    assertEquals(trips.get(1).getStarted(), LocalDateTime.of(2020, 11, 10, 14, 0));
    assertEquals(trips.get(1).getFinished(), LocalDateTime.of(2020, 11, 10, 23, 59));
    assertEquals(trips.get(1).getDurationSeconds(), 0);
    assertEquals(trips.get(1).getFromStop().stopNumber, "Stop1");
    assertEquals(trips.get(1).getToStop().stopNumber, "None");
    assertEquals(trips.get(1).getChargeAmount(), 7.3);
    assertEquals(trips.get(1).getCompanyId(), "company1");
    assertEquals(trips.get(1).getVehicleId(), "vehicle1");
    assertEquals(trips.get(1).getPan(), "55000055555555592");
    assertEquals(trips.get(1).getStatus(), TripStatus.INCOMPLETE);
  }
}