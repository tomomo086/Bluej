package LED;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

//LEDを点滅させる
public class LED
{
   public static void main(String[] args) throws InterruptedException {

       //GipoContollerインスタンスを作成
       final GpioController gpio = GpioFactory.getInstance();

       //1番ピンを出力ピンとし初期状態でローレベルを出力する
       final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,PinState.LOW);

       System.out.println("Starting");

       while(true) {
    	   //500msecウェイト
    	   Thread.sleep(500);

    	   //1番ピンにハイレベルを出力
    	   pin.high();

    	 //500msecウェイト
    	   Thread.sleep(500);

    	   //1番ピンにローレベルを出力
    	   pin.low();
       }
    }
}