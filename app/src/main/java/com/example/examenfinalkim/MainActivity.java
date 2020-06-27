package com.example.examenfinalkim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.examenfinalkim.Config.Constantes;
import com.example.examenfinalkim.Database.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton flotanteAdd;
    FloatingActionButton flotanteSee;

    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //msj que muestra cant de registros
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, Constantes.BD_NAME)
                .allowMainThreadQueries()
                .build();
        int cantidade = db.loteDao().count();
        Toast.makeText(this, "Existen: "+cantidade+"de lotres registrados", Toast.LENGTH_SHORT).show();



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
