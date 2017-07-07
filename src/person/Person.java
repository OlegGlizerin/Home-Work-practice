package person;

import java.util.Date;

/**
 * Created by HawkEye on 30/06/2017.
 */
public interface Person extends Comparable<Person> {



    public int getId();
    public String getFirstName();
    public String getLastName();
    public Date getDateOfBirth();
    public int getHeight();

}