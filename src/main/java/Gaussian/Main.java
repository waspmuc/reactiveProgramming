package Gaussian;


import io.reactivex.Observable;
import io.reactivex.functions.Function;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static io.reactivex.Observable.just;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        Function<List<Double>, Double> averageFunction = l -> l.stream().collect(Collectors.averagingDouble(x -> x));

        Observable
                .defer(() -> just(random.nextGaussian()))
                .repeat(10_000)
                .buffer(500, 1)
                .map(averageFunction).subscribe(System.out::println);
    }
}
