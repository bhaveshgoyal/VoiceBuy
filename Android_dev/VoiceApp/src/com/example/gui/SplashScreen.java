package com.example.gui;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.widget.TextView;
 
public class SplashScreen extends Activity {
	TextToSpeech ttobj;
	 private final int SPLASH_DISPLAY_LENGTH = 3500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.activity_splashscreen);

        ttobj=new TextToSpeech(getApplicationContext(), 
      	      new TextToSpeech.OnInitListener() {
      	      @Override
      	      public void onInit(int status) {
      	         if(status != TextToSpeech.ERROR){
      	             ttobj.setLanguage(Locale.UK);
      	            }				
      	         }
      	      });
  	  
        TextView text = (TextView) findViewById(R.id.appname);
        TextView text2 = (TextView) findViewById(R.id.smart);
        TextView text3 = (TextView) findViewById(R.id.copyright);

        TextView text4 = (TextView) findViewById(R.id.rights);
        Typeface font = Typeface.createFromAsset(getAssets(), "myriadpro.otf");
    	text.setTypeface(font);
    	text2.setTypeface(font);
    	text3.setTypeface(font);
    	text4.setTypeface(font);

    	  new Handler().postDelayed(new Runnable(){
              @Override
              public void run() {
                  /* Create an Intent that will start the Menu-Activity. */
                  Intent mainIntent = new Intent(SplashScreen.this,MainActivity.class);
                  SplashScreen.this.startActivity(mainIntent);
                  SplashScreen.this.finish();
              }
          }, SPLASH_DISPLAY_LENGTH);

    }
     @Override 
     public boolean onCreateOptionsMenu(Menu menu) {

    	 ttobj.speak("Welcome to Voice Buy, the smarter way of online shopping.", TextToSpeech.QUEUE_FLUSH, null);


    	 return true;
     }
    @Override
    protected void onDestroy() {
         
        super.onDestroy();
         
    }
}