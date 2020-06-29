package com.example.examenfinalkim.Interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.examenfinalkim.Entidades.Lote;

import java.util.List;

@Dao
public interface LoteDao {
    //aqui se declara los metodos o acciones consultas para la bd
    //

    @Query("SELECT COUNT(*) FROM" + Lote.TABLE_NAME)
    int count();//metodo

    //seleccionatodo
    @Query("SELECT * FROM "+ Lote.TABLE_NAME)
    List<Lote> getAllLotes();

    @Insert
    void insertarAll(Lote... lotes);

    //ELIMINAR
    @Query("DELETE FROM "+ Lote.TABLE_NAME + " WHERE " + Lote.COLUMN_ID + " = :ide")
    int deleteById(long ide);

    @Update
    int updateEntidad(Lote obj);

    @Insert
    long insert(Lote lotes);
}
