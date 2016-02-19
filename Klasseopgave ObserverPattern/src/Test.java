import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;


/**
 * Created by jeffjorgensen on 15/02/2016.
 */
public class Test extends Application{
    Image warning = new Image(Test.class.getResourceAsStream("warning.jpg"), 200, 200, false, false);
    Random rgen = new Random();
    Pane pane = new Pane();
    Button b1 = new Button("set");
    TextField t1 = new TextField();
    WritableImage wi = new WritableImage(200, 200);
    PixelWriter pi = wi.getPixelWriter();
    ImageView iv = new ImageView(wi);
    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage window)
    {
        ElectronicDevice electronicDevice = new ElectronicDevice();
        DiodeLight diodeLight = new DiodeLight(electronicDevice);
        PowerUsage powerUsage = new PowerUsage(electronicDevice);

        setColor("off");
        pane.getChildren().addAll(b1, t1, iv);
        b1.setLayoutX(10);
        b1.setLayoutY(260);
        b1.setPrefWidth(50);
        b1.setOnAction(e ->
        {
            electronicDevice.setState(t1.getText());
            setColor(t1.getText());
        });
        t1.setLayoutX(70);
        t1.setLayoutY(260);
        t1.setPrefWidth(300);
        iv.setLayoutX(100);
        window.setScene(new Scene(pane, 400, 300));
        window.show();
    }

    public void setColor(String color)
    {
        double r = 0;
        double g = 0;
        if(color.equals("on"))
        {
            iv.setImage(wi);
            g = 1;
        }
        else if(color.equals("hibernate"))
        {
            iv.setImage(wi);
            r = 1;
        }
        else if(color.equals("off"))
        {
            iv.setImage(wi);
        }
        else
        {
            iv.setImage(warning);
            final Timeline time = new Timeline();
            time.setCycleCount(1);
            time.setAutoReverse(false);
            for(int i = 160; i < 250; i++)
            {
                if(i > 160)
                {
                    final KeyValue keyf = new KeyValue(iv.imageProperty(), new Image(Test.class.getResourceAsStream("nuke.jpg"), 200, 200, false, false));
                    final KeyValue keyY = new KeyValue(iv.translateYProperty(), iv.getTranslateY() + rgen.nextInt(20) - 10);
                    final KeyValue keyX = new KeyValue(iv.translateXProperty(), iv.getTranslateX() + rgen.nextInt(20) - 10);
                    final KeyFrame frame = new KeyFrame(Duration.millis(i * 30), keyX, keyY, keyf);
                    time.getKeyFrames().add(frame);
                }
            }
            final KeyValue keyY = new KeyValue(iv.translateYProperty(), 0);
            final KeyValue keyX = new KeyValue(iv.translateXProperty(), 0);
            final KeyFrame frame = new KeyFrame(Duration.millis(2010), keyX, keyY);
            time.getKeyFrames().add(frame);
            time.play();
        }
        double cDist = 0;
        double alpha = 0;
        for(int x = 0; x < 200; x++)
        {
            for(int y = 0; y < 200; y++)
            {
                cDist = Math.sqrt((x - 100) * (x - 100) + (y - 100) * (y - 100));
                if(cDist >= 50)
                {
                    alpha = 0;
                }
                else
                {
                    alpha = -0.02*cDist + 1;
                }
                pi.setColor(x, y, Color.color(r, g, 0, alpha));
            }
        }
    }
}
