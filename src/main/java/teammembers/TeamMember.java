package teammembers;

public class TeamMember {
    private String id;
    private String lastName;
    private String firstName;

    // constructors
    public TeamMember() {
    }

    public TeamMember(String id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
