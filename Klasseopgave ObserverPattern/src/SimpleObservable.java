/**
 * Created by jeffjorgensen on 15/02/2016.
 */
public interface SimpleObservable {

    //methods to register and unregister observers
    public void registerObserver(SimpleObserver obj);
    public void removeObserver(SimpleObserver obj);

    //method to notify observers of change
    public void notifyObservers();
}
