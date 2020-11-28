package test.LED;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;

public class LED {

	private GpioController gpio;
	private GpioPinDigitalOutput ledpin;


	//LEDのコンストラクタ
	public LED(Pin pin) {

		gpio = GpioFactory.getInstance();

		//指定されたピンを出力とし、初期出力値をローレベルに設定
		ledpin = gpio.provisionDigitalOutputPin(pin, PinState.LOW);
		//shutdownメソッド実行時のピンの状態を指定
		ledpin.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
	}


	//LED点灯
	public void on() {
		//LEDピンにハイレベルを出力
		ledpin.high();
	}


	//LED消灯
	public void off() {
		//LEDピンにローレベルを出力
		ledpin.low();
	}

	//LEDの出力を反転
	public void Toggle() {
		//LEDピンの出力を反転
		ledpin.toggle();
	}

	//LED点滅
	public void Blink(long millsec) {
		//LEDを点滅
		ledpin.blink(millsec);
	}

	public boolean isOn() {
		//LEDピンの出力状態をチェック
		return ledpin.isHigh();
	}

	//LEDピンを開放
	public void shtdwn() {
		//LEDピンを開放
		gpio.shutdown();
	}

}
