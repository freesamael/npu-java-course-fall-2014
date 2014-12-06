package edu.npu.concurrent;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Simple JPanel which loads Lenna image on main thread.
 * 
 * @author samael_wang
 *
 */
public class ThreadedLennaImagePanel extends JPanel {
	private static final long serialVersionUID = -1872338908520680625L;
	private BufferedImage lenna;

	public ThreadedLennaImagePanel() {
		new LoadLennaThread().start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (lenna != null)
			g.drawImage(lenna, 0, 0, null);
	}

	private class LoadLennaThread extends Thread {

		@Override
		public void run() {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(
						"http://www.lenna.org/full/len_full.jpg")
						.openConnection();
				connection.setRequestMethod("GET");
				lenna = ImageIO.read(connection.getInputStream());
				connection.disconnect();

				setSize(lenna.getWidth(), lenna.getHeight());
				updateUI();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}