package arrays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Clock extends JFrame {
	private JLabel display;
	private JPanel panel;

	public Clock() {
		buildGUI();

		new Thread() {
			public void run() {
				while (true) {
					Calendar c = new GregorianCalendar();

					int h = c.get(Calendar.HOUR);
					int m = c.get(Calendar.MINUTE);
					int s = c.get(Calendar.SECOND);
					int AM_PM = c.get(Calendar.AM_PM);
					String am_pm;

					if (AM_PM == 1) {
						am_pm = "PM";
					} else {
						am_pm = "AM";
					}

					display.setText(h + ":" + m + ":" + s + " " + am_pm);
				}
			}
		}.start();
	}

	public void buildGUI() {
		display = new JLabel("");
		display.setFont(new Font("Monospaced", Font.BOLD, 48));
		display.setForeground(Color.WHITE);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.add(display);
		panel.add(new JLabel("2016 - Cristian Henrique"));

		this.getContentPane().add(BorderLayout.CENTER, panel);
		this.setResizable(false);
		this.setSize(350, 125);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Clock");
		this.setVisible(true);
	}

	public static void main (String[] args) {
		new Clock();
	}
}
