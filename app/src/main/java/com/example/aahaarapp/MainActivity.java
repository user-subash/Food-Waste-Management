package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    CardView donate, receive, logout, foodmap, about, contact, mypin, history;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donate = findViewById(R.id.cardDonate);
        receive = findViewById(R.id.cardReceive);
        logout = findViewById(R.id.cardLogout);

        fAuth= FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser() ==null){
            Intent intent = new Intent(MainActivity.this, landingpage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        donate.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Donate.class);
                startActivity(intent);
            }
        });
        receive.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Receive.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, landingpage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}