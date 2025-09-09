import java.time.LocalDateTime;

public class Message {
    private static long counter = 1;

    private long id;
    private String sender;
    private String text;
    private LocalDateTime date;


    public Message(String sender, String text) {
        this.id = counter;
        this.sender = sender;
        this.text = text;
        this.date = LocalDateTime.now();
        counter++;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
