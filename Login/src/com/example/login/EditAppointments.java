// Done by Derek; Revised, debugged and reformatted by Owen
package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class EditAppointments extends Activity{
	String userType;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_edit_appointments);

			final EditText et;
			et = (EditText) findViewById(R.id.editText1);
			
	    // Get the message from the intent
	    Intent i = getIntent();
	    String apts = i.getStringExtra(ViewAppointments.apts);
	    userType = i.getStringExtra("type");
	    et.setText(apts);

	}
	
	public void save(View view){
		// Do something in response to button
		if (userType.equals("admin")|| userType.equals("doctor")) {
				TimePicker dp = (TimePicker)findViewById(R.id.timePicker1);		
				int time = Integer.parseInt(String.valueOf(dp.getCurrentHour()) + String.valueOf(dp.getCurrentMinute()));
				
				// once database is done, write into database right here
		}
		else{
			//do nothing if patient
		}
				//access DATABASE
				
				
	}
}
