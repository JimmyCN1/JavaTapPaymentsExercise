package com.jimmycn1.transformer;

import com.jimmycn1.domain.Stop;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.domain.TapType;
import com.jimmycn1.util.Util;

public class TouchEventTransformer {
  
  public TapEvent from(String[] touchEventCsvLine) {
    return new TapEvent(
            new Long(touchEventCsvLine[0]),
            Util.parseDateTime(touchEventCsvLine[1]),
            TapType.valueOf(touchEventCsvLine[2]),
            Stop.fromString(touchEventCsvLine[3]),
            touchEventCsvLine[4],
            touchEventCsvLine[5],
            touchEventCsvLine[6]
    );
  }
}
