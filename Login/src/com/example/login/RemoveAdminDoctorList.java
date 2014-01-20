// Java file and XML Done entirely by Owen Huyn

package com.example.login;

import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.NavUtils;
import android.support.v4.app.NavUtils;
import android.widget.LinearLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RemoveAdminDoctorList extends Activity {
	String doctorList[];
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
		doctorList = new String[]{"Dr.Paul","Dr.James"};
		for (int j = 0; j < doctorList.length; j++){
			valueB = new Button(this);
            valueB.setText(doctorList[j]);
            valueB.setId(j);
            valueB.setOnClickListener(clickListener);
            myLayout.addView(valueB);
		}

		
		
	}	


	public OnClickListener clickListener = new OnClickListener() {
        public void onClick(View v) {
        				//removal methods
        	
        	// start here
			Intent restart = new Intent(RemoveAdminDoctorList.this, AdminPatientList.class);
			restart.putExtra("type", userType);
			startActivity(restart);
        }
    };
    

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_list, menu);
		return true;
	}

}

