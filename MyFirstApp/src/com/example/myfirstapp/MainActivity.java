package com.example.myfirstapp;

import com.example.myfirstapp.MyResponseHandler.ResourceParserHandler;
import com.example.myfirstapp.R;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;

import com.loopj.android.http.*;

public class MainActivity extends Activity {
	
	private static AsyncHttpClient mClient = new AsyncHttpClient();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		get("http://m.extra.com.br/catalogo/v1/departamentos", new RequestParams(), new ResourceParserHandler() {

			@Override
			public void onSuccess(Object resource) {
				Log.v("ACTIVITY","GOT DATA");
				showError("My god, it works!");
			}

			@Override
			public void onFailure(Throwable e) {
				Log.v("ACTIVITY","DIDINT GOT DATA");
				showError("Not even close dude!!");
				
			}

			@Override
			public void onFailure(Throwable e, String errorMessage) {
				Log.v("ACTIVITY",errorMessage);
				
			}
			
		});
		return true;
	}

	private void showError(String error) {
		dismissCrouton();
		LayoutInflater inflater = LayoutInflater.from(this);
		
		View view = inflater.inflate(R.layout.error_message, null);
		
		TextView textView = (TextView) view
				.findViewById(R.id.error_message_text_view);
		textView.setText(error);

		Configuration CONFIGURATION_INFINITE = new Configuration.Builder()
				.setDuration(Configuration.DURATION_INFINITE).build();
		Crouton.make(this, view, R.id.main_container, CONFIGURATION_INFINITE)
				.show();
	}

	public void dismissCrouton() {
		Crouton.cancelAllCroutons();
	}
	
	public static void get(String url, RequestParams params, ResourceParserHandler responseHandler) {
		
		mClient.get(url, params, MyResponseHandler.getInstance(responseHandler));
	}
}
