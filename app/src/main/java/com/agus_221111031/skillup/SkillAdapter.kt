package com.agus_221111031.skillup

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter(
    private val context: Context,
    private val courses: List<Course>
) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.skillName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_skill, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courses[position]
        holder.nameTextView.text = course.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("name", course.name)
                putExtra("description", course.description)
                putExtra("materials", course.materials)
                putExtra("platform", course.platform)
                putExtra("level", course.level)
                putExtra("duration", course.duration)
                putExtra("certificate", course.certificate)
                putExtra("content", course.content)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = courses.size
}