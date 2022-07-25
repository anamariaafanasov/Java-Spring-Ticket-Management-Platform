package project_java.project.dto;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SeatRequest {

    @NotNull
    @Min(1)
    @Max(30)
    private int rowNumber;
    @NotNull
    private char rowLetter;
    @NotNull
    private int roomId;
    @NotNull
    private int performanceId;

    private boolean booked = false;

    public SeatRequest(){}

    public SeatRequest(int rowNumber, char rowLetter, int roomId, int performanceId, boolean booked) {
        this.rowNumber = rowNumber;
        this.rowLetter = rowLetter;
        this.roomId = roomId;
        this.performanceId = performanceId;
        this.booked = booked;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public char getRowLetter() {
        return rowLetter;
    }

    public void setRowLetter(char rowLetter) {
        this.rowLetter = rowLetter;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }
}
