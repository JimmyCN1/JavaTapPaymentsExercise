package com.jimmycn1.domain;

import com.jimmycn1.util.Util;

import java.time.LocalDateTime;

public class CommuterTrip {
  private final LocalDateTime started;
  private final LocalDateTime finished;
  private final Long durationSeconds;
  private final Stop fromStop;
  private final Stop toStop;
  private final Double chargeAmount;
  private final String companyId;
  private final String vehicleId;
  private final String pan;
  private final TripStatus status;
  
  public CommuterTrip(LocalDateTime started,
                      LocalDateTime finished,
                      Long durationSeconds,
                      Stop fromStop,
                      Stop toStop,
                      Double chargeAmount,
                      String companyId,
                      String vehicleId,
                      String pan,
                      TripStatus status) {
    this.started = started;
    this.finished = finished;
    this.durationSeconds = durationSeconds;
    this.fromStop = fromStop;
    this.toStop = toStop;
    this.chargeAmount = chargeAmount;
    this.companyId = companyId;
    this.vehicleId = vehicleId;
    this.pan = pan;
    this.status = status;
  }
  
  public LocalDateTime getStarted() {
    return started;
  }
  
  public LocalDateTime getFinished() {
    return finished;
  }
  
  public Long getDurationSeconds() {
    return durationSeconds;
  }
  
  public Stop getFromStop() {
    return fromStop;
  }
  
  public Stop getToStop() {
    return toStop;
  }
  
  public Double getChargeAmount() {
    return chargeAmount;
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
  
  public TripStatus getStatus() {
    return status;
  }
  
  public String[] tostringArray() {
    return new String[]{
            started.format(Util.dateTimeFormatter),
            finished.format(Util.dateTimeFormatter),
            durationSeconds.toString(),
            fromStop.getStopNumber(),
            toStop.getStopNumber(),
            chargeAmount.toString(),
            companyId,
            vehicleId,
            pan,
            status.toString()
    };
  }
  
  public static class CommuterTripBuilder {
    private LocalDateTime started;
    private LocalDateTime finished;
    private Long durationSeconds;
    private Stop fromStop;
    private Stop toStop;
    private Double chargeAmount;
    private String companyId;
    private String vehicleId;
    private String pan;
    private TripStatus status;
    
    public CommuterTripBuilder setStarted(LocalDateTime started) {
      this.started = started;
      return this;
    }
    
    public CommuterTripBuilder setFinished(LocalDateTime finished) {
      this.finished = finished;
      return this;
    }
    
    public CommuterTripBuilder setDurationSeconds(Long durationSeconds) {
      this.durationSeconds = durationSeconds;
      return this;
    }
    
    public CommuterTripBuilder setFromStop(Stop fromStop) {
      this.fromStop = fromStop;
      return this;
    }
    
    public CommuterTripBuilder setToStop(Stop toStop) {
      this.toStop = toStop;
      return this;
    }
    
    public CommuterTripBuilder setChargeAmount(Double chargeAmount) {
      this.chargeAmount = chargeAmount;
      return this;
    }
    
    public CommuterTripBuilder setCompanyId(String companyId) {
      this.companyId = companyId;
      return this;
    }
    
    public CommuterTripBuilder setVehicleId(String vehicleId) {
      this.vehicleId = vehicleId;
      return this;
    }
    
    public CommuterTripBuilder setPan(String pan) {
      this.pan = pan;
      return this;
    }
    
    public CommuterTripBuilder setStatus(TripStatus status) {
      this.status = status;
      return this;
    }
    
    public CommuterTrip build() {
      return new CommuterTrip(started, finished, durationSeconds, fromStop, toStop, chargeAmount, companyId, vehicleId, pan, status);
    }
  }
}
