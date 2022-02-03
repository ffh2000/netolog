package com.example.myapplication.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.network.DataResponse

class TasksAdapter(val tasks: List<DataResponse>) : RecyclerView.Adapter<TasksAdapter.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = tasks.size

}
