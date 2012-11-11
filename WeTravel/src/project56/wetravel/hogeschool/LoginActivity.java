package project56.wetravel.hogeschool;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inloggen);
		
		final EditText username = (EditText) findViewById(R.id.email_edit);
		final EditText password = (EditText) findViewById(R.id.password_edit);
		final Button loginButton = (Button) findViewById(R.id.btnLogin);
		JSONArray jsonArray = Webservice.getJSONfromURL("https://www.digi-menu.nl/webservice/webservice.php?password=wetravel");
		
		
		//Login button listener
		loginButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				//init post data
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(); 
				nameValuePairs.add(new BasicNameValuePair("user", username.getEditableText().toString()));
				nameValuePairs.add(new BasicNameValuePair("pass", password.getEditableText().toString()));
				
				//send data to webservice
				JSONArray jsonArray = Webservice.getJSONfromURL("http://www.urlnaarwebservice.nl/webservice.php?password=wetravel&action=login");
				
				try {
					JSONObject jsonObject = jsonArray.getJSONObject(0);
					if(jsonObject.getString("result") == "1") {
						//login credentials are correct. Log the user in
					}
					else
					{
						//No correct credentials given
					}
				}
				catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
}