package Slider_PWM;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

public class MyFrame_PWM extends JFrame implements ChangeListener {

	JSlider sld;

	public MyFrame_PWM() {
		setTitle("Test GUI PWMLED");

		//スライダーを作成
		sld = new JSlider(0, 60, 0); //(最小値、最大値、初期値)
		sld.setBounds(50, 65, 200, 30); //(座標 x, 座標 y, width(幅), height(高さ))
		sld.addChangeListener(this);

		Container con = this.getContentPane();
		con.setLayout(null);
		con.add(sld);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);

		System.out.println("Starting");
	}

	//スライダーが動いた時の動作を記述
	public void stateChanged(ChangeEvent e) {

		//Gpioを初期化
		Gpio.wiringPiSetup();

		//pinをソフトウェアPWM出力ピンとして初期化(ピン番号, 初期値, 周期)
		SoftPwm.softPwmCreate(1, 0, 100);

		//スライダーの値をPWM値として出力
		SoftPwm.softPwmWrite(1,sld.getValue()); //(ピン番号,周期)

	}
}
