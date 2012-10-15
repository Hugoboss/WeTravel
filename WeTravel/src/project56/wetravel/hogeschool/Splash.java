package project56.wetravel.hogeschool;

import project56.wetravel.hogeschool.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity 
{

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread logoTimer = new Thread()
        {
        	public void run()
        	{
        		try
        		{
        			sleep(5000);
        			Intent menuIntent = new Intent("project56.wetravel.hogeschool.hoofdmenu");
        			startActivity(menuIntent);
        		} 
        		catch (InterruptedException e) 
        		{
					e.printStackTrace();
				}
        		finally
        		{
        			finish();
        		}
        	}
        };
        logoTimer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}