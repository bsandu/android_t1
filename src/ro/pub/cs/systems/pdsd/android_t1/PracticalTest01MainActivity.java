package ro.pub.cs.systems.pdsd.android_t1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
	
	private class ButtonClickListener implements Button.OnClickListener {
		
		EditText edt1 = (EditText)findViewById(R.id.editText1);
		EditText edt2 = (EditText)findViewById(R.id.editText2);
	
		@Override
		public void onClick(View v) {
			switch( v.getId() ) {
				case R.id.button2: {
					int newint = Integer.parseInt(edt1.getText().toString()) + 1;
					edt1.setText(Integer.toString(newint),TextView.BufferType.EDITABLE);
					break;
				}
				case R.id.button3: {
					int newint = Integer.parseInt(edt2.getText().toString()) + 1;
					edt2.setText(Integer.toString(newint),TextView.BufferType.EDITABLE);
					break;
				}
				case R.id.button1: {
					int newint = Integer.parseInt(edt1.getText().toString()) + Integer.parseInt(edt2.getText().toString());
					Intent intent = new Intent("ro.pub.cs.systems.pdsd.android_t1.intent.action.SecondaryActivity");
					intent.putExtra("ro.pub.cs.systems.pdsd.android_t1.TOTAL_NUMBER", Integer.toString(newint));
					startActivityForResult(intent, 1999);
					break;
				}
				default:
					break;
			}
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		EditText ed1 = (EditText)findViewById(R.id.editText1);
		EditText ed2 = (EditText)findViewById(R.id.editText2);
		
		
		if (savedInstanceState == null) {
			ed1.setText(String.valueOf(0));
			ed2.setText(String.valueOf(0));
		}
		else {
			ed1.setText(savedInstanceState.getString("left"));
			ed2.setText(savedInstanceState.getString("right"));
		}
		
		ButtonClickListener listenhere = new ButtonClickListener();
		
		Button b1 = (Button)findViewById(R.id.button1);
		b1.setOnClickListener(listenhere);
		Button b2 = (Button)findViewById(R.id.button2);
		b2.setOnClickListener(listenhere);
		Button b3 = (Button)findViewById(R.id.button3);
		b3.setOnClickListener(listenhere);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		EditText ed1 = (EditText)findViewById(R.id.editText1);
		EditText ed2 = (EditText)findViewById(R.id.editText2);
		savedInstanceState.putString("left", ed1.getText().toString());
		savedInstanceState.putString("right", ed2.getText().toString());
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
	}
}
