package ro.cs.pub.ro.practicaltest02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest02MainActivity extends Activity {

	int number_of_checks;
	int REQ_CODE_S = 2;
	EditText numberOfChecks;
	CheckBox check1, check2, check3;
	Button navigate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test02_main);

		numberOfChecks = (EditText) findViewById(R.id.edit_text);
		check1 = (CheckBox) findViewById(R.id.checkbox1);
		check2 = (CheckBox) findViewById(R.id.checkbox2);
		check3 = (CheckBox) findViewById(R.id.checkbox3);
		navigate = (Button) findViewById(R.id.nav_button);

		if(savedInstanceState != null){
			
		}
		number_of_checks = 0;
		numberOfChecks.setText(Integer.toString(number_of_checks));
		check1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(buttonView.isChecked()){
					number_of_checks++;
					numberOfChecks.setText(Integer.toString(number_of_checks));
				}else{
					number_of_checks--;
					numberOfChecks.setText(Integer.toString(number_of_checks));
				}

			}
		});

		check2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(buttonView.isChecked()){
					number_of_checks++;
					numberOfChecks.setText(Integer.toString(number_of_checks));
				}else{
					number_of_checks--;
					numberOfChecks.setText(Integer.toString(number_of_checks));
				}

			}
		});

		check3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(buttonView.isChecked()){
					number_of_checks++;
					numberOfChecks.setText(Integer.toString(number_of_checks));
				}else{
					number_of_checks--;
					numberOfChecks.setText(Integer.toString(number_of_checks));
				}

			}
		});

		navigate.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String toSend = new String("");
				if(check1.isChecked()){
					toSend = toSend + "Check1";
				}
				if(check2.isChecked()){
					toSend = toSend + "Check2";
				}
				if(check3.isChecked()){
					toSend = toSend + "Check3";
				}
				Intent i = new Intent("ro.cs.pub.ro.SECONDARY");
				i.putExtra("CheckString", toSend);
				startActivityForResult(i,REQ_CODE_S);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test02_main, menu);
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
	protected void onActivityResult(int reqCode, int resultCode, Intent intent){
		Toast.makeText(this, "The activity returned with result "+ resultCode, Toast.LENGTH_LONG).show();
	}

}
