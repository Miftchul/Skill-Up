package com.agus_221111031.skillup.ui.karier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agus_221111031.skillup.R
import com.agus_221111031.skillup.data.job.provider.DummyJobProvider
import com.agus_221111031.skillup.data.job.repository.JobRepository
import kotlinx.coroutines.launch

class KarierFragment : Fragment() {

//    INI JUGA SAMA DIBAWAH INTEGRASINYA TINGGAL MENYESESUAIKAN TRACK
    private val jobsByInterest = listOf(
        "Python Developer - Remote",
        "UI/UX Designer - Jakarta",
        "Data Analyst - Bandung"
    )

//    TES AJA
//    private val latestJobs = listOf(
//        "Frontend Developer - Surabaya",
//        "Customer Support - Remote",
//        "Product Manager - Yogyakarta",
//        "Marketing Specialist - Jakarta"
//    )

//    INI INTEGRASINYA
    val jobRepo = JobRepository(
        listOf(
            DummyJobProvider(),
            // LinkedInJobProvider(),
            // GoogleJobProvider(),
            // MicrosoftJobProvider()
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_karier, container, false)

        val rvInterest = view.findViewById<RecyclerView>(R.id.recyclerInterest)
        val rvLatest = view.findViewById<RecyclerView>(R.id.recyclerLatest)

        rvInterest.layoutManager = LinearLayoutManager(requireContext())
        rvLatest.layoutManager = LinearLayoutManager(requireContext())

        rvInterest.adapter = KarierAdapter(jobsByInterest)
        
        // Mengambil data pekerjaan dari JobRepository dan menampilkannya
        lifecycleScope.launch {
            val latestJobsFromRepo = jobRepo.fetchJobs().map { job ->
                "${job.title} - ${job.company} - ${job.location}"
            }
            rvLatest.adapter = KarierAdapter(latestJobsFromRepo)
        }

        return view
    }
}
