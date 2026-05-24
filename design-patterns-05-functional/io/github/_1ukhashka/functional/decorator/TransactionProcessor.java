package io.github._1ukhashka.functional.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

public class TransactionProcessor {

    private final Function<Double, Double> pipeline;

    @SafeVarargs
    public TransactionProcessor(Function<Double, Double>... steps) {
        this.pipeline = Stream.of(steps)
                .reduce(Function.identity(), Function::andThen);
    }

    public double process(double amount) {
        return pipeline.apply(amount);
    }
}
