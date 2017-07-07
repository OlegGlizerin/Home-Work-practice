package observer;

import subject.Collection;

/**
 * Created by HawkEye on 30/06/2017.
 */
public class PersonObserver implements Observer {
    private String message;
    private String name;
    private Collection personCollection;

    public PersonObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        this.message = message;
        printMessage();
    }

    public void printMessage() {
        System.out.println("Observer Name:" + name + ", MESSAGE: " + message);
    }

    public void setCollection(Collection collection) {
        this.personCollection = collection;
    }

    public String getName() {
        return name;
    }
}
