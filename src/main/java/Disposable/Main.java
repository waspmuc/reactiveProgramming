package Disposable;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.io.IOException;

/**
 * Created by mkirsch on 16.04.18.
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Observable<String> obs = Observable.create(emitter -> {

                    new Thread(() -> {
                        try {
                            emitter.onNext("1");
                            Thread.sleep(500L);
                            emitter.onNext("2");
                            Thread.sleep(500L);
                            emitter.onNext("3");
                            Thread.sleep(500L);
                            emitter.onNext("4");
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
        );

        Disposable disposable = obs.subscribe(System.out::println);

        System.out.println("Scubscribe");
        Thread.sleep(1000L);
        System.out.println("Dispose this shizzle");

        disposable.dispose();
        Thread.sleep(1000L);
        if (disposable.isDisposed())
            System.out.println("Shizzle is disposed");

    }
}
