package com.example.examenfinalkim.Entidades;

import android.content.ContentValues;
import android.provider.BaseColumns;
import android.widget.DatePicker;
import android.widget.ImageView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = Lote.TABLE_NAME)
public class Lote {

    public static final String TABLE_NAME = "lote";
    public static final String COLUMN_NAME = "nombre";


    public static final String COLUMN_ID = BaseColumns._ID;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    public long id;

    @ColumnInfo(name = "nombrelote")
    private String nombrelote;
    @ColumnInfo(name = "medidalote")
    private String medidalote;
    @ColumnInfo(name = "fechalote")
    public int fechalote;
    @ColumnInfo(name = "videolote")
    private String videolote;
    @ColumnInfo(name = "fotolote")
    private String fotolote;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColumnName() {
        return COLUMN_NAME;
    }

    public static String getColumnId() {
        return COLUMN_ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombrelote() {
        return nombrelote;
    }

    public void setNombrelote(String nombrelote) {
        this.nombrelote = nombrelote;
    }

    public String getMedidalote() {
        return medidalote;
    }

    public void setMedidalote(String medidalote) {
        this.medidalote = medidalote;
    }

    public int getFechalote() {
        return fechalote;
    }

   //set fecha lote
    public String getVideolote() {
        return videolote;
    }

    public void setVideolote(String videolote) {
        this.videolote = videolote;
    }

    public String getFotolote() {
        return fotolote;
    }

    //set foto lote

    @Ignore
    public Lote(){}

    public Lote(long id, String nombrelote, String medidalote, int fechalote, String videolote, String fotolote) {
        this.id = id;
        this.nombrelote = nombrelote;
        this.medidalote = medidalote;
        this.fechalote = fechalote;
        this.videolote = videolote;
        this.fotolote = fotolote;
    }
    public static Lote fromContentValues(ContentValues values){
        final Lote obj = new Lote();
        if (values.containsKey(COLUMN_ID)){
            obj.id = values.getAsLong(COLUMN_ID);
        }
        if (values.containsKey(COLUMN_NAME)){
            obj.setId(1);
        }
        return obj;
    }

    public void setFechalote(DatePicker fechaLote) {
    }

    public void setFotolote(ImageView imagenlote) {
    }
}
