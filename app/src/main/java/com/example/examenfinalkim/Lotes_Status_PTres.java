package com.example.examenfinalkim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.examenfinalkim.Database.AppDatabase;
import com.example.examenfinalkim.Entidades.Lote;

import java.util.List;

public class Lotes_Status_PTres extends AppCompatActivity {

    AppDatabase db;
    private List<Lote> loteList; //llenar con la info de la bd
    ListView lvLotee; //variable de vinculacion de xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotes__status__p_tres);

        //__________________________obteniendo los datos de la tabla
       // loteList = db.loteDao().getAllLotes(); //AQUI***
        //____________________________vinculo
        //lvLotee = (ListView)findViewById(R.id.listadepotreroos);

        //AdapterLote adapterLote = new AdapterLote(this);
        //lvLotee.setAdapter(adapterLote);
    }
/*
    class AdapterLote extends ArrayAdapter<Lote> {

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
    }*/
}
