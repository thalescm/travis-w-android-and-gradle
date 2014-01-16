package com.example.myfirstapp;

import com.example.myfirstapp.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		showError("My god, it works!");
		return true;
	}

	private void showError(String error) {
		dismissCrouton();
		LayoutInflater inflater = LayoutInflater.from(this);
		
		View view = inflater.inflate(R.layout.error_message, null);
		
		TextView textView = (TextView) view
				.findViewById(R.id.error_message_text_view);
		
		error = this.getResources().getString(R.string.jose);
		textView.setText(error);

		Configuration CONFIGURATION_INFINITE = new Configuration.Builder()
				.setDuration(Configuration.DURATION_INFINITE).build();
		Crouton.make(this, view, R.id.main_container, CONFIGURATION_INFINITE)
				.show();
	}

	public void dismissCrouton() {
		Crouton.cancelAllCroutons();
	}
}
