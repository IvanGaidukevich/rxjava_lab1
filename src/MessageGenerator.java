import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MessageGenerator {

    private static final String[] texts = {"Hello!", "How are u?", "Fine!", "And you?", "ASAP", "WTF!"};
    private static final List<User> users = UserGenerator.generateList(10);

    public static Message generate() {
        String message = texts[ThreadLocalRandom.current().nextInt(texts.length)];
        User user = users.get(ThreadLocalRandom.current().nextInt(users.size()));
        LocalDateTime timestamp = LocalDateTime.now();
        return new Message(Message.getCounter(), message, timestamp,);
    }

    public static List<Message> generateList(int amount){
        List<Message> messageList = new ArrayList<>();
        for (int i=0; i < amount; i++){
            messageList.add(generate());
        }
        return messageList;
    }

}
