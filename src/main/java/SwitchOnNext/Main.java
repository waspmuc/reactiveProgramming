package SwitchOnNext;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static io.reactivex.Observable.concat;
import static io.reactivex.Observable.interval;
import static io.reactivex.Observable.just;
import static io.reactivex.Observable.switchOnNext;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<String> observable1 = interval(1, TimeUnit.SECONDS).map(s -> "a" + s);
        Observable<String> observable2 = interval(2, TimeUnit.SECONDS).map(s -> "b" + s);

        Observable<Observable<String>> listOfObservables =
                concat(just(observable1),
                        just(observable2)
                                .delay(3, TimeUnit.SECONDS));

        switchOnNext(listOfObservables).blockingSubscribe(System.out::println);
    }
}
