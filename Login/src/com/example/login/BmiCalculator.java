// Java file and XML Done entirely by Albraa
package com.example.login;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class BmiCalculator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

	    // Get the message from the intent
	    Intent intent = getIntent();
	    String mass = intent.getStringExtra(BmiDisplay.EXTRA_MASS);
	    String height = intent.getStringExtra(BmiDisplay.EXTRA_HEIGHT);
	    
	    if (mass.equals("") || height.equals("")) {
	    	mass = "0";
	    	height = "0";
	    }
	    
	    double massNumber = Double.parseDouble(mass);
	    double heightNumber = Double.parseDouble(height);
	    
	    double BMI = massNumber/(heightNumber*heightNumber);
	    String BMIText = "Your BMI = " + String.format("%.1f", BMI);

	    // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(20);
	    textView.setText(BMIText);

	    // Set the text view as the activity layout
	    setContentView(textView);
	}
	
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.external_menu, menu);
		return true;
	}
 
}
