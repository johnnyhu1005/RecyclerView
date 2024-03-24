package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var imageListRecyclerView: RecyclerView
    lateinit var dataList: ArrayList<ImageModel>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageList = arrayOf(
            R.drawable.ic_camera,
            R.drawable.ic_date,
            R.drawable.ic_checkbox,
            R.drawable.ic_edit,
            R.drawable.ic_image,
            R.drawable.ic_list,
            R.drawable.ic_rating,
            R.drawable.ic_text)

        titleList = arrayOf(
            "Camera",
            "Date",
            "CheckBox",
            "Edit",
            "Image",
            "List",
            "Rating",
            "Text")

        imageListRecyclerView = findViewById(R.id.recyclerView)
        imageListRecyclerView.layoutManager = LinearLayoutManager(this)
        imageListRecyclerView.setHasFixedSize(true)

        dataList = arrayListOf<ImageModel>()
        getData()
    }

    private fun getData(){
        for (i in imageList.indices){
            val imageModel = ImageModel(imageList[i], titleList[i])
            dataList.add(imageModel)
        }

        var adapter = MyAdapter(dataList)
        imageListRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                Toast.makeText(this@MainActivity, "You Clicked on "+titleList[position], Toast.LENGTH_SHORT).show()

            }
        })
    }
}