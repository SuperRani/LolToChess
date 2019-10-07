package com.example.loltochess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    private ImageButton championButton;
    private ImageButton synergyButton;
    private ImageButton communityButton;
    private ImageButton guideButton;
    private ImageButton itemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        championButton = (ImageButton)findViewById(R.id.championButton);
        synergyButton = (ImageButton)findViewById(R.id.synergyButton);
        communityButton = (ImageButton)findViewById(R.id.communityButton);
        guideButton = (ImageButton)findViewById(R.id.guideButton);
        itemButton = (ImageButton)findViewById(R.id.itemButton);

        championButton.setOnClickListener(this);
        synergyButton.setOnClickListener(this);
        communityButton.setOnClickListener(this);
        guideButton.setOnClickListener(this);
        itemButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.championButton:
                break;
            case R.id.synergyButton:{
                Intent is = new Intent(this, SynergyActivity.class);
                startActivity(is);
                break;
            }

            case R.id.communityButton:
                break;
            case R.id.guideButton:
                break;
            case R.id.itemButton:{
                Intent i = new Intent(this, ItemListActivity.class);
                startActivity(i);
                break;
            }
        }

    }

}
