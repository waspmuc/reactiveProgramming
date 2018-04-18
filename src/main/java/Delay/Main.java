package Delay;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<String> obs = Observable.fromArray("Ei", "Zweitausend", "Dreiehn");
        obs.delay(2000, TimeUnit.MILLISECONDS).blockingSubscribe(s -> System.out.println("Out: " + s));
        //obs.flatMap(s -> obs.delay(s.length(), TimeUnit.MILLISECONDS).blockingSubscribe(e -> System.out.println("Out: " + e)));

    }
}
