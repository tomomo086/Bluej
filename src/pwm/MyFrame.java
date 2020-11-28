package pwm;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;

public class MyFrame extends JFrame implements ChangeListener {

	//GpioControllerインスタンスを作成
	final GpioController gpio = GpioFactory.getInstance();

	//1番ピンをPWM出力ピンとし、初期状態でローレベルを出力する
	final GpioPinPwmOutput pin = gpio.provisionPwmOutputPin(RaspiPin. GPIO_01, 0);


	JSlider sld;


	public MyFrame() {
		setTitle("Test GUI PWMLED");

		//スライダーを作成
		sld = new JSlider(0, 1024, 0);
		sld.setBounds(50, 65, 200, 30);
		sld.addChangeListener(this);

		Container con = this.getContentPane();
		con.setLayout(null);
		con.add(sld);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
	}

	//スライダーが動いた時の動作を記述
	public void stateChanged(ChangeEvent e) {

		//スライダーの値をPWM値として出力
		pin.setPwm(sld.getValue());
	}

}
