package teams;

public class Car {
    private String id;
    private String name;
    private String constructorId;
    private String tyres;

    // constructeurs
    public Car() {}

    public Car(String id, String name, String constructorId,  String tyres) {
        this.id = id;
        this.name = name;
        this.constructorId = constructorId;
        this.tyres = tyres;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getConstructorId() {
        return constructorId;
    }
}
