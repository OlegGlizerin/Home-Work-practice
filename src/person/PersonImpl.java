package person;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by HawkEye on 30/06/2017.
 */
public class PersonImpl implements Person, Comparable<Person>{
    private String firstName;
    private String lastName;
    private int id;
    private Date dateOfBirth;
    private int height;

    public PersonImpl(String firstName, String lastName, int id, Date dateOfBirth, int height) throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public int compareTo(Person o) {
        return id - o.getId();
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + id + ", " + dateOfBirth.toString() + ", " + height;
    }
}
