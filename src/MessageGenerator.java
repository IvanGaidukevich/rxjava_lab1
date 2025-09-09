import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MessageGenerator {

    private static final String[] senders = {"Ivan", "Pavel", "Sergey", "Marina", "Olga", "Daria"};
    private static final String[] messages = {"Hello!", "How are u?", "Fine!", "And you?", "ASAP", "WTF!"};

    public static Message generate() {
        String sender = senders[ThreadLocalRandom.current().nextInt(senders.length)];
        String message = messages[ThreadLocalRandom.current().nextInt(messages.length)];;
        return new Message(sender, message);
    }

    public static List<Message> generateList(int amount){
        List<Message> messageList = new ArrayList<>();
        for (int i=0; i < amount; i++){
            messageList.add(generate());
        }
        return messageList;
    }

}
