// Java file and XML Done entirely by Owen Huyn
package com.example.login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ExternalMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_external_menu);
		
		Intent i = getIntent();
		
        Button drug = (Button)findViewById(R.id.Drug);
        Button firstAid = (Button)findViewById(R.id.FirstAid);
        
        drug.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
    			Intent drugScreen = new Intent(ExternalMenu.this, DrugDisplay.class);
    			startActivity(drugScreen);
        	}
        	});
        
        firstAid.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
    			Intent firstAidScreen = new Intent(ExternalMenu.this, FirstAidDisplay.class);
    			startActivity(firstAidScreen);
        	}
        	});
        
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.external_menu, menu);
		return true;
	}

}
