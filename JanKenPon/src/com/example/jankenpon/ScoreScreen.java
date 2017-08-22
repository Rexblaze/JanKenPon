package com.example.jankenpon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ScoreScreen extends Activity implements OnClickListener{

	
	TextView scoretitle;
	Boolean flag=false;
	int result,iresult=0;
	Button again,sorry;
	String temp="Play first? ):";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score_screen);
	
		scoretitle=(TextView)findViewById(R.id.skorname);
		again=(Button)findViewById(R.id.gotogame);
		sorry=(Button)findViewById(R.id.skiptomainmenu);
		again.setOnClickListener(this);
		sorry.setOnClickListener(this);
		
		SharedPreferences pref=getApplicationContext().getSharedPreferences("Mypref", MODE_PRIVATE);
		Editor editor=pref.edit();
		
	//Intent getwin=new Intent(this,MainActivity.class);
	Bundle moes=getIntent().getExtras();
	iresult=0;
	//result=0;
	try {
		 
	iresult=moes.getInt("vinny");
	//flag =	getwin.getBooleanExtra("wins", false);
	result=pref.getInt("winnz", 0);
	
	} catch (Exception e) {
		// TODO: handle exception
		
	}
	
	result=result+iresult;
	//String temp=String.valueOf(result);
	temp=String.valueOf(result);
	editor.putInt("winnz", result);
	editor.commit();
	
	
	scoretitle.setText("Total wins "+temp);
	
	//if(flag){
		//result++;
	
	//}
//	if(flag)scoretitle.setText("Score is TRUE!");
	//flag=false;
	 
	}

	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()){
		
		case R.id.gotogame:
		Intent backk=new Intent(this,MainActivity.class);
		startActivity(backk);
		
		case R.id.skiptomainmenu:
		Intent mmenu=new Intent(this,StartScreen.class);
		startActivity(mmenu);
		}
	}

	
}
