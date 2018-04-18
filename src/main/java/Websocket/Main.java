package Websocket;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {


        Observable<String> observable = Observable.fromArray("test", "test2");
    }
}
