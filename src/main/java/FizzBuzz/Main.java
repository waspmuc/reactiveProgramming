package FizzBuzz;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<Integer> observable = Observable.range(1, 100);
        //observable.map(e -> e == 3 ? System.out.println("Fizz") : System.out.println(e)).subscribe(System.out::println);

        //Observable<String> fizzObserver = observable.filter(e -> (e % 3 == 0) ? "fizz" : "buzz");

//        obs.map(s -> s.concat(String.valueOf(": " + s.length()))).subscribe(System.out::println);

    }
}
