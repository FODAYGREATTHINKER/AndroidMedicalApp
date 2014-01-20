// Java file and XML Done entirely by Owen Huyn

package com.example.login;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.widget.Spinner;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.String;

public class ProfileMenu extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.plots.MESSAGE";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_menu);
		
		
		Intent i = getIntent();
		final String username = i.getStringExtra("user");
		final String userType = i.getStringExtra("type");
		
		final TextView invalidAppointments = (TextView)findViewById(R.id.AppointmentsInvalid);
		final TextView invalidPatientHistory = (TextView)findViewById(R.id.PatientHistoryInvalid);
		
		
		
		final Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.popup4);
		dialog.setTitle("Access");

		TextView text1 = (TextView) dialog.findViewById(R.id.text1);
		text1.setText("You cannot access this.");
		
		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
			//put write methods here into database to save patient
		});
		
		
		
		Button appointmentsViewButton = (Button)findViewById(R.id.AppointmentsView);
		appointmentsViewButton.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		Intent appointments = new Intent(ProfileMenu.this, ViewAppointments.class);
        		appointments.putExtra("user", username);
        		appointments.putExtra("type", userType);
    			startActivity(appointments);
        	}
		});
		
		
		
		Button patientHistoryViewButton = (Button)findViewById(R.id.PatientHistoryView);
		patientHistoryViewButton.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
    			Intent patientHistory = new Intent(ProfileMenu.this, PatientHistory.class);
    			patientHistory.putExtra("user", username);
    			startActivity(patientHistory);
	}
		});
		
		Button patientHistoryEditButton = (Button)findViewById(R.id.PatientHistoryEdit);
		patientHistoryEditButton.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		if (userType.equals("doctor") || userType.equals("admin")){
	    			Intent patientHistory = new Intent(ProfileMenu.this, PatientHistoryEdit.class);
	    			patientHistory.putExtra("user", username);
	    			patientHistory.putExtra("type", userType);
	    			startActivity(patientHistory);
        		}
        		else {
        			dialog.show();
        			//disables people who can't access the edit
        		}
	}
		});
		
		Button plotsButton = (Button)findViewById(R.id.Plots);
		plotsButton.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
	    			Intent plotMenu = new Intent(ProfileMenu.this, PlotMenu.class);
	    			startActivity(plotMenu);
	}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile_menu, menu);
		return true;
	}
	

}
