package com.example.jankenpon;

import java.io.ObjectOutputStream.PutField;
import java.util.Random;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	TextView tshow,tscore;
	Button br,bp,bs;
	int ps=0,cs=0,losses;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		losses=0;
		
		tshow=(TextView)findViewById(R.id.textView3);
		tscore=(TextView)findViewById(R.id.textView4);
		br=(Button)findViewById(R.id.button1);
		bp=(Button)findViewById(R.id.button2);
		bs=(Button)findViewById(R.id.button3);
	
		br.setOnClickListener(this);
		bp.setOnClickListener(this);
		bs.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		
		Random r=new Random();
		int x=r.nextInt(3 - 0)+0;
		//String str= String.valueOf(x);
		//tshow.setText(str);
		
		switch(x){
		
		case 0: tshow.setText("ROCK");
			switch(arg0.getId()){
			case R.id.button1: break;
			case R.id.button2: ps++; break;
			case R.id.button3: cs++; break;
			} break;
			
		case 1: tshow.setText("PAPER");
			switch(arg0.getId()){
			case R.id.button1: cs++; break;
			case R.id.button2: break;
			case R.id.button3: ps++; break;
			} break;
			
		case 2: tshow.setText("SCISSORS");
			switch(arg0.getId()){
			case R.id.button1: ps++; break;
			case R.id.button2: cs++; break;
			case R.id.button3: break;
			} break;
		}
		
		tscore.setText("You:"+ps+"  Computer:"+cs);
		if(ps==5){tscore.setText("You WIN!!");ps=0;cs=0;
		
		Intent achi=new Intent(this,ScoreScreen.class);
		Bundle sendwin=new Bundle();
		sendwin.putInt("vinny", 1);
		achi.putExtras(sendwin);
		startActivity(achi);
		}
		if(cs==5){losses++; tscore.setText("Your LOSING STREAK is "+losses);ps=0;cs=0;}
	}

}
