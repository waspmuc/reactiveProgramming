package firstXXX;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        Observable<String> obs = Observable.just("Peter", "Chris", "Paul");
        Observable<String> obsEmpty = Observable.empty();

        final Single<String> first = obs.first("<default>");
        first.subscribe(s -> System.out.println("FIRST: " + s));


        final Maybe<String> maybe = obsEmpty.firstElement();
        maybe.subscribe(
                s -> System.out.println("MAYBE: " + s),
                error -> System.out.println("OnError: " + error),
                () -> System.out.println("OnComplete"));

        //Normalerweise würde der Typ First sein, aber damit würde es keine OnComplete-Handler geben. Deswegen kann ich dann wieder toObservables konvertiren.
        final Observable<String> firstOrError = obsEmpty.firstOrError().toObservable();
        firstOrError.subscribe(
                s -> System.out.println("MAYBE: " + s),
                error -> System.out.println("OnError: " + error),
                () -> System.out.println("OnComplete"));


        //obs.subscribe(System.out::println);

    }
}
