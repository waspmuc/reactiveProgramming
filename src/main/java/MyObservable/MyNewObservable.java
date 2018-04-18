package MyObservable;

import io.reactivex.ObservableSource;

public class MyNewObservable {

    public static class MyObservable implements ObservableSource<String> {

        /**
         * Subscribes the given Observer to this ObservableSource instance.
         *
         * @param observer the Observer, not null
         * @throws NullPointerException if {@code observer} is null
         */
        @Override
        public void subscribe(io.reactivex.Observer observer) {

            observer.onNext("eins");
            observer.onNext("zwei");
            observer.onComplete();

        }

    }


}
