package project_java.project.models;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

public class Performance {

    private int id;
    private String name;
    private double ticketPrice;
    private Date start;
    private Date end;
    private int categoryId;

    public Performance(){ }
    public Performance(int id, String name, double ticketPrice,  Date start, Date end,  int categoryId) {
        this.id = id;
        this.name = name;
        this.ticketPrice = ticketPrice;
        this.start = start;
        this.end = end;
        this.categoryId = categoryId;
    }

    public Performance(String name, double ticketPrice,  Date start, Date end, int categoryId) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
