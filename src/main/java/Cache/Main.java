package Cache;

import io.reactivex.Observable;

import java.util.Date;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {

        Observable<Object> obs = Observable.create(emitter -> {
            emitter.onNext(new Date());
        }).cache();




        obs.subscribe(System.out::println);
        Thread.sleep(2000L);
        obs.subscribe(System.out::println);

    }


}
