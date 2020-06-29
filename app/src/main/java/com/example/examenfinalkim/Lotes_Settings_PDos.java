package com.example.examenfinalkim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.examenfinalkim.Config.Constantes;
import com.example.examenfinalkim.Database.AppDatabase;
import com.example.examenfinalkim.Entidades.Lote;

public class Lotes_Settings_PDos extends AppCompatActivity {
    EditText nomLote;
    EditText medidaLote;
    DatePicker fechaLote;
    ImageView imagenlote;
    Button botonGuardarAct;

   //Crear variable que se conecte con la BD
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotes__settings__p_dos);
        nomLote = (EditText) findViewById(R.id.nombrelote);
        medidaLote = (EditText) findViewById(R.id.medidaslote);
        fechaLote = (DatePicker) findViewById(R.id.datepickerrlote);
        imagenlote = (ImageView) findViewById(R.id.imagevieww);
        botonGuardarAct = (Button) findViewById(R.id.botonguardaryact);

        //instanciar la bd o llamar a la bd
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, Constantes.BD_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public void Guardarlote(View view) {
        Lote obj = new Lote("Lote en recuperacion", "254", "52", "video", "foto");
        obj.setNombrelote(nomLote.getText().toString());
        obj.setMedidalote(medidaLote.toString());
        obj.setFechalote(fechaLote);
        obj.setFotolote(imagenlote);


        //INSERTAR EN LA BD
        long resultado = db.loteDao().insert(obj);
        if (resultado > 0){
            startActivity(new Intent(Lotes_Settings_PDos.this, MainActivity.class));
            startActivity(new Intent(Lotes_Settings_PDos.this, Lotes_Status_PTres.class));
        }else {

        }
    }
}
