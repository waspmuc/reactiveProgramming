package GroupBy;


import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<String> obs = Observable.fromArray("Arne", "BBeertaa", "CCChris");
        //obs.groupBy(g -> g.length()).flatMap(s -> s).subscribe(System.out::println);
        obs.groupBy(g -> g.length()).subscribe(s -> s.subscribe(o -> System.out.println("Key " + s.getKey() + ": " + o)));

    }
}
