package MergeTwoStreams;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {


        Observable<String> obs1 = Observable.fromArray("Peter", "Michael");
        Observable<String> obs2 = Observable.fromArray("Heike", "Tina");

        System.out.println("MERGE");
        obs1.mergeWith(obs2).subscribe(e -> System.out.println("Element: " + e));


        System.out.println("SWITCH IF EMPTY");
        obs1.switchIfEmpty(obs2).subscribe(e -> System.out.println("Element: " + e));

    }
}
