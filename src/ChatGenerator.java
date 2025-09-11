import java.util.concurrent.ThreadLocalRandom;

public class ChatGenerator {
    public static Chat generate() {
        Chat.counter++;
        return new Chat(Chat.counter);
    }
}
