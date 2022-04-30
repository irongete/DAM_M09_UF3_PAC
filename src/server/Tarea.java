package server;

public class Tarea {
    //atributos
    private final String description;
    private final String state;

    //constructor
    public Tarea(String description, String state) {
        this.description = description;
        this.state = state;
    }

    //getters
    public String getDescription() {
        return description;
    }
    public String getState() {
        return state;
    }


}
