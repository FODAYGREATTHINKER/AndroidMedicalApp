// Done by Derek; Revised, debugged and reformatted by Owen
package com.example.login;

import java.util.ArrayList;
import java.util.Calendar;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAppointments extends Activity {
	public final static String apts = "com.example.login.EditAppointments";
	static final int PICK_DATE_REQUEST = 1;
	Boolean edit;
	String userType;
	String username;
	Dialog dialog2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_appointments);
		
		
		Intent i = getIntent();
		username = i.getStringExtra("user");
		userType = i.getStringExtra("type");
		

		if (userType.equalsIgnoreCase("Administrator") || userType.equalsIgnoreCase("Doctor")){
			edit = true;
		}else {
			edit = false;
		}
		
		//Get current time
		
		Calendar c = Calendar.getInstance(); 
		String minute = String.valueOf(c.get(Calendar.MINUTE));
		String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		String day = String.valueOf(c.get(Calendar.DATE));
		String month = String.valueOf(c.get(Calendar.MONTH)+1);
		String year = String.valueOf(c.get(Calendar.YEAR));
		
		
		String formatday = ("00" + day).substring(day.length());
		String formathour = ("00" + hour).substring(hour.length());
		String formatminute = ("00" + minute).substring(minute.length());
		
		long currentTime = Long.parseLong(year + month + formatday + formathour + formatminute);
		
		//Get alert time and appointment title from database
		long alertTime = 201312031459l; 
		
		
		dialog2 = new Dialog(this);
		dialog2.setContentView(R.layout.popup4);
		dialog2.setTitle("Access");

		TextView text3 = (TextView) dialog2.findViewById(R.id.text1);
		text3.setText("You cannot access this.");
		
		Button dialogButton1 = (Button) dialog2.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog2.dismiss();
			}
			//put write methods here into database to save patient
		});
		
		
		
		//for creating dialog
		if (alertTime - currentTime <= (100) && alertTime - currentTime >= 0){
			//condition: show up dialog for appointments coming up in 59 minutes
			
						final Dialog dialog = new Dialog(this);
						dialog.setContentView(R.layout.popup);
						dialog.setTitle("Appointment Alert");
						
						TextView text2 = (TextView) dialog.findViewById(R.id.text2);
						text2.setText("Your appointment is within the next hour");
						
						Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
						// if button is clicked, close the custom dialog
						dialogButton.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								dialog.dismiss();
							}
							//put write methods here into database to save patient
						});
			 
						dialog.show();
		}
	}
	

	
	public void open(View view) {
        // Do something in response to button
		DatePicker dp = (DatePicker)findViewById(R.id.datePicker1);		
		int date = Integer.parseInt(String.valueOf(dp.getYear()) + String.valueOf(dp.getMonth()) + String.valueOf(dp.getDayOfMonth()));
		
		//load DATABASE
		
		//start showing the list
		final ListView listview = (ListView) findViewById(R.id.listView1);
		
		//change these to appointment information from the database instead
	    String[] values = new String[] { "apt1", "apt2", "apt3",
	        "apt4", "apt5", "apt6", "apt7", "apt8" };
	    final ArrayList<String> list = new ArrayList<String>();
	    for (int i = 0; i < values.length; ++i) {
	      list.add(values[i]);
	    }
	    final StableArrayAdapter adapter = new StableArrayAdapter(this,
	            android.R.layout.simple_list_item_1, list);
	    
	    if (edit = true){
	    listview.setAdapter(adapter);

	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	      @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
		@Override
	      public void onItemClick(AdapterView<?> parent, final View view,
	          int position, long id) {
	        final String item = (String) parent.getItemAtPosition(position);
	        view.animate().setDuration(0).alpha(0)
	            .withEndAction(new Runnable() {
	              @Override
	              public void run() {
	            	Intent intent = new Intent(view.getContext(),EditAppointments.class);
		            intent.putExtra(apts,item);
		            intent.putExtra("type",userType);
	                adapter.notifyDataSetChanged();
	                view.setAlpha(1);
	                if (userType.equals("doctor") || userType.equals("admin")){
	                startActivity(intent);
	                
	                }
	                else{
	                	dialog2.show();
	                }
	              }
	            });
	      }

	    });
	    }
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	

}
