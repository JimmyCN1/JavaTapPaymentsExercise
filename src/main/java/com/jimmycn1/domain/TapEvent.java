package com.jimmycn1.domain;

import java.time.LocalDateTime;

public class TapEvent {
  private final Long id;
  private final LocalDateTime dateTime;
  private final TapType tabType;
  private final Stop stop;
  private final String companyId;
  private final String vehicleId;
  private final String pan;
  
  public TapEvent(Long id,
                  LocalDateTime dateTime,
                  TapType tabType,
                  Stop stop,
                  String companyId,
                  String vehicleId,
                  String pan) {
    this.id = id;
    this.dateTime = dateTime;
    this.tabType = tabType;
    this.stop = stop;
    this.companyId = companyId;
    this.vehicleId = vehicleId;
    this.pan = pan;
  }
  
  public Long getId() {
    return id;
  }
  
  public LocalDateTime getDateTime() {
    return dateTime;
  }
  
  public TapType getTapType() {
    return tabType;
  }
  
  public Stop getStop() {
    return stop;
  }
  
  public String getCompanyId() {
    return companyId;
  }
  
  public String getVehicleId() {
    return vehicleId;
  }
  
  public String getPan() {
    return pan;
  }
}
