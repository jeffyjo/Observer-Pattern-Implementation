/**
 * Created by jeffjorgensen on 15/02/2016.
 */
public class DiodeLight implements SimpleObserver{

    public DiodeLight(SimpleObservable sob) {
        (sob).registerObserver(this);

    }

    @Override
    public void update(SimpleObservable obj) {
        if (((ElectronicDevice) obj).getState().equals("on")){
            System.out.println("The diode is now green");
        } else if (((ElectronicDevice) obj).getState().equals("hibernate")){
            System.out.println("The diode is now red");
        } else if (((ElectronicDevice) obj).getState().equals("off")){
            System.out.println("The diode is turned off");
        } else {
            System.out.println("What the F...");
        }
    }
}
