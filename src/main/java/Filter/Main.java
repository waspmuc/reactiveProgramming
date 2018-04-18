package Filter;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<String> obs = Observable.just("Banane", "Kirsche", "Apfel", "Kiwi");

        obs.filter(s -> s.contains("a"))
                .filter(e -> e.contains("A"))
                .filter(e -> e.length() > 2).subscribe(System.out::println);
    }
}
