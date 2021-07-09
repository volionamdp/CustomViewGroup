package com.example.customviewgroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewgroup.adapter.ControlAdapter
import com.skydoves.transformationlayout.TransformationLayout

class MainActivity : AppCompatActivity() {
    private var current:TransformationLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv : RecyclerView = findViewById(R.id.rvTest)
        val view2 : LockScreenView = findViewById(R.id.test7)
        val adapter = ControlAdapter(){ _: String, _:Int->

        }
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
        adapter.submitList(mutableListOf("a","bb","c","d","a","bb","c","d","a","bb","c","d") as List<Any>?)
        adapter.listener = {
            Log.d("zzzzt", "onScrolled: 0000")

            if (it is TransformationLayout){
                Log.d("zzzzt", "onScrolled: 1111")

                current = it
                it.bindTargetView(view2)
                it.startTransform()
            }
        }
        view2.setListener {
            current?.finishTransform()
        }
        rv.addOnScrollListener(object : RecyclerView.OnScrollListener(){

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if( !recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                    Log.d("zzzzt", "onScrolled: end")
                }
                if( !recyclerView.canScrollVertically(RecyclerView.FOCUS_UP)) {
                    Log.d("zzzzt", "onScrolled: start")
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
}