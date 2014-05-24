package com.example.dimenvegana;

import com.example.dimenvegana.MainActivity;
import com.example.dimenvegana.R;
import com.example.dimenvegana.RaizActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			 	
		final Button _bRecetas = (Button)findViewById(R.id.buttonReceta);
		
		_bRecetas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {			   
		       //Creamos el Intent para convocar el componente RaizActivity
			   Intent intent = new Intent(MainActivity.this, RaizActivity.class);
			   			   
			   //Iniciamos la nueva actividad
			   startActivity(intent);			   				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
