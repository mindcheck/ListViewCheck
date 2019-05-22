package com.example.jonnyb.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.jonnyb.coderswag.Adapters.ProductTypeRecyleAdapter
import com.example.jonnyb.coderswag.R
import com.example.jonnyb.coderswag.Services.DataService
import com.example.jonnyb.coderswag.Utilities.EXTRA_CATEGORY
import com.example.jonnyb.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType = intent?.extras?.getString(EXTRA_CATEGORY) as String

        val proAdapter = ProductTypeRecyleAdapter(this,DataService.getProducts(categoryType)){
            val productIntent = Intent(this, ProductDetailActivity::class.java)
            productIntent.putExtra(EXTRA_PRODUCT, it)
            startActivity(productIntent)
        }
        productsListView.adapter = proAdapter

        val gridLayoutManager = GridLayoutManager(this,2)
        productsListView.layoutManager = gridLayoutManager
        productsListView.setHasFixedSize(true)


    }
}
