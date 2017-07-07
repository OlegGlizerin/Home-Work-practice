import observer.Observer;
import observer.PersonObserver;
import person.Person;
import person.PersonImpl;
import strategys.FirstNameStrategy;
import subject.PersonCollection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HawkEye on 30/06/2017.
 */

/**
 * Home Work dd
 *
 * Observer(Publisher subscriber) pattern used to create the Exercise
 * Data structure that I have used is SortedLinkedList, add O(n), removeMax O(1)
 * I could use MaxHeap here also but linked list is more likeit :)
 * Strategy pattern used to choose algorithm to remove the maximum persons value (Date, FirstName and Height)
 * Used synchronized and mutex on add/remove/publish/register/unregister to make it thread safe
 * Strategy's that I have implemented are Date and Height (there is possible to implement some more)
 * I have tried to use Generics and keep the code as generic as I can for the exercise
 *
 *
 *
 * In the main you can see some demonstration of the code usage, which is registering an observer -
 * than adds a person, registers 2 more observers and adds 2 more persons, then deletes 3 persons, trying
 * to remove the 4th person and notifies the message that it can't be done.
 *
 * All starts from the Initializing of PersonCollection by giving it the sort strategy we are choosing.
 * after that create 3 observers
 * and than create the dates for the 3 persons.
 *
 * and finally Register/Add/Removing the observers and persons.
 */
public class Run {
    public static void main(String[] args) throws ParseException {
        //create subject
        PersonCollection personCollection = new PersonCollection(new FirstNameStrategy());


        //create observers
        Observer mark = new PersonObserver("Mark Zukerberg");
        Observer bill = new PersonObserver("Bill Gates");
        Observer jessica = new PersonObserver("Jessica Alba");

        //create 3 Persons
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date dateOfBirthOleg = dateFormat.parse("1989/11/21");
        Date dateOfBirthMoti = dateFormat.parse("1979/02/13");
        Date dateOfBirthOrna = dateFormat.parse("1992/07/05");

        Person oleg = new PersonImpl("A", "Glizerin", 111, dateOfBirthOleg, 174);
        Person moti = new PersonImpl("C", "Gabai", 112, dateOfBirthMoti, 189);
        Person orna = new PersonImpl("B", "Tal", 113, dateOfBirthOrna, 165);

        //register 1 observer to the subject
        personCollection.register(mark);
        //adds 1 person to the LinkedList
        personCollection.add(oleg);

        //register the others
        personCollection.register(bill);
        personCollection.register(jessica);
        //adds 2 more to the LinkedList
        personCollection.add(moti);
        personCollection.add(orna);

        //removes 1 person from the LinkedList
        personCollection.removeMax();

        personCollection.removeMax();
        personCollection.removeMax();

        personCollection.removeMax();



    }
}
