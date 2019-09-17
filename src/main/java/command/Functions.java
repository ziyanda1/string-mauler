package command;

public enum Functions {
    NEW("Creates a new string to maul", "N"),
    APPEND("Appends a string to the current string", "A"),
    PREPEND("Prepends a string to the current string", "P"),
    REVERSE("Reverses the string", "R"),
    QUIT("Quits the app", "Q");

    private String id;
    private String description;

    Functions(String description, String id){
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
