package Just;


import io.reactivex.Observable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mkirsch on 16.04.18.
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        String[] names = {"Peter, Chris"};
        ArrayList moreNames = new ArrayList();
        moreNames.add("Michael");
        moreNames.add("Thomas");
        Observable<String> obs = Observable.fromArray(names);
        Observable<String> obsList = Observable.fromIterable(moreNames);

        Observable<Integer> obsInteger = Observable.range(7, 3);

        obs.subscribe(System.out::println);
        obsList.subscribe(System.out::println);
        obsInteger.subscribe(System.out::println);

    }
}
