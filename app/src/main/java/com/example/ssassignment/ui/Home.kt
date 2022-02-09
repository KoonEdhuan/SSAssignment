package com.example.ssassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ssassignment.R
import com.example.ssassignment.adapter.MainAdapter
import com.example.ssassignment.databinding.ActivityHomeBinding
import com.example.ssassignment.viewmodel.MainViewModel

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var mainAdapter: MainAdapter


    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this,
        R.anim.rotate_open
    )}
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this,
        R.anim.rotate_close
    )}
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this,
        R.anim.from_bottom
    )}
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom)}

    private lateinit var viewModel: MainViewModel

    private var clicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

        binding.fabAdd.setOnClickListener {
            onFABClicked()
        }
        binding.fabProduct.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }
        binding.fabCategory.setOnClickListener {
            Toast.makeText(this,"category btn clicked",Toast.LENGTH_SHORT).show()
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.allProductDetails.observe(this, Observer {
            mainAdapter.setData(it)
        })

    }

    private fun setUpRecyclerView() = binding.recyclerView.apply {
        mainAdapter = MainAdapter()
        adapter = mainAdapter
        layoutManager = LinearLayoutManager(this@Home)
    }

    private fun onFABClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            binding.fabProduct.startAnimation(fromBottom)
            binding.fabCategory.startAnimation(fromBottom)
            binding.fabAdd.startAnimation(rotateOpen)
        }else{
            binding.fabCategory.startAnimation(toBottom)
            binding.fabProduct.startAnimation(toBottom)
            binding.fabAdd.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked){
            binding.fabProduct.visibility = View.VISIBLE
            binding.fabCategory.visibility = View.VISIBLE
        }else{
            binding.fabProduct.visibility = View.GONE
            binding.fabCategory.visibility = View.GONE
        }
    }

    private fun setClickable(clicked: Boolean){
        if (!clicked){
            binding.fabProduct.isClickable = true
            binding.fabCategory.isClickable = true
        }
        else{
            binding.fabProduct.isClickable = false
            binding.fabCategory.isClickable = false
        }
    }
}