package project_java.project.dto;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class PerformanceRequest {

    @NotBlank(message = "Name of performance cannot be empty")
    private String name;
    @NotNull
    @Min(1)
    private double ticketPrice;
//    @Future
//    private Date date;
//    @NotNull
//    private Time startHour;
//    @NotNull
//    private Time endHour;

    private String start;

    private String end;

    @NotNull
    private int categoryId;

    public PerformanceRequest(){ }
    public PerformanceRequest(String name, double ticketPrice, String start, String end, int categoryId) {
        this.name = name;
        this.ticketPrice = ticketPrice;
        this.start = start;
        this.end = end;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Time getStartHour() {
//        return startHour;
//    }
//
//    public void setStartHour(Time startHour) {
//        this.startHour = startHour;
//    }
//
//    public Time getEndHour() {
//        return endHour;
//    }
//
//    public void setEndHour(Time endHour) {
//        this.endHour = endHour;
//    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}
