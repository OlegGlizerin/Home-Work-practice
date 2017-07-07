package subject;

import linkedListMax.LinkedListMax;
import linkedListMax.Strategy;
import observer.Observer;
import person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HawkEye on 30/06/2017.
 */
public class PersonCollection implements Collection {
    private List<Observer> observers;
    private LinkedListMax<Person> persons;
    private boolean changed;
    private String message;
    private final Object MUTEX = new Object();

    public PersonCollection(Strategy strategy) {
        this.observers = new ArrayList<Observer>();
        this.persons = new LinkedListMax<Person>();
        this.persons.setStrategy(strategy);
    }


    public void register(Observer observer) {
        if(observer == null) {
            throw new NullPointerException("Null Observers - there are no observers");
        }
        synchronized (MUTEX) {
            if(!observers.contains(observer)) {
                observers.add(observer);
                System.out.println("Registered " + observer.getName());
            }
        }
    }

    public void unregister(Observer observer) {
        synchronized (MUTEX) {
            observers.remove(observer);
            System.out.println("UNRegistered " + observer.getName());
        }
    }

    public void publish() {
        System.out.println("Publishing ...");
        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<Observer>(this.observers);
            this.changed = false;

            for (Observer obj : observersLocal) {
                obj.update(this.message);
            }
        }

    }

    public void add(Person person) {
        if(persons == null)
            throw new NullPointerException("Null Persons - there are no persons.");
        synchronized (MUTEX) {
            if(!persons.contains(person)){
                persons.addAndKeepSorted(person);
                this.message="Person ADDED - " + person.getFirstName() + " " + person.getLastName();
                this.changed = true;
                publish();
            }
        }
    }

    public void removeMax() {
        synchronized (MUTEX) {
            if(persons.size() > 0) {
                Person person = persons.removeLast();
                this.message = "Person REMOVED - " + person.getFirstName() + " " + person.getLastName();
                this.changed = true;
                publish();
            }
            else {
                this.message = "The linked list is empty - nothing will be done.";
                this.changed = true;
                publish();
            }
        }
    }


}
