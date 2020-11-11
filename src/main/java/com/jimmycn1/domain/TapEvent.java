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
  
  private TapEvent(Long id,
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
  
  public static class TapEventBuilder {
    private Long id;
    private LocalDateTime dateTime;
    private TapType tabType;
    private Stop stop;
    private String companyId;
    private String vehicleId;
    private String pan;
    
    public TapEventBuilder setId(Long id) {
      this.id = id;
      return this;
    }
    
    public TapEventBuilder setDateTime(LocalDateTime dateTime) {
      this.dateTime = dateTime;
      return this;
    }
    
    public TapEventBuilder setTabType(TapType tabType) {
      this.tabType = tabType;
      return this;
    }
    
    public TapEventBuilder setStop(Stop stop) {
      this.stop = stop;
      return this;
    }
    
    public TapEventBuilder setCompanyId(String companyId) {
      this.companyId = companyId;
      return this;
    }
    
    public TapEventBuilder setVehicleId(String vehicleId) {
      this.vehicleId = vehicleId;
      return this;
    }
    
    public TapEventBuilder setPan(String pan) {
      this.pan = pan;
      return this;
    }
    
    public TapEvent build() {
      return new TapEvent(id, dateTime, tabType, stop, companyId, vehicleId, pan);
    }
  }
}
