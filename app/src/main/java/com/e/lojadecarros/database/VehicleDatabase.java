package com.e.lojadecarros.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.e.lojadecarros.model.VehicleGeneral;

@Database(entities = {VehicleGeneral.class}, version  = 1)
public abstract class VehicleDatabase extends RoomDatabase {

    private static final String DATABASE = "DATABASE";

    private static volatile VehicleDatabase INSTANCE;

    public abstract VehicleDao vehicleDao();

    public static VehicleDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (VehicleDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            VehicleDatabase.class,
                            DATABASE)
                                .allowMainThreadQueries()
                                .fallbackToDestructiveMigration()
                                .addCallback(sRoomDatabaseCallback)
                                .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback = new Callback(){

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
}
