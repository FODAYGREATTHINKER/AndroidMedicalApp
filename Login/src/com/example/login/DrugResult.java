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

public class DrugResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drug_result);
		
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    String queryText = intent.getStringExtra(DrugDisplay.EXTRA_SEARCHDRUG);
	    
    	String outputResult = "There were no results matching the query.";
    	String[] drugText = getResources().getStringArray(R.array.drug_text_array);
    	String[] drugSubject = getResources().getStringArray(R.array.drug_terms_array);
    	
    	for(int i=0; i < drugSubject.length; i++) {
    		if (queryText.equalsIgnoreCase(drugSubject[i])) {
    			outputResult = drugText[i];
    		}
    	}
    	
	    // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(15);
	    textView.setText(outputResult);

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
