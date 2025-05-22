package com.agus_221111031.skillup.ui.karier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.agus_221111031.skillup.R

class KarierAdapter(private val jobs: List<String>) :
    RecyclerView.Adapter<KarierAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobTitle: TextView = itemView.findViewById(R.id.textItemKarier)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_karier, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.jobTitle.text = jobs[position]
    }

    override fun getItemCount(): Int = jobs.size
}

