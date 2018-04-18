package MyObservable;

import io.reactivex.Observable;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.currentThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new MyNewObservable.MyObservable().subscribe(new MyObserver());

        io.reactivex.Observable<String> first = Observable.create(emitter ->
        {
            emitter.onNext("Hello World " + new Date());
            emitter.onComplete();
            emitter.onNext("Test"); //Won't be executed
        });

        System.out.println("Start: " + new Date());

        CompletableFuture<String> future = new CompletableFuture<>().supplyAsync(() -> "Hello World from Future: " + new Date());
        System.out.println("Get: " + new Date());
        future.thenAccept(System.out::println);

        Thread.sleep(2_000L);
        System.out.println("Get: " + new Date());
        future.thenAccept(System.out::println);

        Thread.sleep(2_000L);
        System.out.println("Subscribe: " + new Date());
        first.subscribe(System.out::println);

        Thread.sleep(2_000L);
        System.out.println("Subscribe again: " + new Date());
        first.subscribe(System.out::println);

        first.subscribe(
                s -> System.out.println("Wert: " + s +
                        ", (called from " + currentThread().getName() + ")"));
        System.out.println("done (" + currentThread().getName() + ")");
    }
}
