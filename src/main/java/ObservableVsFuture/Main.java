package ObservableVsFuture;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by mkirsch on 16.04.18.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        System.out.println("Start at: " + new Date());

        Observable<String> first = Observable.create(emitter ->
        {
            emitter.onNext("Hello World " + new Date());
            Thread.sleep(2_000L);

            emitter.onNext("Hello again " + new Date());
            Thread.sleep(1_000L);

            emitter.onNext("Hello, it's you again " + new Date());
            Thread.sleep(1_000L);

        });

        Thread.sleep(100L);

        System.out.println("Subscribe to Obserserver");

        first.subscribe(s -> System.out.println(s));

        CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
            ArrayList<String> list = new ArrayList<>();

            try {
                list.add(new Date().toString());
                Thread.sleep(1000L);
                list.add(new Date().toString());
                Thread.sleep(1000L);
                list.add(new Date().toString());
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return list;
        });

        Thread.sleep(100L);
        System.out.println("Get: " + new Date());
        //System.out.println(future.get());
        future.thenAccept(
                l -> l.forEach(s -> System.out.println(s + ": " + new Date()))
        );

    }
}
