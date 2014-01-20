// Java file and XML Done entirely by Ben Gardner
package com.example.login;


import android.os.Bundle;
import android.content.Intent;
import android.widget.Spinner;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class PlotMenu extends Activity {
  // Key for extra
  public final static String EXTRA_MESSAGE = "com.example.plots.MESSAGE";
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_plot_menu);
      Intent i = getIntent();
    }
  
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
    }
    
    public void sendMessage(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        String message = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
        Intent intent = new Intent(this, XYPlotActivity.class);
        // Value for extra
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}