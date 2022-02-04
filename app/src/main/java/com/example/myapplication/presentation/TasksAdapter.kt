package com.example.myapplication.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.network.DataResponse
import com.example.myapplication.databinding.TaskItemBinding

class TasksAdapter(val tasks: List<DataResponse>) : RecyclerView.Adapter<TasksAdapter.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = TaskItemBinding.bind(view)

        fun bind(dataResponse: DataResponse, isLast: Boolean) {
            binding.apply {
                itemTitle.text = dataResponse.direction.title
                lastItemLine.visibility = if (isLast) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(tasks[position], position == getItemCount() - 1)
    }

    override fun getItemCount(): Int = tasks.size

}
