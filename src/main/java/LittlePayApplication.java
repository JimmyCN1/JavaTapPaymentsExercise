import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class LittlePayApplication {
  public static void main(String[] args) throws IOException, CsvValidationException {
    TapEventsProcessingJob tapEventsProcessingJob = new TapEventsProcessingJob();
    tapEventsProcessingJob.start();
    
    System.exit(0);
  }
}
