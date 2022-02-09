package com.example.ssassignment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ssassignment.R
import com.example.ssassignment.ui.MainActivity
import com.example.ssassignment.databinding.ItemLayoutBinding
import com.example.ssassignment.db.product.Product
import com.example.ssassignment.ui.Payment

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    lateinit var binding: ItemLayoutBinding

    private var productList = emptyList<Product>()

    inner class MainViewHolder(itemView: ItemLayoutBinding): RecyclerView.ViewHolder(itemView.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        val currentItem = productList[position]

        holder.itemView.apply {
            binding.prodName.text = currentItem.productName
            binding.prodPrice.text = currentItem.price.toString()
            binding.prodImage.setBackgroundResource(R.drawable.ic_launcher_foreground)
            binding.btnBuy.setOnClickListener {
                val intent = Intent(context, Payment::class.java)
                intent.putExtra("productPrice",currentItem.price)
                intent.putExtra("productName",currentItem.productName)
                intent.putExtra("productId",currentItem.id)
                context.startActivity(intent)
            }

        }
    }

    fun setData(product: List<Product>){
        this.productList = product
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}