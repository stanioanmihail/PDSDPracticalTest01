package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		TextView clicks = (TextView)findViewById(R.id.number_of_clicks_text_view);
		Intent intent = getIntent();
		if(intent != null){
			String nb_clicks = intent.getStringExtra("nb_clicks");
			if(nb_clicks != null){
				clicks.setText(nb_clicks);
			}
		}
		Button buttonOk = (Button)findViewById(R.id.ok_button);
	    buttonOk.setOnClickListener(buttonClickListener);
	    Button buttonCancel = (Button)findViewById(R.id.cancel_button);
	    buttonCancel.setOnClickListener(buttonClickListener);  
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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
	
	private class ButtonClickListener implements Button.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()) {
	        case R.id.ok_button:
	          setResult(RESULT_OK, new Intent());
	          finish();
	          break;
	        case R.id.cancel_button:
	          setResult(RESULT_CANCELED, new Intent());
	          finish();
	          break;
	      }
			
			
		}
	}

}
