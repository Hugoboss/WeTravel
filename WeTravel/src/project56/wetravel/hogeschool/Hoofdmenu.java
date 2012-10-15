package project56.wetravel.hogeschool;

import android.app.Activity;
import android.content.Context;
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
		addListenerOnImageView();
		addListenerOnImageView2();
		addListenerOnImageView3();
	}

	public void addListenerOnImageView() {

		ImageView iv = (ImageView) findViewById(R.id.inloggen);

		iv.setOnClickListener(new OnClickListener() {

			
			public void onClick(View arg0) {
				setContentView(R.layout.inloggen);   

			}

		});

	}
	
	public void addListenerOnImageView2() {

		

		ImageView iv = (ImageView) findViewById(R.id.registreren);

		iv.setOnClickListener(new OnClickListener() {

			
			public void onClick(View arg0) {
				setContentView(R.layout.registreren); 
				
			}

		});

	}
	
	
	public void addListenerOnImageView3() {

		

		ImageView iv = (ImageView) findViewById(R.id.informatie);

		iv.setOnClickListener(new OnClickListener() {

			
			public void onClick(View arg0) {
				setContentView(R.layout.informatie); 
			}

		});

	}
}
