package com.example.examenfinalkim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton flotanteAdd;
    FloatingActionButton flotanteSee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flotanteAdd = (FloatingActionButton) findViewById(R.id.addPasto);
        flotanteSee = (FloatingActionButton) findViewById(R.id.seePasto);

        flotanteAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siguienteActivity = new Intent(MainActivity.this, Lotes_Settings_PDos.class);
                startActivity(siguienteActivity);
            }
        });
        flotanteSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sigActivityStatus = new Intent(MainActivity.this, Lotes_Status_PTres.class);
                startActivity(sigActivityStatus);
            }
        });
    }
}
