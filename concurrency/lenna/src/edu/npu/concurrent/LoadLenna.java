package edu.npu.concurrent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Basic sample to load Lenna.
 */
public class LoadLenna {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		// Button to load Lenna on main thread.
		JButton loadLennaButton = new JButton("Load Lenna (main thread)");
		loadLennaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				JPanel lenna = new LennaImagePanel();
				dialog.add(lenna);
				dialog.setSize(400, 240);
				dialog.setVisible(true);
			}
		});

		// Button to load Lenna on a background thread.
		JButton threadedLoadLennaButton = new JButton(
				"Load Lenna (background thread)");
		threadedLoadLennaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				JPanel lenna = new ThreadedLennaImagePanel();
				dialog.add(lenna);
				dialog.setSize(400, 240);
				dialog.setVisible(true);
			}
		});

		// Setup UI.
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.add(loadLennaButton);
		frame.add(threadedLoadLennaButton);
		frame.setSize(240, 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
