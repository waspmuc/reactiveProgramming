package FlatMap;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable obs = Observable.fromArray("Eins", "Zwei", "Drei");
        //obs.flatMap(element -> Observable.just(element + ",")).subscribe(System.out::println);
        //obs.doOnNext(s -> System.out.println("Whaaat?: " + s)).flatMap(element -> Observable.range(1, 5)).subscribe(System.out::println);

        Observable<Integer> obsInteger = Observable.range(1, 8);
        obsInteger.map(i -> String.valueOf(i + " "));

        Observable<String> column = obsInteger.map(i -> String.valueOf((char) ('a' + i - 1)));

        Observable<String> line = column.flatMap(s -> obsInteger.map(i -> s + i + " ").concatWith(Observable.just("\n")));
        line.subscribe(System.out::print);


    }
}
