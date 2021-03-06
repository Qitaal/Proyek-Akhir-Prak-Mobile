package com.upnyk.tenorapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = FavoriteGif.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FavoriteGifDAO favoriteGifDAO();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if (INSTANCE == null) {
            synchronized (AppDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "db").build();
                }
            }
        }
        return INSTANCE;
    }
}
