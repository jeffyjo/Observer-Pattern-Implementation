/**
 * Created by dennis on 2/15/16.
 */
public class PowerUsage implements SimpleObserver
{
    public PowerUsage(SimpleObservable obj)
    {
        (obj).registerObserver(this);
    }

    @Override
    public void update(SimpleObservable obj)
    {
        if(((ElectronicDevice)obj).getState().equals("on"))
        {
            System.out.println("The power usage is normal");
        }
        else if(((ElectronicDevice)obj).getState().equals("hibernate"))
        {
            System.out.println("Power save mode");
        }
        else if(((ElectronicDevice)obj).getState().equals("off"))
        {
            System.out.println("No power usage");
        }
        else
        {
            System.out.println("I dont know what "+((ElectronicDevice)obj).getState()+" means. are you high or something?");
        }
    }
}
