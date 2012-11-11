package project56.wetravel.hogeschool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Hoofdmenu extends Activity {

	final Context context = this;
	Button button;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hoofdmenu);
		
		ImageView loginImage = (ImageView) findViewById(R.id.inloggen); //login button
		ImageView registerImage = (ImageView) findViewById(R.id.registreren); //register button
		ImageView infoImage = (ImageView) findViewById(R.id.informatie); //Information button
		
		//Login button listener
		loginImage.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {				
				Intent i = new Intent(getApplicationContext(),LoginActivity.class);
				startActivityForResult(i,1); //starts LoginActivity
			}
		});
		
		//Register button listener
		registerImage.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {				
				Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
				startActivityForResult(i,1); //starts RegisterActivity
			}
		});

		//Information button listener
		infoImage.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {				
				Intent i = new Intent(getApplicationContext(),InformationActivity.class);
				startActivityForResult(i,1); //starts RegisterActivity
			}
		});
	}



	
	
	public void addListenerOnImageView3() {
		ImageView iv = (ImageView) findViewById(R.id.informatie);

		iv.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//setContentView(R.layout.informatie); 
			}

		});

	}
}
