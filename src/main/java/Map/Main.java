package Map;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<String> obs = Observable.fromArray("Erster", "Zweiter", "Dritter");

        obs.map(s -> s.concat(String.valueOf(": " + s.length()))).subscribe(System.out::println);


    }
}
