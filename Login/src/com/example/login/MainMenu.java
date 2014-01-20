// Java file and XML Done entirely by Owen Huyn
package com.example.login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainMenu extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent i = getIntent();
		final String username = i.getStringExtra("user");
		final String userType = i.getStringExtra("type");
		
		
		setContentView(R.layout.activity_main_menu);
        Button profile = (Button)findViewById(R.id.Profile);
        Button drugFirstAid = (Button)findViewById(R.id.DrugFirstAid);
        Button bmiCalc = (Button)findViewById(R.id.BmiCalc);
        Button logOut = (Button)findViewById(R.id.LogOut);
        
        
        profile.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
    			Intent profileMenu = new Intent(MainMenu.this, ProfileMenu.class);
    			profileMenu.putExtra("user", username);
    			profileMenu.putExtra("type", userType);
    			startActivity(profileMenu);
        	}
        	});
        drugFirstAid.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
    			Intent externalMenu = new Intent(MainMenu.this, ExternalMenu.class);
    			startActivity(externalMenu);
        	}
        	});
        bmiCalc.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
    			Intent bmiScreen = new Intent(MainMenu.this, BmiDisplay.class);
    			startActivity(bmiScreen);
        	}
        	});
        logOut.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
    			Intent login = new Intent(MainMenu.this, MainActivity.class);
    			startActivity(login);
        	}
        	});
        
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
