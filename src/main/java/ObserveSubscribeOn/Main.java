package ObserveSubscribeOn;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {


        Observable<String> observable = Observable.fromCallable(() -> {
            System.out.println("Current thread is: " + Thread.currentThread().getName());
            return "ABC";
        }).observeOn(Schedulers.newThread());


        observable.subscribeOn(Schedulers.newThread()).subscribe((System.out::println));
        Thread.sleep(4000);
    }
}
