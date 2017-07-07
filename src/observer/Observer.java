package observer;

import subject.Collection;

/**
 * Created by HawkEye on 30/06/2017.
 */
public interface Observer {

    //method to update the observer, used by subject
    public void update(String message);
    public void setCollection(Collection collection);
    public String getName();

}
