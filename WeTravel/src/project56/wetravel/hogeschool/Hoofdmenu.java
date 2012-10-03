package project56.wetravel.hogeschool;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Hoofdmenu extends Activity {

	final Context context = this;
	Button button;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hoofdmenu);
		addListenerOnButton();
		addListenerOnButton2();
		addListenerOnButton3();
	}

	public void addListenerOnButton() {

		button = (Button) findViewById(R.id.inloggen);

		button.setOnClickListener(new OnClickListener() {

			
			public void onClick(View arg0) {
				setContentView(R.layout.inloggen);   

			}

		});

	}
	
	public void addListenerOnButton2() {

		

		button = (Button) findViewById(R.id.registreren);

		button.setOnClickListener(new OnClickListener() {

			
			public void onClick(View arg0) {
				setContentView(R.layout.registreren); 
				
			}

		});

	}
	
	
	public void addListenerOnButton3() {

		

		button = (Button) findViewById(R.id.informatie);

		button.setOnClickListener(new OnClickListener() {

			
			public void onClick(View arg0) {
				setContentView(R.layout.informatie); 
			}

		});

	}
}
