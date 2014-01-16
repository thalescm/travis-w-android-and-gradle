package com.example.projectnamehere;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.projectnamehere.R;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Configuration;

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

        showError("COMPILOU A JAR EXTERNA");

        return true;
    }
    
    private void showError(String error) {
        dismissCrouton();
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.crouton_error, null);
        TextView textView = (TextView) view
                .findViewById(R.id.error_message_text_view);
        textView.setText(error);
        Configuration CONFIGURATION_INFINITE = new Configuration.Builder()
                .setDuration(Configuration.DURATION_INFINITE).build();
        Crouton.make(this, view, R.id.layout_container,
                CONFIGURATION_INFINITE).show();
    }

    public void dismissCrouton() {
        Crouton.cancelAllCroutons();
    }
    

}
