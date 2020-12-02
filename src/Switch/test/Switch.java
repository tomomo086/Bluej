package Switch.test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

public class Switch {

	public static void main(String[] args) throws  InterruptedException{

		//GpioControllerインスタンスを作成
		final GpioController gpio = GpioFactory.getInstance();

		//７番ピンを入力ピンとする
		//final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07);

		//７番ピンを入力ピンとし、プルダウン抵抗を有効にする
		final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07,PinPullResistance.PULL_DOWN);

		System.out.println("Starting");

		while(true) {

			//ピンの状態を読み取りコンソールに表示する
			System.out.println("Pin State : " + pin.getState());

			Thread.sleep(1000);
		}
	}
}
