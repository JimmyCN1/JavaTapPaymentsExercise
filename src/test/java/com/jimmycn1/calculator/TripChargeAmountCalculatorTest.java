package com.jimmycn1.calculator;

import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.TapEvent;
import org.junit.jupiter.api.Test;

import static com.jimmycn1.calculator.Fixtures.createTapOffEvent;
import static com.jimmycn1.calculator.Fixtures.createTapOnEvent;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TripChargeAmountCalculatorTest {
  
  private TripChargeAmountCalculator objectUnderTest = new TripChargeAmountCalculator();
  
  @Test
  public void shouldCalculateMaxChargeAmountFromStop() {
    TapEvent tapOnEvent = createTapOnEvent().build();
    
    double maxCharge = objectUnderTest.calculateMaxChargeAmount(tapOnEvent);
    
    assertEquals(maxCharge, 7.3);
  }
  
  @Test
  public void shouldCorrectlyCalculateShortTrip() {
    TapEvent tapOnEvent = createTapOnEvent().setStop(Stop.ONE).build();
    TapEvent tapOffEvent = createTapOffEvent().setStop(Stop.TWO).build();
    
    double charge = objectUnderTest.calculateChargeAmount(tapOnEvent, tapOffEvent);
    
    assertEquals(charge, 3.25);
  }
  
  @Test
  public void shouldCorrectlyCalculateLongTrip() {
    TapEvent tapOnEvent = createTapOnEvent().setStop(Stop.ONE).build();
    TapEvent tapOffEvent = createTapOffEvent().setStop(Stop.THREE).build();
    
    double charge = objectUnderTest.calculateChargeAmount(tapOnEvent, tapOffEvent);
    
    assertEquals(charge, 7.3);
  }
  
  @Test
  public void shouldCorrectlyCalculateReverseShortTrip() {
    TapEvent tapOnEvent = createTapOnEvent().setStop(Stop.THREE).build();
    TapEvent tapOffEvent = createTapOffEvent().setStop(Stop.TWO).build();
    
    double charge = objectUnderTest.calculateChargeAmount(tapOnEvent, tapOffEvent);
    
    assertEquals(charge, 5.5);
  }
  
  @Test
  public void shouldCorrectlyCalculateReverseLongTrip() {
    TapEvent tapOnEvent = createTapOnEvent().setStop(Stop.THREE).build();
    TapEvent tapOffEvent = createTapOffEvent().setStop(Stop.ONE).build();
    
    double charge = objectUnderTest.calculateChargeAmount(tapOnEvent, tapOffEvent);
    
    assertEquals(charge, 7.3);
  }
}