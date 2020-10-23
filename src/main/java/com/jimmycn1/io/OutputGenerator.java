package com.jimmycn1.io;

import com.jimmycn1.domain.CommuterTrip;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OutputGenerator {
  private final static String[] headerRow
          = new String[]{"Started", "Finished", "DurationSecs", "FromStopId", "ToStopId", "ChargeAmount", "CompanyId", "BusId", "PAN", "Status"};
  private CSVWriter csvWriter;
  
  public OutputGenerator() throws IOException {
    this.csvWriter = new CSVWriter(new FileWriter("trips.csv"));
  }
  
  public void generateOutputCsv(Map<String, List<CommuterTrip>> everyCommutersTripsForTheDayMap) throws IOException {
      csvWriter = new CSVWriter(new FileWriter("trips.csv"));
      csvWriter.writeNext(headerRow); // write header row
      writeRows(everyCommutersTripsForTheDayMap);
      csvWriter.close();
  }
  
  private void writeRows(Map<String, List<CommuterTrip>> everyCommutersTripsForTheDayMap) {
    for (String pan : everyCommutersTripsForTheDayMap.keySet()) {
      List<CommuterTrip> trips = everyCommutersTripsForTheDayMap.get(pan);
      writeRow(trips);
    }
  }
  
  private void writeRow(List<CommuterTrip> trips) {
    for (CommuterTrip trip : trips) {
      csvWriter.writeNext(trip.tostringArray());
    }
  }
}
