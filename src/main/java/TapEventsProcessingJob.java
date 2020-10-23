import com.jimmycn1.domain.CommuterTrip;
import com.jimmycn1.domain.TapEvent;
import com.jimmycn1.io.Loader;
import com.jimmycn1.io.OutputGenerator;
import com.jimmycn1.manager.TapEventsManager;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TapEventsProcessingJob {
  private Loader loader;
  private OutputGenerator outputGenerator;
  
  public TapEventsProcessingJob() throws IOException {
    this.loader = new Loader();
    this.outputGenerator = new OutputGenerator();
  }
  
  public void start() throws IOException, CsvValidationException {
    List<TapEvent> tapEvents = loader.loadData();
    
    TapEventsManager tapEventsManager = new TapEventsManager(tapEvents);
    Map<String, List<CommuterTrip>> everyCommutersTripsForTheDayMap = tapEventsManager.generateTripsForTheDay();
    
    outputGenerator.generateOutputCsv(everyCommutersTripsForTheDayMap);
  }
}
