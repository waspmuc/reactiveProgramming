package RetryWhen;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> observable = Observable.fromArray("test", "test2");

        Observable<String> login = Observable.just("User");

        AtomicInteger delayCount = new AtomicInteger(4);
        Observable<String> delay = Observable.defer(() -> Observable
                .<String>empty()
                .delay(delayCount.getAndDecrement(), TimeUnit.SECONDS));

        Observable<String> obs = Observable.concat(delay, login);

        obs.timeout(1, TimeUnit.SECONDS).doOnError(e -> System.out.println("error..." + e)).retryWhen(attempts -> {
            return Observable.zip(
                    attempts,
                    Observable.range(1, 3),
                    (n, i) -> i)
                    .flatMap(i -> {
                        System.out.println("delay retry: " + i + " second(s)");
                        return Observable.timer(i, TimeUnit.SECONDS);
                    });
        })
                .firstOrError()
                .onErrorReturnItem("Unknown")
                .subscribe(System.out::println, e -> System.out.println("Fehler: " + e));
        Thread.sleep(10_000);
    }
}
