package com.example.coroutinsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinsapp.R
import com.example.coroutinsapp.database.entities.ShoppingItem
import com.example.coroutinsapp.databinding.ItemShoppingBinding

class ShoppingAdapter(private val context: Context) : RecyclerView.Adapter<ShoppingAdapter.MyHolder>() {
    private var listShopping = mutableListOf<ShoppingItem>()
    lateinit var binding: ItemShoppingBinding

    var viewSelected :View? = null
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            binding = ItemShoppingBinding.bind(itemView)
            itemView.setOnClickListener {
                if(viewSelected != null){
                    viewSelected!!.background  = ContextCompat.getDrawable(context, R.drawable.bg_item_selected)
                }
                itemView.background  = ContextCompat.getDrawable(context, R.drawable.bg_item_selected)
                viewSelected = itemView
            }
        }
    }

    fun addData(data: List<ShoppingItem>){
        listShopping.clear()
        listShopping.addAll(data)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view =  LayoutInflater.from(parent.context!!).inflate(R.layout.item_shopping, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listShopping.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        binding.root.background = ContextCompat.getDrawable(context, R.drawable.bg_item)
        val item = listShopping[position]
        holder.itemView.tag = item
        binding.tvItem.text = "${item.itemName} - ${item.quantity}"
    }
}