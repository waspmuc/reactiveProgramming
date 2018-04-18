package SubscribeOnVisualized;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {


        Observable.range(1, 200)
                .flatMap(elem -> Observable.just(elem))
                .observeOn(Schedulers.computation())
                .map(inner -> {

                    return inner;
                }).blockingSubscribe(s -> System.out.println(s));

    }
}
