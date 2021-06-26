package com.example.coroutinsapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var itemName: String?,
    @ColumnInfo(name = "quantity")
    var quantity: Int?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}