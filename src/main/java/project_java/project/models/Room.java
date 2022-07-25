package project_java.project.models;

public class Room {

    private int id;
    //@NotBlank(message = "The name field cannot be empty")
    private String name;

    public Room(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
