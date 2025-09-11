import java.time.LocalDateTime;
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

    public Message(long id, String text, LocalDateTime timestamp, MessageStatus status, Attachment attachment, User sender, Chat room, List<LocalDateTime> editHistory) {
        this.id = id;
        this.text = text;
        this.timestamp = timestamp;
        this.status = status;
        this.attachment = attachment;
        this.sender = sender;
        this.room = room;
        this.editHistory = editHistory;
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
}
