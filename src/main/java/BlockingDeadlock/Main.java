package BlockingDeadlock;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {
        Observable<String> obs = Observable.never();
        obs.blockingSubscribe(System.out::println);
    }
}
