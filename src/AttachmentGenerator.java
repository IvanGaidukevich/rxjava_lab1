import java.util.concurrent.ThreadLocalRandom;

public class AttachmentGenerator {
    private static final String[] filenames = {"1.jpg", "2.png", "3.txt", "4.png", "5.txt", "6.jpg"};

    public static Attachment generate() {
        String name = filenames[ThreadLocalRandom.current().nextInt(filenames.length)];;
        return new Attachment(name);
    }
}
