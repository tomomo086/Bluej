package Switch.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

public class MyFrame extends JFrame {

	//GpioControllerインスタンスを作成
	final GpioController gpio = GpioFactory.getInstance();

	//7番ピンを入力ピンとする
	//final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07);

	//7番ピンを入力ピンとしプルダウン抵抗を有効にする
	final GpioPinDigitalInput pin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07,PinPullResistance.PULL_DOWN);


	//Colorクラスのインスタンスを作成し、初期状態を青にする
	Color sw_color = new Color(0,0,255);


	public MyFrame() {

		setTitle("Test GUI Switch");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);

		class TimerListener implements ActionListener {
			public void actionPerformed(ActionEvent ae ) {

				//ピンの状態を判定
				if(pin.isHigh()) {
					//色を赤にする
					sw_color = Color.RED;
				} else {
					//色を青にする
					sw_color = Color.BLUE;
				}
				repaint();
			}
		}

		//タイマーを起動する
		Timer t = new Timer(100,new TimerListener());
		t.start();
	}


	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getSize().width, getSize().height);
		//色を設定
		g.setColor(sw_color);
		//丸を描画
		g.fillOval(120, 120, 60, 60);
	}
}
