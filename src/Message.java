import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Message {
    private static long counter = 0;

    private long id;
    private String text;
    private LocalDateTime timestamp;
    private MessageStatus status;
    private Attachment attachment;
    private List<LocalDateTime> editHistory;
    private User sender;
    private Chat room;

    public Message(Chat room, User sender, String text, Attachment attachment) {
        this.id = nextId();
        this.timestamp = LocalDateTime.now();
        this.editHistory = new ArrayList<>();
        this.status = MessageStatus.SENT;
        this.text = text;
        this.attachment = attachment;
        this.sender = sender;
        this.room = room;
    }

    public static long getCounter() {
        return counter;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public User getSender() {
        return sender;
    }

    public Chat getRoom() {
        return room;
    }

    public List<LocalDateTime> getEditHistory() {
        return editHistory;
    }

    private static long nextId() {
        return ++counter;
    }
}
