package com.example.manasatpc.haji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    Button bt_sos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        bt_sos = (Button)findViewById(R.id.bt_sos);
        bt_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(MainScreen.this,MapsActivity.class);
                startActivity(newActivity);
            }
        });
    }
}
