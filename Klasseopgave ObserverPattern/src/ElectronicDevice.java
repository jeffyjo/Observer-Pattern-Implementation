import java.util.ArrayList;

/**
 * Created by dennis on 2/15/16.
 */
public class ElectronicDevice implements SimpleObservable
{
    ArrayList<SimpleObserver> observers = new ArrayList<SimpleObserver>();
    private String state = "";

    public String getState()
    {
        return state;
    }

    @Override
    public void registerObserver(SimpleObserver obj)
    {
        observers.add(obj);
    }

    @Override
    public void removeObserver(SimpleObserver obj)
    {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers()
    {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).update(this);
        }
    }

    public void setState(String state){
        this.state = state;
        notifyObservers();
    }
}
