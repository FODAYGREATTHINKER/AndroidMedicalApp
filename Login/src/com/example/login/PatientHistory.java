// Java file and XML Done entirely by Owen Huyn
package com.example.login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.String;
public class PatientHistory extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_history);
		TextView name = (TextView) findViewById(R.id.Name);
		TextView height = (TextView) findViewById(R.id.Height);
		TextView weight = (TextView) findViewById(R.id.Weight);
		TextView healthCard = (TextView) findViewById(R.id.HealthCard);
		TextView averageHeartRate = (TextView) findViewById(R.id.HeartRate);
		TextView averageBloodPressure = (TextView) findViewById(R.id.BloodPressure);
		TextView conditions = (TextView) findViewById(R.id.Conditions);
		TextView medication = (TextView) findViewById(R.id.Medications);
		TextView notes = (TextView) findViewById(R.id.Notes);
		
		
		/* replace with accessors once database is done*/
		String patientName = "Owen Huyn";
		String patientHeight = "192cm";
		String patientWeight = "220lb";
		String patientHealthCard = "23123435";
		String patientConditions = "common cold";
		String patientHeartRate = "120";
		String patientBloodPressure = "120";
		String patientMedications = "tylenol";
		String patientNotes = "He is smart!";
		

		name.setText(patientName);
		height.setText(patientHeight);
		weight.setText(patientWeight);
		healthCard.setText(patientHealthCard);
		averageHeartRate.setText(patientHeartRate);
		averageBloodPressure.setText(patientBloodPressure);
		conditions.setText(patientConditions);
		medication.setText(patientMedications);
		notes.setText(patientNotes);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_history, menu);
		return true;
	}

}
