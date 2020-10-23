package com.jimmycn1.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
  public final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
  
  public static LocalDateTime parseDateTime(String s) {
    LocalDateTime dateTime = LocalDateTime.parse(s, dateTimeFormatter);
    return dateTime;
  }
}
