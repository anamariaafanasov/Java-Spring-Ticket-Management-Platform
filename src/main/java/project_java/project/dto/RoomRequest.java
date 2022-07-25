package project_java.project.dto;

import javax.validation.constraints.NotBlank;

public class RoomRequest {

    //@NotBlank(message = "The name field cannot be empty")
    private String name;

    public RoomRequest(){}

    public RoomRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
