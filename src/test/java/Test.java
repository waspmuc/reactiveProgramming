import MyList.ReactiveList;
import io.reactivex.observers.TestObserver;

/**
 * Created by mkirsch on 18.04.18.
 */
public class Test {


    @org.junit.Test
    public void test() {

        System.out.println("Test");

        ReactiveList myReactiveList = new ReactiveList();


        final TestObserver<String> test = myReactiveList.getAddObservable().test();

        myReactiveList.add("H");

        test.assertValue("ADDED H");

    }

}
