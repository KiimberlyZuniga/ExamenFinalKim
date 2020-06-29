package com.example.examenfinalkim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;

import com.example.examenfinalkim.Database.AppDatabase;
import com.example.examenfinalkim.Entidades.Lote;

import java.util.ArrayList;
import java.util.List;

public class Lotes_Status_PTres extends AppCompatActivity {

    //AppDatabase objApp;
   // Lotes_Settings_PDos objMyDataBaseClass;

    //AppDatabase db;
    //private List<Lote> loteList; //llenar con la info de la bd
    RecyclerView recyclerView; //variable de vinculacion de xml
    RecyclerView.Adapter adapter;
    ArrayList<Lote> lotes;



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
        recyclerView=findViewById(R.id.RVdepotreroos);

//        lotes = new ArrayList<Lote>();
  //      for (int i=0; i< 100; i++){
    //        Lote lote = new Lote("Lote en recuperacion", "254", "52" , "videeo", "foto");
      //      lotes.add(lote);
        //}
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "lots")
                .allowMainThreadQueries()

                .build();

        List<Lote> lotes = db.loteDao().getAllLotes();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(lotes);
        recyclerView.setAdapter(adapter);
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


  /*  public void showValuesFromDatabase(View view){
        try {
            SQLiteDatabase objSqLiteDatabase = objMyDataBaseClass.getReadableDatabase();
            if (objSqLiteDatabase!=null){
                Cursor objCursor=objSqLiteDatabase.rawQuery("select * from lote", null);
                StringBuffer objStringBuffer = new StringBuffer();
                if (objCursor.getCount()==0){
                    Toast.makeText(this, "No data is returned", Toast.LENGTH_SHORT).show();
                }else {
                    while (objCursor.moveToNext()){
                        objStringBuffer.append("Nombre:-"+objCursor.getString(1)+"\n");
                        objStringBuffer.append("Medida:-"+objCursor.getString(2)+"\n");
                        objStringBuffer.append("Fecha:-"+objCursor.getString(3)+"\n");
                    }
                }
            }else {
                Toast.makeText(this, "Dtabase is null..", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "showValuesFromDb:" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }*/
}
