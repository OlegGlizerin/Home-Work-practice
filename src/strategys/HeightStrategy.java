package strategys;

import linkedListMax.Strategy;
import person.Person;

import java.util.Comparator;

/**
 * Created by HawkEye on 01/07/2017.
 */
public class HeightStrategy implements Strategy<Person>, Comparator<Integer>{

    public int compare(Integer o1, Integer o2) {
        return o1.intValue() - o2.intValue();
    }

    public int compareStrategy(Person o1, Person o2) {
        if(o1 == null && o2 == null) {
            throw new NullPointerException("Both persons are null please fix.");
        }
        if(o2 == null) {
            return 1;
        }
        return compare(o1.getHeight(), o2.getHeight());
    }

}
