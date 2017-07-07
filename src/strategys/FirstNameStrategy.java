package strategys;

import linkedListMax.Strategy;
import person.Person;

import java.util.Comparator;

/**
 * Created by HawkEye on 02/07/2017.
 */
public class FirstNameStrategy implements Strategy<Person>, Comparator<String> {
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

    public int compareStrategy(Person o1, Person o2) {
        if(o1 == null && o2 == null) {
            throw new NullPointerException("Both persons are null please fix.");
        }
        if(o2 == null) {
            return 1;
        }
        return compare(o1.getFirstName(), o2.getFirstName());
    }
}
