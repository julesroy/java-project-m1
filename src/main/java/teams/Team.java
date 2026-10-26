package teams;

public class Team {
    private String id;
    private String fullName;

    // constructors
    public Team() {}

    public Team(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
