package project56.wetravel.hogeschool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

public class Webservice {
	/**
	 * Returns JSON data from webservice
	 * @param url Url to webservice
	 * @return JSON data
	 */
	public static JSONArray getJSONfromURL(String url)
	{
		//initialize
		InputStream is = null;
		String result = "";
		JSONArray jArray = null;

		//http post
		try
		{
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
            HttpConnectionParams.setSoTimeout(httpParams, 30000);
            SingleClientConnManager mgr = new SingleClientConnManager(httpParams,null); 
			HttpClient httpclient = new DefaultHttpClient(mgr,httpParams);
			HttpPost httppost = new HttpPost(url);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
			
		}
		catch(Exception e)
		{
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}
		catch(Exception e)
		{
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//try parse the string to a JSONArray
		try
		{
	        jArray = new JSONArray(result);
		}
		catch(JSONException e)
		{
			Log.e("log_tag", "Error parsing data "+e.toString());
		}

		return jArray;
	}
	
	/**
	 * JSON data from webservice
	 * @param url Url to webservice
	 * @param postData PostData values for HttpPost
	 * @return JSON data
	 */
	public static JSONArray getJSONfromURL(String url, List<NameValuePair> postData)
	{
		//initialize
		InputStream is = null;
		String result = "";
		JSONArray jArray = null;

		//http post
		try
		{			
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
            HttpConnectionParams.setSoTimeout(httpParams, 30000);
            SingleClientConnManager mgr = new SingleClientConnManager(httpParams, null); 
			HttpClient httpclient = new DefaultHttpClient(mgr,httpParams);
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new UrlEncodedFormEntity(postData)); 
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		}
		catch(Exception e)
		{
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}
		catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//try parse the string to a JSONArray
		try
		{
	        jArray = new JSONArray(result);
		}
		catch(JSONException e)
		{
			Log.e("log_tag", "Error parsing data "+e.toString());
		}

		return jArray;
	}
}
