package com.agus_221111031.skillup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        // Inisialisasi RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_explore)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Ambil courseList dari arguments
        val courseList = arguments?.getParcelableArrayList<Course>("courseList") ?: emptyList()

        // Atur adapter untuk RecyclerView
        recyclerView.adapter = CourseAdapter(requireContext(), courseList)

        return view
    }
}