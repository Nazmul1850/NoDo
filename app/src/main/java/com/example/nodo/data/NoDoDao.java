package com.example.nodo.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.nodo.model.NoDo;

import java.util.List;

@Dao
public interface NoDoDao {
    @Insert
    void insert(NoDo nodo);

    @Query("DELETE FROM nodo_table")
    void deleteAll();

    @Query("DELETE FROM nodo_table WHERE id = :id")
    int deleteANodo(int id);

    @Query("UPDATE nodo_table SET nodo_col = :nodo_text WHERE id = :id")
    int updateNodoItem(int id, String nodo_text);

    @Query("SELECT * FROM nodo_table ORDER BY nodo_col DESC")
    LiveData<List<NoDo>> getAllItems();

}
