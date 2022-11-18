package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val products = ArrayList<Product>()

        products.add(Product("Camera", 200.00, "Red", "camera", "Cam:001", "A very good camera made my Japan"))

        products.add(Product("Camera", 200.00, "Red", "camera", "Cam:001", "A very good camera made my Japan"))
        products.add(Product("Camera", 200.00, "Red", "camera", "Cam:001", "A very good camera made my Japan"))
        products.add(Product("Camera", 200.00, "Red", "camera", "Cam:001", "A very good camera made my Japan"))

        val myAdapter=MyAdapter(products)

        myRv.adapter=myAdapter

        myRv.layoutManager=LinearLayoutManager(this)


    }
}