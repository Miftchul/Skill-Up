package com.agus_221111031.skillup.ui.pelajari

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agus_221111031.skillup.R
import com.agus_221111031.skillup.data.model.Course
import com.agus_221111031.skillup.ui.pelajari.PelajariCourseAdapter

class PelajariFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext()
        val prefs = context.getSharedPreferences("pelajari_prefs", Context.MODE_PRIVATE)
        // Simulate that Python course has been started for testing
        prefs.edit().putBoolean("python_started", true).apply()
        val sudahMulai = prefs.getBoolean("python_started", false)

        val root = inflater.inflate(R.layout.fragment_pelajari, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.pelajariRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        if (sudahMulai) {
            val pythonCourse = Course(
                name = "Bahasa Inggris untuk Interaksi Umum di Tempat Kerja: Tingkat Dasar",
                description = "Kursus ini membantu kamu mengembangkan skill dasar komunikasi di tempat kerja.",
                materials = "Video, Modul, Quiz",
                platform = "Pontificia Universidad Católica de Chile",
                level = "Dasar",
                duration = "4 Minggu",
                certificate = true,
                content = "Konten kursus Bahasa Inggris"
            )
            recyclerView.adapter = PelajariCourseAdapter(context, listOf(pythonCourse))
            recyclerView.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.GONE
            val infoView = TextView(context)
            infoView.text = "Belum ada yang dipelajari"
            infoView.textSize = 16f
            infoView.textAlignment = View.TEXT_ALIGNMENT_CENTER
            val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            infoView.layoutParams = params
            (root as ViewGroup).addView(infoView)
        }
        return root
    }
}