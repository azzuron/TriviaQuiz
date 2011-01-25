package com.androidbook.triviaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class QuizMenuActivity extends QuizActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        String[] mnuItems = { getResources().getString(R.string.mnuPlay), 
        					  getResources().getString(R.string.mnuScores),
        					  getResources().getString(R.string.mnuSettings),
        					  getResources().getString(R.string.mnuHelp) 
        					};
        
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, mnuItems);
        ListView mnuList = (ListView)findViewById(R.id.ListView_Menu);
        mnuList.setAdapter(adapt);
        mnuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
        		TextView textView = (TextView) itemClicked;
        		String strText = textView.getText().toString();
        		if(strText.equalsIgnoreCase(getResources().getString(R.string.mnuPlay))) {
        			startActivity(new Intent(QuizMenuActivity.this, QuizGameActivity.class));
        		} else if(strText.equalsIgnoreCase(getResources().getString(R.string.mnuScores))) {
        			startActivity(new Intent(QuizMenuActivity.this, QuizScoresActivity.class));
        		} else if(strText.equalsIgnoreCase(getResources().getString(R.string.mnuSettings))) {
        			startActivity(new Intent(QuizMenuActivity.this, QuizSettingsActivity.class));
        		} else if(strText.equalsIgnoreCase(getResources().getString(R.string.mnuHelp))) {
        			startActivity(new Intent(QuizMenuActivity.this, QuizHelpActivity.class));
        		}
        	}
		});
        
    }
}