package SharedStream;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mkirsch on 16.04.18.
 */
public class Main {

    public static void main(String[] args) {

        AtomicInteger instanceCount = new AtomicInteger();
        Observable<String> obs = Observable.create(emitter -> {

            new Thread(() -> {
                int instance = instanceCount.incrementAndGet();
                while (true) {
                    emitter.onNext(instance + ": " + new Date());
                    try {
                        Thread.sleep(Math.round(Math.random() * 2500));
                    } catch (Exception e) {

                    }
                }

            }).start();
        });

        ConnectableObservable<String> conobs = obs.publish();
        conobs.connect();
        Observable<String> observable = conobs;

        observable.subscribe(s -> System.out.println("a: " + s));
        observable.subscribe(s -> System.out.println("b: " + s));
        observable.subscribe(s -> System.out.println("c: " + s));

    }
}
