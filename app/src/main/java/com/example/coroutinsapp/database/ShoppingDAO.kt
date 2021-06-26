package com.example.coroutinsapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coroutinsapp.database.entities.ShoppingItem

@Dao
interface ShoppingDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete
    fun delete(item: ShoppingItem)

    @Update
    fun update(item: ShoppingItem)

    @Query("SELECT * FROM shopping_table")
    fun getAllItems() : LiveData<List<ShoppingItem>>
}