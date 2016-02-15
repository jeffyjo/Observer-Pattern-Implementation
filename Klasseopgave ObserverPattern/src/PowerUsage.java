/**
 * Created by dennis on 2/15/16.
 */
public class PowerUsage implements SimpleObserver
{
    public PowerUsage(SimpleObserver obj)
    {
        ((SimpleObservable) obj).registerObserver(this);
    }

    @Override
    public void update(SimpleObservable obj)
    {
        if(((ElectronicDevice)obj).getState().equals("on"))
        {
            System.out.println("The power usage is normal");
        }
        if(((ElectronicDevice)obj).getState().equals("hibernate"))
        {
            System.out.println("Power save mode");
        }
        if(((ElectronicDevice)obj).getState().equals("off"))
        {
            System.out.println("No power usage");
        }
    }
}
