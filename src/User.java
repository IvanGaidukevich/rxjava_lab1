public class User {

    private static long counter = 0;
    private final long id;
    private final String name;

    public User(String name) {
        this.id = nextId();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private static long nextId() {
        return ++counter;
    }
}
