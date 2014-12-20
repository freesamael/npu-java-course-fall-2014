package tw.edu.npu.mis.lenna;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Callable to load Lenna from Internet and convert it to a bitmap.
 * 
 * @author samael_wang
 *
 */
public class LoadLennaCallable implements Callable<Bitmap> {

	@Override
	public Bitmap call() throws Exception {
		Bitmap lenna = null;
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) new URL(
					"http://www.lenna.org/full/len_full.jpg").openConnection();
			connection.setRequestMethod("GET");

			// Load image from the returned stream.
			lenna = BitmapFactory.decodeStream(connection.getInputStream());
		} finally {
			if (connection != null)
				connection.disconnect();
		}

		return lenna;
	}

}
