// Java file and XML Done entirely by Owen Huyn
package com.example.login;
 
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import static java.lang.System.out;
 
public class PatientHistoryEdit extends Activity {
 
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_patient_history_edit);
                
                
               
                Intent i = getIntent();
                
        		final String username = i.getStringExtra("user");
        		final String userType = i.getStringExtra("type");
               
                TextView name = (TextView) findViewById(R.id.Name);
                final EditText height = (EditText) findViewById(R.id.Height);
                final EditText weight = (EditText) findViewById(R.id.Weight);
                final EditText healthCard = (EditText) findViewById(R.id.HealthCard);
                final EditText averageHeartRate = (EditText) findViewById(R.id.HeartRate);
                final EditText averageBloodPressure = (EditText) findViewById(R.id.BloodPressure);
                final EditText conditions = (EditText) findViewById(R.id.Conditions);
                final EditText medication = (EditText) findViewById(R.id.Medications);
                final EditText notes = (EditText) findViewById(R.id.Notes);
                Button mButton = (Button)findViewById(R.id.submitButton);
               
               
               
                /* replace with accessors once database is done*/
                //test values are located below
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
               
                
                
                mButton.setOnClickListener(new View.OnClickListener(){
                	public void onClick(View v){
                		String patientHeight = height.getText().toString();
                		String patientWeight = weight.getText().toString();
                		String patientHealthCard = healthCard.getText().toString();
                		String patientConditions = averageHeartRate.getText().toString();
                		String patientHeartRate = averageBloodPressure.getText().toString();
                		String patientBloodPressure = conditions.getText().toString();
                		String patientMedications = medication.getText().toString();
                		String patientNotes = notes.getText().toString();
                		
                		/* put write methods once database is finished by simply using write methods*/
                       
                		
                		// -----------------------------
                		
    	    			Intent profileMenu = new Intent(PatientHistoryEdit.this, ProfileMenu.class);
    	    			profileMenu.putExtra("user", username);
    	    			profileMenu.putExtra("type", userType);
    	    			startActivity(profileMenu);
                		
                }});
        }
 
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.patient_history_edit, menu);
                return true;
        }
        

 
}