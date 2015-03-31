package ro.pub.cs.systems.pdsd.android_t1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

public class SecondaryActivity extends Activity {

	
	private class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.button4: {
					setResult(10, new Intent());
					finish();
					break;
				}
				case R.id.button5: {
					setResult(11, new Intent());
					finish();
					break;
				}
				default: {
					break;
				}
			}
			
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondary);
		
		Intent intent = getIntent();
		if (intent != null) {
			TextView tv1 = (TextView)findViewById(R.id.textView1);
			String total_number = intent.getStringExtra("ro.pub.cs.systems.pdsd.android_t1.TOTAL_NUMBER");
			tv1.setText(total_number);
		} 
		
		ButtonClickListener listenhere = new ButtonClickListener();
		
		Button b1 = (Button)findViewById(R.id.button4);
		b1.setOnClickListener(listenhere);
		Button b2 = (Button)findViewById(R.id.button5);
		b2.setOnClickListener(listenhere);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
