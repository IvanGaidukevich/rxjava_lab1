import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------");

        for (int cs: new int[]{5000, 50000, 250000}){
           List<Message> messages = MessageGenerator.generateList(cs);
           System.out.println("Размер коллекции: " + messages.size());

           Instant start = Instant.now();
           double avgIteration = avgMessageLengthIteration(messages);
           Instant end = Instant.now();
           System.out.println("Итерационно: " + avgIteration + " (" + Duration.between(start, end).toNanos() + " ns)");

//           Message mess = maxMessageIteration(messages);
//           System.out.println(mess.getText());
//           System.out.println(mess.getText().length());

           start = Instant.now();
           double avgStream = avgMessageLengthStream(messages);
           end = Instant.now();
           System.out.println("Stream API (Collector): " + avgStream + " (" + Duration.between(start, end).toNanos() + " ns)");

//           start = Instant.now();
//           double avgCustom = avgLengthMessageCustom(messages);
//           end = Instant.now();
//           System.out.println("Stream API (Custom Collector): " + avgCustom + " (" + Duration.between(start, end).toMillis() + "ms)");
//
//           System.out.println("------------------------------------------------");


       }

    }

    private static double avgMessageLengthIteration(List<Message> messages) {
        long sum = 0;
        for (Message m : messages) {
            sum += m.getText().length();
        }
        return (double) sum / messages.size();
    }

    private static Message maxMessageIteration(List<Message> messages){
        Message localMax = messages.getFirst();
        for (Message m: messages) {
            if (m.getText().length() > localMax.getText().length()){
                localMax = m;
            }
        }
        return localMax;
    }

    private static double avgMessageLengthStream(List<Message> messages) {

//        List<Message> messagesFiltred = messages.stream().filter(m -> m.getSender().getName().length() == 3).toList();
//        System.out.println(messagesFiltred);


        return messages.stream()
                .collect(Collectors.averagingInt(m -> m.getText().length()));
    }

//
//    private static double avgLengthMessageCustom(List<Message> messages) {
//        Collector<Message, long[], Double> avgCollector = Collector.of(
//                () -> new long[2], // [0] = сумма длин, [1] = количество
//                (a, m) -> { a[0] += m.getText().length(); a[1]++; },
//                (a1, a2) -> { a1[0] += a2[0]; a1[1] += a2[1]; return a1; },
//                a -> (double) a[0] / a[1]
//        );
//
//        return messages.parallelStream().collect(avgCollector);
//    }
}
