package com.example.jonnyb.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.jonnyb.coderswag.Adapters.CustomCategoryRecyleAdapter
import com.example.jonnyb.coderswag.Model.Category
import com.example.jonnyb.coderswag.R
import com.example.jonnyb.coderswag.Services.DataService
import com.example.jonnyb.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val check = {x:Int,y:Int->x+y}
//        val check :(Int,Int)->Int = {x,y->x+y}

//        fun dwon(check:Boolean,complete:(Category)->Unit){
//            complete
//        }


//        dwon(true,{
//            it.title
//        })
        categoryListView.adapter = CustomCategoryRecyleAdapter(this,DataService.categories){
            category->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        val linearL  = LinearLayoutManager(this)
        categoryListView.layoutManager = linearL
        categoryListView.setHasFixedSize(true)




    }
}
