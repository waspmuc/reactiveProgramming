package ImpliciteScheduler;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {


        Observable<Integer> obs = Observable
                .merge(Observable.range(1, 10).map(v -> Observable.just(v)
                        .delay(100, TimeUnit.MILLISECONDS, Schedulers.single())));

        obs.blockingSubscribe(System.out::print);
    }
}
