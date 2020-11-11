package com.jimmycn1.transformer;

import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.TapType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TouchEventTransformerTest {
  private TouchEventTransformer objectUnderTest = new TouchEventTransformer();
  
  @Test
  public void shouldCorrectlyParseTouchOnEvent() {
    String[] touchOnEvent = "1,22-01-2018 13:00:00,ON,Stop1,Company1,Bus37,5500005555555559".split(",");
    
    TapEvent parsedTapEvent = objectUnderTest.from(touchOnEvent);
    
    assertEquals(parsedTapEvent.getId(), 1L);
    assertEquals(parsedTapEvent.getDateTime(), LocalDateTime.of(2018, 1, 22, 13, 0));
    assertEquals(parsedTapEvent.getTapType(), TapType.ON);
    assertEquals(parsedTapEvent.getStop(), Stop.ONE);
    assertEquals(parsedTapEvent.getCompanyId(), "Company1");
    assertEquals(parsedTapEvent.getVehicleId(), "Bus37");
    assertEquals(parsedTapEvent.getPan(), "5500005555555559");
  }
  
  @Test
  public void shouldCorrectlyParseTouchOffEvent() {
    String[] touchOnEvent = "2,22-01-2018 13:05:00,OFF,Stop2,Company1,Bus37,5500005555555559".split(",");
    
    TapEvent parsedTapEvent = objectUnderTest.from(touchOnEvent);
    
    assertEquals(parsedTapEvent.getId(), 2L);
    assertEquals(parsedTapEvent.getDateTime(), LocalDateTime.of(2018, 1, 22, 13, 5));
    assertEquals(parsedTapEvent.getTapType(), TapType.OFF);
    assertEquals(parsedTapEvent.getStop(), Stop.TWO);
    assertEquals(parsedTapEvent.getCompanyId(), "Company1");
    assertEquals(parsedTapEvent.getVehicleId(), "Bus37");
    assertEquals(parsedTapEvent.getPan(), "5500005555555559");
  }
}