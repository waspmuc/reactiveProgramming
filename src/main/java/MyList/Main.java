package MyList;

import io.reactivex.Observable;

/**
 * Created by mkirsch on 17.04.18.
 */
public class Main {

    public static void main(String[] args) {

        ReactiveList myReactiveList = new ReactiveList();

        Observable<String> addObservable = myReactiveList.getAddObservable();
        Observable<String> removeObservable = myReactiveList.getRemoveObservable();
        Observable<String> updateObservable = myReactiveList.getUpdateObservable();


        myReactiveList.add("Peter");
        myReactiveList.add("Chris");
        myReactiveList.add("Bernd");
        myReactiveList.add("Saskia");
        myReactiveList.add("Sabrina");
        myReactiveList.add("Yvonne");
        System.out.println("Content is: " + myReactiveList.getContent());


        removeObservable.subscribe(System.out::println);
        updateObservable.subscribe(System.out::println);

        final Observable<String> newObservable = addObservable.doOnNext(s -> System.out.println("Do on next: " + s));

        newObservable.subscribe(System.out::println);

        myReactiveList.remove("Peter");
        System.out.println("Content is: " + myReactiveList.getContent());
        myReactiveList.update("Bernd", "Pernd");
        System.out.println("Content is: " + myReactiveList.getContent());


    }
}
