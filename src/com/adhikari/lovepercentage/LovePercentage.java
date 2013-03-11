package com.adhikari.lovepercentage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LovePercentage extends Activity {

	EditText urname;
	EditText partersname;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ove_percentage);
		
		urname = (EditText) findViewById(R.id.urname);
		partersname = (EditText) findViewById(R.id.partnername);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ove_percentage, menu);
		return true;
	}
	
	public void calculate(View v)
	{
		int rand_num = random_number();
		String urname_value = urname.getText().toString();
		String partnersname_value = partersname.getText().toString();
		
		int love_percentage = if_present(urname_value.toLowerCase(),partnersname_value.toLowerCase());
		if (urname_value == "" || partnersname_value == "")
		{
			Toast.makeText(getApplicationContext(), "Forever Alone.", Toast.LENGTH_LONG).show();
		}
		else if(love_percentage != 0)
		{
			Toast.makeText(getApplicationContext(), love_percentage + " %", Toast.LENGTH_LONG).show();
		}
		else
		{
			Toast.makeText(getApplicationContext(), rand_num + " %", Toast.LENGTH_LONG).show();
			store(urname_value.toLowerCase(),partnersname_value.toLowerCase(),Integer.toString(rand_num));
		}
		
	}
	
	public int random_number()
	{
		int Min = 50;
		int Max = 100;
		return (Min + (int)(Math.random() * ((Max - Min) + 1)));
	}
	
	public void store(String urname, String partners_name, String love_percentage)
	{
		SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);

		p.edit().putString(urname+partners_name, love_percentage).commit();
		
	}
	public int if_present(String urname, String partners_name)
	{
		SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);

		
		return Integer.parseInt(p.getString(urname+partners_name, "0"));


		
	}
}
	


