package com.jimmycn1.io;

import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.transformer.TouchEventTransformer;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Loader {
  public List<TapEvent> loadData() throws IOException, CsvValidationException {
    File file = new File("taps.csv");
    InputStream csvFile = new FileInputStream(file);
    
    List<TapEvent> tapEvents = new ArrayList<>();
    CSVReader csvReader = new CSVReader(new InputStreamReader(csvFile));
    csvReader.readNext(); // read header line
    
    String[] record;
    while ((record = csvReader.readNext()) != null) {
      TouchEventTransformer transformer = new TouchEventTransformer();
      tapEvents.add(transformer.from(record));
    }
    
    return tapEvents;
  }
}
