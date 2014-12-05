package edu.npu.swing;

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
public class LennaImagePanel extends JPanel {
	private static final long serialVersionUID = 4961833016555742806L;
	private BufferedImage lenna;

	public LennaImagePanel() {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(
					"http://www.lenna.org/full/len_full.jpg").openConnection();
			connection.setRequestMethod("GET");
			lenna = ImageIO.read(connection.getInputStream());
			connection.disconnect();

			setSize(lenna.getWidth(), lenna.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(lenna, 0, 0, null);
	}

}