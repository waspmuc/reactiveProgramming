package WithLatestFrom;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {


        Observable<String> fast = Observable
                .interval(10, TimeUnit.MILLISECONDS)
                .map(e -> "FAST/" + e)
                .delay(100, TimeUnit.MILLISECONDS)
                .startWith(Observable.just("DUMMY"));
        Observable<String> slow = Observable.interval(20, TimeUnit.MILLISECONDS).map(e -> "SLOW/" + e);

        slow.withLatestFrom(fast, (s, f) -> f + " : " + s).blockingSubscribe(System.out::println);
    }
}
