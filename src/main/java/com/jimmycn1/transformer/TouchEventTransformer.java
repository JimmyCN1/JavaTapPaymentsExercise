package com.jimmycn1.transformer;

import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.TapType;
import com.jimmycn1.util.Util;

public class TouchEventTransformer {
  
  public TapEvent from(String[] touchEventCsvLine) {
    return new TapEvent.TapEventBuilder()
            .setId(new Long(touchEventCsvLine[0]))
            .setDateTime(Util.parseDateTime(touchEventCsvLine[1]))
            .setTabType(TapType.valueOf(touchEventCsvLine[2]))
            .setStop(Stop.fromString(touchEventCsvLine[3]))
            .setCompanyId(touchEventCsvLine[4])
            .setVehicleId(touchEventCsvLine[5])
            .setPan(touchEventCsvLine[6]).build();
  }
}
