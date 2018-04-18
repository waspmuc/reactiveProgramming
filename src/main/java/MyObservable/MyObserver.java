package MyObservable;

import io.reactivex.disposables.Disposable;

public class MyObserver implements io.reactivex.Observer {


    /**
     * Provides the Observer with the means of cancelling (disposing) the
     * connection (channel) with the Observable in both
     * synchronous (from within {@link #onNext(Object)}) and asynchronous manner.
     *
     * @param d the Disposable instance whose {@link Disposable#dispose()} can
     *          be called anytime to cancel the connection
     * @since 2.0
     */
    @Override
    public void onSubscribe(Disposable d) {

        System.out.println("onSubscribe");

    }

    /**
     * Provides the Observer with a new item to observe.
     * <p>
     * The {@link MyNewObservable} may call this method 0 or more times.
     * <p>
     * The {@code Observable} will not call this method again after it calls either {@link #onComplete} or
     * {@link #onError}.
     *
     * @param o the item emitted by the Observable
     */
    @Override
    public void onNext(Object o) {
        System.out.println("onNext: " + o);

    }

    /**
     * Notifies the Observer that the {@link MyNewObservable} has experienced an error condition.
     * <p>
     * If the {@link MyNewObservable} calls this method, it will not thereafter call {@link #onNext} or
     * {@link #onComplete}.
     *
     * @param e the exception encountered by the Observable
     */
    @Override
    public void onError(Throwable e) {
        System.out.println("onError");

    }

    /**
     * Notifies the Observer that the {@link MyNewObservable} has finished sending push-based notifications.
     * <p>
     * The {@link MyNewObservable} will not call this method if it calls {@link #onError}.
     */
    @Override
    public void onComplete() {
        System.out.println("onComplete");

    }
}
