package com.example.groceryapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        //1 adapterView : RecycleView
        val  recycleView: RecyclerView =findViewById(R.id.recyclerView)
        recycleView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        //2-Data Source
        var groceryItem:ArrayList<ItemModel> = ArrayList()
        val item1 =   ItemModel(R.drawable.fruit, "Fruits","Fresh Fruits from the Garden");
        val item2 =   ItemModel(R.drawable.vegitables, "Vegetables","Delicious Vegetables ");
        val item3 =   ItemModel(R.drawable.bread,"Bakery","Bread, Wheat and Beans");
        val item4 =   ItemModel(R.drawable.beverage, "Beverage","Juice, Tea, Coffee and Soda");
        val item5 =   ItemModel(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt");
        val item6 =   ItemModel(R.drawable.popcorn,"Snacks","Pop Corn, Donut and Drinks");


        groceryItem.add(item1);
        groceryItem.add(item2);
        groceryItem.add(item3);
        groceryItem.add(item4);
        groceryItem.add(item5);
        groceryItem.add(item6);

        //3 -Adapter
        val adapter = MyAdapter(groceryItem)
        recycleView.adapter = adapter


    }
}