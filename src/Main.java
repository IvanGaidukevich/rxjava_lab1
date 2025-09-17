import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------");

        for (int cs : new int[]{5000, 50000, 250000}) {
            List<Message> messages = MessageGenerator.generateList(cs);
            System.out.println("Размер коллекции: " + messages.size());

            Instant start = Instant.now();
            double avgIteration = avgMessageLengthIteration(messages);
            Instant end = Instant.now();
            System.out.println("Итерационно: " + avgIteration + " (" + Duration.between(start, end).toNanos() + " ns)");


            start = Instant.now();
            double avgStream = avgMessageLengthStream(messages);
            end = Instant.now();
            System.out.println("Stream API (Collector): " + avgStream + " (" + Duration.between(start, end).toNanos() + " ns)");

            start = Instant.now();
            double avgCustom = avgLengthMessageCustom(messages);
            end = Instant.now();
            System.out.println("Stream API (Custom Collector): " + avgCustom + " (" + Duration.between(start, end).toNanos() + "ns)");

            System.out.println("------------------------------------------------");

        }

    }

    private static double avgMessageLengthIteration(List<Message> messages) {
        long sum = 0;
        for (Message m : messages) {
            sum += m.getText().length();
        }
        return (double) sum / messages.size();
    }

    private static double avgMessageLengthStream(List<Message> messages) {
        return messages.stream()
                .collect(Collectors.averagingInt(m -> m.getText().length()));
    }

    private static double avgLengthMessageCustom(List<Message> messages) {
        return messages.stream().collect(new CustomCollector());
    }
}

