package com.example.coroutinsapp.repo

import androidx.lifecycle.LiveData
import com.example.coroutinsapp.database.ShoppingDatabase
import com.example.coroutinsapp.database.entities.ShoppingItem

class ShoppingRepo(
    private var db:ShoppingDatabase
) {
    suspend fun insert(item: ShoppingItem){
        db.shoppingDAO().insert(item)
    }

    fun getAllItems() : LiveData<List<ShoppingItem>>{
        return db.shoppingDAO().getAllItems()
    }
}