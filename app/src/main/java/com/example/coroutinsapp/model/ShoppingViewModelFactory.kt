package com.example.coroutinsapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coroutinsapp.repo.ShoppingRepo

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private var repo: ShoppingRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repo) as T
    }
}