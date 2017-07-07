package subject;

import observer.Observer;
import person.Person;

/**
 * Created by HawkEye on 30/06/2017.
 */
public interface Collection {
    //methods to register and unregister observers
    public void register(Observer obj);
    public void unregister(Observer obj);

    //method to notify observers of change
    public void publish();

    //add or remove people
    public void add(Person person);
    public void removeMax();

}
