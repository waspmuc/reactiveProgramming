package ObservablePlain;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 16.04.18.
 */
public class Main {

    static <T> Observable<T> observableJust(T x) {

        return Observable.create(emitter -> {
            emitter.onNext(x);
            emitter.onComplete();
        });
    }

    public static void main(String[] args) {


        Observable<Object> observableNever = Observable.create(emitter ->
        {

        });

        final Observable<String> stringObservable = observableJust(new String("TESH"));

        stringObservable.subscribe(System.out::println);

    }
}
