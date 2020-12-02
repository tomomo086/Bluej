package Switch.test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class Switch_event {

	public static void main (String[] args) throws InterruptedException{

		//GpioControllerインスタンスの作成
		final GpioController gpio = GpioFactory.getInstance();

		//7番ピンを入力ピンとする
		final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07);

		//７番ピンを入力ピンとし、プルダウン抵抗を有効にする
		//final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07,PinPullResistance.PULL_DOWN);



		pin.addListener(new GpioPinListenerDigital() {

			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				//ピンの状態を読み取り、コンソールに出力する
				System.out.println("Pin State :" + event.getState());

			}
		});

		System.out.println("Starting");

		while(true) {
			Thread.sleep(1000);
		}

	}

}
