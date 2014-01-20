// Java file and XML Done entirely by Albraa
package com.example.login;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class FirstAidDisplay extends Activity {
	public final static String EXTRA_SEARCHFA = "com.example.medicalapp.SEARCHFA";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_aid_display);
		
		Intent i = getIntent();
		
		
		// Get a reference to the AutoCompleteTextView in the layout
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchFA);
		// Get the string array
		String[] firstAidSubject = getResources().getStringArray(R.array.first_aid_terms_array);
		// Create the adapter and set it to the AutoCompleteTextView 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, firstAidSubject);
		textView.setAdapter(adapter);
	}
	
    public void sendRequestFA(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, FirstAidResult.class);
		EditText queryText = (EditText) findViewById(R.id.searchFA);
		String query = queryText.getText().toString();
		intent.putExtra(EXTRA_SEARCHFA, query);
		startActivity(intent);
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.external_menu, menu);
		return true;
	}
}
