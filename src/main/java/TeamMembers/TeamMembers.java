package TeamMembers;

public class TeamMembers {
    protected String id;
    protected String lastName;
    protected String firstName;

    // constructors
    protected TeamMembers() {
    }

    protected TeamMembers(String id, String lastName, String firstName) {
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
