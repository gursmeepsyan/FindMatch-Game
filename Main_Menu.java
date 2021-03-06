/**
 * Activity for main menu screen
 */

package com.example.finddamatch.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.finddamatch.Classes.Deck;
import com.example.finddamatch.R;

import static com.example.finddamatch.MainActivity.Deck;
import static com.example.finddamatch.MainActivity.bitmaps;
import static com.example.finddamatch.MainActivity.length;
import static com.example.finddamatch.MainActivity.mode;
import static com.example.finddamatch.MainActivity.option;
import static com.example.finddamatch.MainActivity.order;

public class Main_Menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);

        // Button on click takes the user to Help Screen
        Button HelpButton = (Button) findViewById(R.id.helpButton);
        HelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HelpScreen = Help_Screen.makeLaunchIntent(Main_Menu.this);
                startActivity(HelpScreen);
            }
        });

        // Button on click takes the user to the Options Screen
        Button OptionButton = (Button) findViewById(R.id.optionsButton);
        OptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OptionScreen = Options_Screen.makeLaunchIntent(Main_Menu.this);
                startActivity(OptionScreen);
            }
        });

        // Button on click takes the user to Play Screen
        Button PlayButton = (Button) findViewById(R.id.playButton);
        PlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer playGame = MediaPlayer.create(Main_Menu.this,R.raw.playgame);
                playGame.start();
                if(option==3)
                {
                    if(bitmaps.isEmpty())
                    {
                        option=1;
                    }
                    if(order==2)
                    {
                        if(bitmaps.size()<6)
                        {
                            option =1;
                            length=7;
                            Toast.makeText(getApplicationContext(), "Lack of image selected for the flickr Image, change to nature theme", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if(order==3)
                    {
                        if(bitmaps.size()<13)
                        {
                            option =1;
                            length=13;
                            Toast.makeText(getApplicationContext(), "Lack of image selected for the flickr Image, change to nature theme", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else if(order==5)
                    {
                        if(bitmaps.size()<31)
                        {
                            option =1;
                            length=15;
                            Toast.makeText(getApplicationContext(), "Lack of image selected for the flickr Image, change to nature theme", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (mode ==2)
                    {

                            option =1;
                        Toast.makeText(getApplicationContext(), "This mode not available for selected option", Toast.LENGTH_SHORT).show();

                    }

                }
                Deck = new Deck();
                Deck.startGame();//creates a new deck and shuffle draw and discard
                Intent PlayScreen = Game_Activity.makeLaunchIntent(Main_Menu.this);
                startActivity(PlayScreen);
            }

        });

        // Button on click takes the user to Play Screen
        Button HighButton=(Button) findViewById(R.id.high);
        HighButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HighScreen = High_Score.makeLaunchIntent(Main_Menu.this);
                startActivity(HighScreen);
            }

        });

    Button saveBtn=(Button) findViewById(R.id.saveImg);
        saveBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(option==3)
            {
                if(bitmaps.isEmpty())
                {
                    option=1;
                }
                if(order==2)
                {
                    if(bitmaps.size()<6)
                    {
                        option =1;
                        length=7;
                        Toast.makeText(getApplicationContext(), "Lack of image selected for the flickr Image, change to nature theme", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(order==3)
                {
                    if(bitmaps.size()<13)
                    {
                        option =1;
                        length=13;
                        Toast.makeText(getApplicationContext(), "Lack of image selected for the flickr Image, change to nature theme", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(order==5)
                {
                    if(bitmaps.size()<31)
                    {
                        option =1;
                        length=15;
                        Toast.makeText(getApplicationContext(), "Lack of image selected for the flickr Image, change to nature theme", Toast.LENGTH_SHORT).show();
                    }
                }
                if (mode ==2)
                {

                    option =1;
                    Toast.makeText(getApplicationContext(), "This mode not available for selected option", Toast.LENGTH_SHORT).show();

                }

            }
            Deck = new Deck();
            Deck.startGame();
            Intent intent = saveCardActivity.makeLaunchIntent(Main_Menu.this);
            Toast.makeText(getApplicationContext(), "Click to save image", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

    });
}

    // Intent function
    public static Intent makeLaunchIntent(Context c){
        Intent intent = new Intent(c, Main_Menu.class);
        return intent;
    }
}