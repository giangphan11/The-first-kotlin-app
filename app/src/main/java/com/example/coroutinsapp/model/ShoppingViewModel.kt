package com.example.coroutinsapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coroutinsapp.database.entities.ShoppingItem
import com.example.coroutinsapp.repo.ShoppingRepo
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class ShoppingViewModel(private var repo: ShoppingRepo) : ViewModel() {
    fun getAllItem() =  repo.getAllItems()

    fun insert(item:ShoppingItem) {
        CoroutineScope(IO).launch {
            repo.insert(item)
        }
    }
}