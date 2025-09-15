public class Chat {
    private static long counter = 0;
    private long id;

    public Chat() {
        this.id = nextId();
    }

    public long getId() {
        return id;
    }

    private static long nextId() {
        return ++counter;
    }
}
