package strategys;

import linkedListMax.Strategy;
import person.Person;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by HawkEye on 01/07/2017.
 */
public class DateStrategy implements Strategy<Person>, Comparator<Date> {
    public int compare(Date o1, Date o2) {
        return o1.compareTo(o2);
    }

    public int compareStrategy(Person o1, Person o2) {
        if(o1 == null && o2 == null) {
            throw new NullPointerException("Both persons are null please fix.");
        }
        if(o2 == null) {
            return 1;
        }
        return compare(o1.getDateOfBirth(), o2.getDateOfBirth());
    }
}
