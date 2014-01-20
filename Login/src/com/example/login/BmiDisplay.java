// Java file and XML Done entirely by Albraa
package com.example.login;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class BmiDisplay extends Activity {
	public final static String EXTRA_MASS = "com.example.medicalapp.MASS";
	public final static String EXTRA_HEIGHT = "com.example.medicalapp.HEIGHT";

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmi_display);
		
		Intent i = getIntent();
		
	}
	
	/** Called when the user clicks the Send button */
	public void sendNumbers(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, BmiCalculator.class);
		EditText massText = (EditText) findViewById(R.id.mass);
		EditText heightText = (EditText) findViewById(R.id.height);
		String mass = massText.getText().toString();
		String height = heightText.getText().toString();
		intent.putExtra(EXTRA_MASS, mass);
		intent.putExtra(EXTRA_HEIGHT, height);
		startActivity(intent);
	}
	
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.external_menu, menu);
		return true;
	}
}
