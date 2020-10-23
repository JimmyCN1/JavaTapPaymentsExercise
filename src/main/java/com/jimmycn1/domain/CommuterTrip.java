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
}
