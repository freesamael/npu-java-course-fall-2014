package tw.edu.npu.mis.sample;

import android.app.Activity;
import android.os.Bundle;

/**
 * The main entry activity.
 * 
 * @author samael_wang
 *
 */
public class SampleActivity extends Activity {
	private static final String LOG_TAG = "SampleActivity";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);
	}

}
