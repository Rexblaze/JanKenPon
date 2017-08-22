package com.example.jankenpon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartScreen extends Activity implements OnClickListener{
	
	Button bp,bs,bq;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_screen);
	
		bp=(Button)findViewById(R.id.playb);
		bs=(Button)findViewById(R.id.scoreb);
		bq=(Button)findViewById(R.id.quitb);
	
		bp.setOnClickListener(this);
		bs.setOnClickListener(this);
		bq.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		
		switch(arg0.getId()){
		
		case R.id.playb:
			Intent tomain=new Intent(this,MainActivity.class);
			startActivity(tomain); break;
			
		case R.id.scoreb:
			Intent toscore=new Intent(this, ScoreScreen.class);
			startActivity(toscore); break;
			
		case R.id.quitb:
			System.exit(0); break;
		}
	}

	

}
