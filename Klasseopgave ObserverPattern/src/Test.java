/**
 * Created by jeffjorgensen on 15/02/2016.
 */
public class Test {
    public static void main(String[] args) {
        ElectronicDevice electronicDevice = new ElectronicDevice();
        DiodeLight diodeLight = new DiodeLight(electronicDevice);
        PowerUsage powerUsage = new PowerUsage(electronicDevice);

        electronicDevice.setState("on");
        electronicDevice.setState("off");
        electronicDevice.setState("hibernate");
        electronicDevice.setState("JOHN");
    }
}
