package com.example.ssassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import com.example.ssassignment.databinding.ActivityAddProductBinding
import com.example.ssassignment.db.product.Product
import com.example.ssassignment.viewmodel.MainViewModel

class AddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProductBinding
    private val viewModel: MainViewModel by this.viewModels()
    //private val viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.btnSubmit.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val productName = binding.etProductName.text.toString()
        val categoryName = binding.etCategoryName.text.toString()
        val productImage = null
        val quantity = Integer.parseInt(binding.etQuantity.text.toString())
        val price = binding.etPrice.text.toString().toInt()

        if (inputCheck(productName,categoryName,quantity.toString(),price.toString())){
            //create product object
            val product = Product(productName,categoryName,quantity,price)
            viewModel.addProduct(product)
            Toast.makeText(this,"Successfully added!",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Home::class.java))
        }
        else{
            Toast.makeText(this,"Enter data correctly",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(productName: String, categoryName: String, quantity: String, price: String): Boolean{
        return !(TextUtils.isEmpty(productName) && TextUtils.isEmpty(categoryName)
                && TextUtils.isEmpty(quantity) && TextUtils.isEmpty(price))
    }
}