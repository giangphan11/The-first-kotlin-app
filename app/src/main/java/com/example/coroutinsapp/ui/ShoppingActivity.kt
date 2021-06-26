package com.example.coroutinsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinsapp.adapter.ShoppingAdapter
import com.example.coroutinsapp.database.ShoppingDatabase
import com.example.coroutinsapp.database.entities.ShoppingItem
import com.example.coroutinsapp.databinding.ActivityShoppingBinding
import com.example.coroutinsapp.model.ShoppingViewModel
import com.example.coroutinsapp.model.ShoppingViewModelFactory
import com.example.coroutinsapp.repo.ShoppingRepo
import kotlin.text.StringBuilder

class ShoppingActivity : AppCompatActivity() {
    lateinit var binding: ActivityShoppingBinding
    lateinit var adapter: ShoppingAdapter
    lateinit var viewModel: ShoppingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        val db = ShoppingDatabase(applicationContext)
        val repo = ShoppingRepo(db)
        val factory = ShoppingViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)
        viewModel.getAllItem().observe(this, Observer {
            adapter.addData(it)
        })
        addEvents()
    }

    private fun initRecyclerView() {
        adapter = ShoppingAdapter(this)
        binding.rcvShopping.let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            it.adapter = adapter
        }
    }

    private fun addEvents() {
        binding.btnAdd.setOnClickListener {
            viewModel.insert(ShoppingItem(binding.etName.text.toString(), binding.etQuantity.text.toString().toInt()))
        }
    }
}