import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector<Message, long[], Double > {
    @Override
    public Supplier<long[]> supplier() {
        return () -> new long[2];
    }

    @Override
    public BiConsumer<long[], Message> accumulator() {
        return (a, m) -> {
            a[0] += m.getText().length();
            a[1]++;
        };
    }

    @Override
    public BinaryOperator<long[]> combiner() {
        return (a1, a2) -> {
            a1[0] += a2[0];
            a1[1] += a2[1];
            return a1;
        };
    }

    @Override
    public Function<long[], Double> finisher() {
        return a -> a[1] == 0 ? 0.0 : (double)a[0] / a[1];
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
