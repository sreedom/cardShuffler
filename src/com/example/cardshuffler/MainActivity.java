package com.example.cardshuffler;

import java.util.ArrayList;
import java.util.Collections;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	public ArrayList<String> cards;
	int burned;
	String drawn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cards = new ArrayList<String>();
		burned = 0;
		resetCards(null);
	}

	public void shuffleCards(View v) {
		// function to shuffle order of cards
		Collections.shuffle(cards);
	}
	
	public void draw(View v){
		if(!cards.isEmpty()){
			drawn = cards.get(0);
			TextView drawnCard = (TextView) findViewById(R.id.TextView03);
			drawnCard.setText(drawn);
			cards.remove(0);
		}
	}
	
	public void burn(View v){
		if(!cards.isEmpty()){
			drawn = cards.get(0);
			cards.remove(0);
			TextView noBurned = (TextView) findViewById(R.id.TextView02);
			burned++;
			noBurned.setText(String.valueOf(burned));
			
		}

	}

	public void resetCards(View v) {
		cards.clear();
		burned = 0;
		String[] values = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "Jack", "Queen", "King" };
		String[] suits = { " Spades", " Diamonds", " Clubs", "Hearts" };
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < values.length; j++)
				cards.add(values[j] + suits[i]);
		TextView noBurned = (TextView) findViewById(R.id.TextView02);
		noBurned.setText(String.valueOf(burned));
		drawn = "";
		TextView drawnCard = (TextView) findViewById(R.id.TextView03);
		drawnCard.setText(drawn);
		

		}
	}

}
