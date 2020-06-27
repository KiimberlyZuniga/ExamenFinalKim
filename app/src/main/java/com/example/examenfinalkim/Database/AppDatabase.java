package com.example.examenfinalkim.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.examenfinalkim.Entidades.Lote;
import com.example.examenfinalkim.Interfaces.LoteDao;

@Database(entities = {Lote.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    @SuppressWarnings("WeakerAccess")
    public abstract LoteDao loteDao();

    private static AppDatabase sIntance;
}
