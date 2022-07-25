package project_java.project.dto;

import javax.validation.constraints.NotNull;

public class TicketRequest {

    @NotNull
    private int customerId;
    @NotNull
    private int performanceId;


    public TicketRequest(){}

    public TicketRequest(int customerId, int performanceId) {
        this.customerId = customerId;
        this.performanceId = performanceId;

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
