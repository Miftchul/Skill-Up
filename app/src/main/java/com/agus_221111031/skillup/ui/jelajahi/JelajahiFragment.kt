package com.agus_221111031.skillup.ui.jelajahi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agus_221111031.skillup.R
import com.agus_221111031.skillup.ui.detail.DetailActivity

class JelajahiFragment : Fragment() {

    private val categoryList = listOf(
        "Pemrograman",
        "Desain UI/UX",
        "Public Speaking",
        "Manajemen Proyek",
        "Excel & Data Entry"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_jelajahi, container, false)

        val headline = view.findViewById<TextView>(R.id.textJelajahiHeadline)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewJelajahi)

        headline.text = "Kategori Populer"
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = JelajahiAdapter(categoryList) { selected ->
            // Arahkan ke DetailActivity (untuk sementara)
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("name", selected)
            intent.putExtra("description", "Kursus kategori: $selected")
            intent.putExtra("materials", "• Materi akan ditampilkan nanti")
            intent.putExtra("platform", "SkillUp")
            intent.putExtra("level", "All Level")
            intent.putExtra("duration", "1 Minggu")
            intent.putExtra("certificate", true)
            intent.putExtra("content", "Konten kategori $selected akan hadir segera.")
            startActivity(intent)
        }

        return view
    }
}
