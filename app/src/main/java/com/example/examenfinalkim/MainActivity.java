package com.example.examenfinalkim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examenfinalkim.Config.Constantes;
import com.example.examenfinalkim.Database.AppDatabase;
import com.example.examenfinalkim.Entidades.Lote;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton flotanteAdd;
    FloatingActionButton flotanteSee;

    AppDatabase db;
    private List<Lote> loteList; //llenar con la info de la bd
    ListView lvLote; //variable de vinculacion de xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //msj que muestra cant de registros
        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, Constantes.BD_NAME)
                .allowMainThreadQueries()
                .build();
        //obteniendo los datos de la tabla
        loteList = db.loteDao().getAllLotes();
        //vinculo
        lvLote = (ListView)findViewById(R.id.ListViewPotreros);

        AdapterLote adapterLote = new AdapterLote(this);
        lvLote.setAdapter(adapterLote);

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

    //Subclase
    class AdapterLote extends ArrayAdapter<Lote>{

        AppCompatActivity appCompatActivity;

        public AdapterLote(AppCompatActivity context){
            super(context, R.layout.item_lote, loteList);
            appCompatActivity = context;
        }

        public View getView(int position, View conveterView, ViewGroup parent){
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.item_lote, null);

            TextView txtlote = (TextView) item.findViewById(R.id.txtItemLote);

            String dato = loteList.get(position).getId()+ " - " + loteList.get(position).getNombrelote();

            txtlote.setText(dato);

            return item;
        }
    }
}
