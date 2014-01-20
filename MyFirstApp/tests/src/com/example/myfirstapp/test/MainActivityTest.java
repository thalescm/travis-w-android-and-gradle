package com.example.myfirstapp.test;

import com.example.myfirstapp.MainActivity;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity activity;
	private int textViewId;

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {

		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				MainActivity.class);

		setActivityIntent(intent);
		activity = getActivity();

		super.setUp();
	}

	public void testLayout() {
		textViewId = com.example.myfirstapp.R.id.main_activity_text_view;
		assertNotNull(activity.findViewById(textViewId));
		TextView view = (TextView) activity.findViewById(textViewId);
		assertEquals("Incorrect label of the button", "Paralamas do Sucesso", view.getText());
	}

}