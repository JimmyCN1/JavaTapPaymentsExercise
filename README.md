# Java Tap Payments Exercise

Should be pretty straight forward to set up locally and run the program.

### Steps

1. It's a gradle project, so you can first run/refresh gradle to download the few dependencies if IntelliJ hasn't done so already
2. Run the program by running `LittlePayApplication`, which will process the `taps.csv` file located in the project's root directory and generate a `trips.csv` file with the processed trips

### Assumptions

1. `taps.csv` only contains tap events from a single 24h day ie. batch process
2. Since it's only a single day's worth of trips, there are no trips that began on the previous day included in `taps.csv`
