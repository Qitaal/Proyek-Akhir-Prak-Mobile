package com.upnyk.tenorapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FavoriteGifDAO {

    @Insert
    void insert(FavoriteGif favoriteGif);

    @Delete
    void delete(FavoriteGif favoriteGif);

    @Query("SELECT * FROM favorite_gif WHERE id LIKE :id")
    boolean isFavoriteGIf(String id);

    @Query("SELECT * FROM favorite_gif")
    List<FavoriteGif> getFavoriteGif();
}
