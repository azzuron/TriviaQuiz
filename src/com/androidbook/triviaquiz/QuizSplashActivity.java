package com.androidbook.triviaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class QuizSplashActivity extends QuizActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        TextView toplogo = (TextView) findViewById(R.id.TextViewTopTitle);
        Animation topFade = AnimationUtils.loadAnimation(this, R.anim.fade_in );
        toplogo.startAnimation(topFade);
        
        TextView bottomlogo = (TextView) findViewById(R.id.TextViewBottomTitle);
        Animation bottomFade = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        bottomFade.setAnimationListener(new AnimationListener() {
        	public void onAnimationEnd(Animation animation) {
        		startActivity(new Intent(QuizSplashActivity.this, QuizMenuActivity.class));
        		QuizSplashActivity.this.finish();
        	}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

        });
        bottomlogo.startAnimation(bottomFade);
        
        TextView version = (TextView) findViewById(R.id.TextViewBottomVersion);
        Animation versionFade = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        version.startAnimation(versionFade);
        
        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller = new LayoutAnimationController(spinin);
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
        
        for(int i = 0; i < table.getChildCount(); i++){
        	TableRow row = (TableRow)table.getChildAt(i);
        	row.setLayoutAnimation(controller);
        }
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		TextView toplogo = (TextView) findViewById(R.id.TextViewTopTitle);
		toplogo.clearAnimation();
		
		TextView bottomlogo = (TextView) findViewById(R.id.TextViewBottomTitle);
		bottomlogo.clearAnimation();
		
		TextView version = (TextView) findViewById(R.id.TextViewBottomVersion);
		version.clearAnimation();
		
		TableLayout table = (TableLayout)findViewById(R.id.TableLayout01);
		for(int i = 0; i < table.getChildCount(); i++){
			TableRow row = (TableRow)table.getChildAt(i);
			row.clearAnimation();		
		}
	}
}