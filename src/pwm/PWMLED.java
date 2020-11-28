package pwm;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;

public class PWMLED {

	public static void main(String[] args) throws InterruptedException{

		//パルス幅の配列
		int[] ind = new int[] {0, 10, 30, 50, 70, 100, 200, 400, 700, 1024};

		//GpioControllerインスタンスを作成
		final GpioController gpio = GpioFactory.getInstance();

		//1番ピンをPWM信号出力ピンとする
		final GpioPinPwmOutput pin = gpio.provisionPwmOutputPin(RaspiPin.GPIO_01);

		System.out.println("Strating:");

		while(true) {

			//LEDを徐々に明るくするループ
			for(int i = 0; i < 10; i++) {
				//パルス幅のデータを読み込み、PWM信号を出力
				pin.setPwm(ind[i]);
				Thread.sleep(500);
			}

			Thread.sleep(1000);

			//LEDを徐々に暗くするループ
			for(int i = 9; i >= 0; i--) {
				//パルス幅のデータを読み込み、PWM信号を出力
				pin.setPwm(ind[i]);
				Thread.sleep(500);
			}

			Thread.sleep(1000);
		}
	}

}
