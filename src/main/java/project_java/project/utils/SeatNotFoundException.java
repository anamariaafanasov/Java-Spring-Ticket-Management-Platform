package project_java.project.utils;

public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(int performanceId, int rowNumber, String rowLetter) {
        super("Seat: " + rowNumber + rowLetter+  "at performance whit id" + performanceId + " not found.");
    }
}
