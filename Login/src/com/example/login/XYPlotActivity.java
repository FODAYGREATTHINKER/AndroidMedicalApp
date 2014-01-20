// Java file and XML Done entirely by Ben Gardner
package com.example.login;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import com.androidplot.xy.*;

import java.util.Arrays;
 
/**
 * A straightforward example of using AndroidPlot to plot some data.
 */
public class XYPlotActivity extends Activity
{     
    private XYPlot plot;
 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
      
        Intent intent = getIntent();
        String message = intent.getStringExtra(ProfileMenu.EXTRA_MESSAGE);
        
        // fun little snippet that prevents users from taking screenshots
        // on ICS+ devices :-)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (message.equals("Weight")) {
          setContentView(R.layout.activity_xyplot);
        }
        else {
          setContentView(R.layout.activity_xyplot2);
        }
        
        // initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
 
        // Create a couple arrays of y-values to plot:
        Number[] series1Numbers = {150, 151, 152, 153, 154, 155, 153, 152, 150, 148, 145, 144, 144, 143, 143, 142, 141, 141, 140, 140, 140, 141, 142, 143, 145, 147, 149, 151, 152, 153, 154};
        Number[] series2Numbers = {180, 181, 181, 181, 181, 182, 182, 183, 184, 186};
 
        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Series1");                             // Set the display title of the series
 
        // same as above
        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");
 
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter();
        series1Format.setPointLabelFormatter(new PointLabelFormatter());
        series1Format.configure(getApplicationContext(), R.xml.line_point_formatter_with_plf1);
 
        // same as above:
        LineAndPointFormatter series2Format = new LineAndPointFormatter();
        series2Format.setPointLabelFormatter(new PointLabelFormatter());
        series2Format.configure(getApplicationContext(), R.xml.line_point_formatter_with_plf2);
        
        if (message.equals("Weight")) {
          // add a new series to the xyplot:
          plot.addSeries(series1, series1Format);
        }
        else {
          plot.addSeries(series2, series2Format);
        }
        
        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);
 
    }
}