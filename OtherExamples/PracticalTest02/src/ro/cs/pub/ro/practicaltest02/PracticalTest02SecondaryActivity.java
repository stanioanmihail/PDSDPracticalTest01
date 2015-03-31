package ro.cs.pub.ro.practicaltest02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest02SecondaryActivity extends Activity {

	Button ok_button, cancel_button;
	TextView showMessage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test02_secondary);

		ok_button = (Button) findViewById(R.id.button_ok);
		cancel_button = (Button) findViewById(R.id.button_cancel);
		showMessage = (TextView) findViewById(R.id.showCheck);

		Intent i = getIntent();
		if(i != null){
			String name_checks = i.getStringExtra("CheckString");
			if(name_checks != null){
				showMessage.setText(name_checks);
			}
		}

		ok_button.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(RESULT_OK, new Intent());	
				finish();
			}
		});

		cancel_button.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(RESULT_CANCELED, new Intent());
				finish();
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test02_secondary, menu);
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
