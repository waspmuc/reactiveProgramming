package MyList;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;

import java.util.ArrayList;

/**
 * Created by mkirsch on 17.04.18.
 */
public class ReactiveList {

    private ArrayList<String> internalList = new ArrayList<>();
    private ReplaySubject<String> addSubject = ReplaySubject.createWithSize(4);
    private BehaviorSubject<String> removeSubject = BehaviorSubject.create();
    private BehaviorSubject<String> updateSubject = BehaviorSubject.create();

    public void add(String item) {
        internalList.add(item);
        addSubject.onNext("ADDED " + item);

    }

    public void remove(String item) {
        removeSubject.onNext("REMOVED " + item);
        internalList.remove(item);
    }

    public void update(String item, String itemToReplace) {
        updateSubject.onNext("REPLACED " + item + " WITH " + itemToReplace);
        int index = -1;
        index = internalList.indexOf(item);
        if (index != -1)
            internalList.set(index, itemToReplace);
    }

    public ArrayList<String> getContent() {
        return internalList;
    }

    public Observable<String> getAddObservable() {
        return addSubject;
    }

    public Observable<String> getRemoveObservable() {
        return removeSubject;
    }

    public Observable<String> getUpdateObservable() {
        return updateSubject;
    }
}
