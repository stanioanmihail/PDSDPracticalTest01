package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {

	ButtonClickListener buttonClickListener = new ButtonClickListener();
	int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		EditText leftEditText = (EditText)findViewById(R.id.left_edit_text);
		EditText rightEditText = (EditText)findViewById(R.id.right_edit_text);
		Button leftButton = (Button)findViewById(R.id.left_button);
		leftButton.setOnClickListener(buttonClickListener);
		Button rightButton = (Button)findViewById(R.id.right_button);
		rightButton.setOnClickListener(buttonClickListener);
		Button navigateToSecondaryActivity = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
		navigateToSecondaryActivity.setOnClickListener(buttonClickListener);
		
		if(savedInstanceState != null){
			String leftCount = (String) savedInstanceState.getString("leftCount");
			String rightCount = (String) savedInstanceState.getString("rightCount");
			if(leftCount != null){
				leftEditText.setText(leftCount);
			}else{
				leftEditText.setText(String.valueOf(0));	
			}
			
			if(rightCount != null){
				rightEditText.setText(rightCount);
			}else{
				rightEditText.setText("0");
			}
		}else{
			leftEditText.setText(String.valueOf(0));
			rightEditText.setText(String.valueOf(0));
		}
		
		
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
	protected void onSaveInstanceState(Bundle savedInstaceState){
		EditText leftEditText = (EditText)findViewById(R.id.left_edit_text);
		EditText rightEditText = (EditText)findViewById(R.id.right_edit_text);
		
		savedInstaceState.putString("leftCount", leftEditText.getText().toString());
		savedInstaceState.putString("rightCount", rightEditText.getText().toString());
	}
	@Override
	protected void onActivityResult(int reqCode, int resultCode, Intent intent){
		Toast.makeText(this, "The activity returned with result "+ resultCode, Toast.LENGTH_LONG).show();
	}
	
	private class ButtonClickListener implements Button.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText leftEditText = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.left_edit_text);
			EditText rightEditText = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.right_edit_text);
			int leftButtonClickedNumber = Integer.parseInt(leftEditText.getText().toString());
			int rightButtonClickedNumber = Integer.parseInt(rightEditText.getText().toString());
			
			//define action
			switch(v.getId()){
			case R.id.left_button:
				leftButtonClickedNumber++;
				leftEditText.setText(String.valueOf(leftButtonClickedNumber));
				break;
			case R.id.right_button:
				rightButtonClickedNumber++;
				rightEditText.setText(String.valueOf(rightButtonClickedNumber));
				break;
			case R.id.navigate_to_secondary_activity_button:
				Intent navigate_to_secondary_activity_intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
				navigate_to_secondary_activity_intent.putExtra("nb_clicks", 
						 (leftButtonClickedNumber +
						 rightButtonClickedNumber) + "");
				startActivityForResult(navigate_to_secondary_activity_intent, SECONDARY_ACTIVITY_REQUEST_CODE);
				break;
			}
		}
	}
	
}
