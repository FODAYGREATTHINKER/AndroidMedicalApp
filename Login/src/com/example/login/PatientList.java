// Java file and XML Done entirely by Owen Huyn

package com.example.login;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.widget.LinearLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PatientList extends Activity {
	String patientList[];
	String userType;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_list);
		
		Intent i = getIntent();
		userType = i.getStringExtra("type");
		Button valueB;
		LinearLayout myLayout;
		
		myLayout =(LinearLayout) findViewById(R.id.linearLayout);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		myLayout.setOrientation(LinearLayout.VERTICAL);
		
		/* replace with accessing database user IDs or names and input into array with for loop
		 * once database is finished
		 */
		patientList = new String[]{"John","Bob","Paul","Tyler","Albraa","Owen"};
		for (int j = 0; j < patientList.length; j++){
			valueB = new Button(this);
            valueB.setText(patientList[j]);
            valueB.setId(j);
            valueB.setOnClickListener(clickListener);
            myLayout.addView(valueB);
		}

		
		}

    public OnClickListener clickListener = new OnClickListener() {
        public void onClick(View v) {
           
                          Intent patientProfile = new Intent(getApplicationContext(), MainMenu.class);
                          patientProfile.putExtra("user", patientList[v.getId()]);
                          patientProfile.putExtra("type", userType);
                          startActivity(patientProfile);      
        }
    };
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_list, menu);
		return true;
	}

}

