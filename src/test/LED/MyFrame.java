package test.LED;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.pi4j.io.gpio.RaspiPin;

public class MyFrame extends JFrame implements ActionListener {

	//LEDクラスのインスタンスを作成。引数でLEDを接続しているピンのGPIO番号を指定
	LED led = new LED( RaspiPin.GPIO_01);


	public MyFrame() {

		setTitle("TEST GUI LED");

		//ボタン生成
		JButton btn = new JButton();
		btn.setBounds(100, 65, 100, 30);
		btn.addActionListener(this);

		Container con = this.getContentPane();
		con.setLayout(null);
		con.add(btn);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);

	}

	//ボタンが押された時の動作を記述
	public void actionPerformed(ActionEvent e) {

		//LEDのピン出力を反転
		led.Toggle();
	}
}
