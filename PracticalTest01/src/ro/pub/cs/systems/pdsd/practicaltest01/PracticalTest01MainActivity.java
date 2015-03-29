package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		EditText leftEditText = (EditText)findViewById(R.id.left_edit_text);
		EditText rightEditText = (EditText)findViewById(R.id.right_edit_text);
		Button leftButton = (Button)findViewById(R.id.left_button);
		Button rightButton = (Button)findViewById(R.id.right_button);
		
		
		leftEditText.setText(String.valueOf(0));
		rightEditText.setText(String.valueOf(0));
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
	
	private class ButtonClickListener implements Button.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText leftEditText = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.left_edit_text);
			EditText rightEditText = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.right_edit_text);
			
			//define action
		}
	}
	
}
