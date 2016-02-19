import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

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
            try
            {
                File f = new File(System.getProperty("user.dir")+"/lose.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                System.out.println("I dont know what " + ((ElectronicDevice) obj).getState() + " means. are you high or something? Im sorry i have to nuke you!");
                System.out.println("Get destroyed!");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
