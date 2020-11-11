package com.jimmycn1.transformer;

import com.jimmycn1.domain.CommuterTrip;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.TripStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.jimmycn1.calculator.Fixtures.createTapOffEvent;
import static com.jimmycn1.calculator.Fixtures.createTapOnEvent;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CommuterTripTransformerTest {
  
  private CommuterTripTransformer objectUnderTest = new CommuterTripTransformer();
  
  @Test
  public void shouldCreateCompleteTrip() {
    TapEvent tapOnEvent = createTapOnEvent().build();
    TapEvent tapOffEvent = createTapOffEvent().build();
    
    CommuterTrip commuterTrip = objectUnderTest.from(tapOnEvent, tapOffEvent);
  
    assertEquals(commuterTrip.getStarted(), LocalDateTime.of(2020, 11, 10, 14, 0));
    assertEquals(commuterTrip.getFinished(), LocalDateTime.of(2020, 11, 10, 15, 0));
    assertEquals(commuterTrip.getDurationSeconds(), 3600);
    assertEquals(commuterTrip.getFromStop().stopNumber, "Stop1");
    assertEquals(commuterTrip.getToStop().stopNumber, "Stop2");
    assertEquals(commuterTrip.getChargeAmount(), 3.25);
    assertEquals(commuterTrip.getCompanyId(), "company1");
    assertEquals(commuterTrip.getVehicleId(), "vehicle1");
    assertEquals(commuterTrip.getPan(), "55000055555555592");
    assertEquals(commuterTrip.getStatus(), TripStatus.COMPLETED);
  }
  
  @Test
  public void shouldCreateIncompleteTrip() {
    TapEvent tapOnEvent = createTapOnEvent().build();
    
    CommuterTrip commuterTrip = objectUnderTest.from(tapOnEvent);
  
    assertEquals(commuterTrip.getStarted(), LocalDateTime.of(2020, 11, 10, 14, 0));
    assertEquals(commuterTrip.getFinished(), LocalDateTime.of(2020, 11, 10, 23, 59));
    assertEquals(commuterTrip.getDurationSeconds(), 0);
    assertEquals(commuterTrip.getFromStop().stopNumber, "Stop1");
    assertEquals(commuterTrip.getToStop().stopNumber, "None");
    assertEquals(commuterTrip.getChargeAmount(), 7.3);
    assertEquals(commuterTrip.getCompanyId(), "company1");
    assertEquals(commuterTrip.getVehicleId(), "vehicle1");
    assertEquals(commuterTrip.getPan(), "55000055555555592");
    assertEquals(commuterTrip.getStatus(), TripStatus.INCOMPLETE);
  }
}