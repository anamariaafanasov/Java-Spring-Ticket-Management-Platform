package project_java.project.models;

import javax.validation.constraints.NotNull;

public class Ticket {

    private int id;
    @NotNull
    private int customerId;
    @NotNull
    private int performanceId;


    public Ticket(){}

    public Ticket(int id, int customerId, int performanceId) {
        this.id = id;
        this.customerId = customerId;
        this.performanceId = performanceId;

    }
    public Ticket(int customerId, int performanceId) {
        this.customerId = customerId;
        this.performanceId = performanceId;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }


}
