package Join;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<Long> right = Observable.interval(250, TimeUnit.MILLISECONDS);
        Observable<Character> left = Observable.fromArray('a', 'b', 'c', 'd', 'e').zipWith(right, (x, y) -> x);

        final Observable<Object> joined = left
                .join(right, e -> Observable.empty().delay(1000, TimeUnit.MILLISECONDS),
                        s -> Observable.empty().delay(5, TimeUnit.MILLISECONDS),
                        (x, y) -> x + " -> " + y);
        joined.blockingSubscribe(System.out::println);

    }
}
