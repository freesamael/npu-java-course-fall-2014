package tw.edu.npu.mis.lenna;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

/**
 * The main entry activity.
 * 
 * @author samael_wang
 *
 */
public class LennaActivity extends Activity {
	private static final String LOG_TAG = "LennaActivity";
	private ImageView mImageView;
	private ProgressDialog mProgressDialog;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lenna);

		mImageView = (ImageView) findViewById(R.id.img_lenna);
		loadLennaV1();
	}

	/**
	 * Load lenna and set bitmap on main thread.
	 */
	private void loadLennaV1() {
		Log.d(LOG_TAG, "Load Lenna V1");
		try {
			Bitmap lenna = new LoadLennaCallable().call();
			mImageView.setImageBitmap(lenna);
			Log.d(LOG_TAG, "Load Lenna V1 done.");
		} catch (Exception e) {
			Log.e(LOG_TAG, "Failed to load lenna.", e);
		}
	}

	/**
	 * Load lenna and set bitmap on a background thread.
	 */
	private void loadLennaV2() {
		Log.d(LOG_TAG, "Load Lenna V2");
		Thread loadLennaThread = new Thread() {

			@Override
			public void run() {
				try {
					Bitmap lenna = new LoadLennaCallable().call();
					mImageView.setImageBitmap(lenna);
					Log.d(LOG_TAG, "Load Lenna V2 done.");
				} catch (Exception e) {
					Log.e(LOG_TAG, "Failed to load lenna.", e);
				}
			}

		};
		loadLennaThread.start();
	}

	/**
	 * Load lenna on a background thread but set bitmap on the main thread.
	 */
	private void loadLennaV3() {
		Log.d(LOG_TAG, "Load Lenna V3");
		Thread loadLennaThread = new Thread() {

			@Override
			public void run() {
				try {
					Bitmap lenna = new LoadLennaCallable().call();
					runOnUiThread(new SetLennaBitmapRunnable(lenna));
				} catch (Exception e) {
					Log.e(LOG_TAG, "Failed to load lenna.", e);
				}
			}

		};
		loadLennaThread.start();
	}

	private class SetLennaBitmapRunnable implements Runnable {
		private Bitmap mmBitmap;

		public SetLennaBitmapRunnable(Bitmap bitmap) {
			mmBitmap = bitmap;
		}

		@Override
		public void run() {
			mImageView.setImageBitmap(mmBitmap);
			Log.d(LOG_TAG, "Load Lenna V3 done.");
		}

	}

	private void loadLennaV4() {
		Log.d(LOG_TAG, "Load Lenna V4");
		AsyncTask<Void, Void, Bitmap> loadLennaTask = new AsyncTask<Void, Void, Bitmap>() {

			@Override
			protected void onPreExecute() {
				mProgressDialog = ProgressDialog.show(LennaActivity.this, null,
						getString(R.string.please_wait));
			}

			@Override
			protected Bitmap doInBackground(Void... params) {
				try {
					return new LoadLennaCallable().call();
				} catch (Exception e) {
					Log.e(LOG_TAG, "Failed to load lenna.", e);
					return null;
				}
			}

			@Override
			protected void onPostExecute(Bitmap result) {
				mProgressDialog.dismiss();
				mImageView.setImageBitmap(result);
				Log.d(LOG_TAG, "Load Lenna V4 done.");
			}
		};

		loadLennaTask.execute();
	}
}
