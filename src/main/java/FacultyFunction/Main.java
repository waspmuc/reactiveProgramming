package FacultyFunction;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<Integer> observable = Observable
                .range(1, 10)
                .scan(1, (accumulator, current)
                        -> (accumulator * current));

        observable.subscribe(System.out::println);

    }
}
