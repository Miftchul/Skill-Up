package com.agus_221111031.skillup.ui.cari

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agus_221111031.skillup.data.model.Course
import com.agus_221111031.skillup.R
import com.agus_221111031.skillup.ui.detail.DetailActivity

class CariFragment : Fragment() {

    private val courseList = listOf(
        //  Data Course (seperti yang sudah ada)
        Course(
            name = "Belajar Python Gratis - Coursera",
            description = "Kursus ini membantu kamu mengembangkan skill dasar Python untuk karir IT.",
            materials = "• Variabel dan Tipe Data\n• Perulangan\n• Fungsi Dasar\n• Mini Project Python",
            platform = "Coursera",
            level = "Beginner",
            duration = "4 Minggu",
            certificate = true,
            content = """
📚 Bab 1: Pengenalan Python
- Apa itu Python?
- Sejarah singkat dan perkembangan Python
- Kelebihan Python untuk pemula dan profesional

📚 Bab 2: Instalasi & Tools
- Install Python (Windows/Mac)
- IDE: VS Code, PyCharm, atau IDLE
- Menjalankan file Python pertama

📚 Bab 3: Dasar-Dasar Pemrograman
- Variabel dan Tipe Data (int, float, str, bool)
- Input & Output
- Operasi Aritmatika

📚 Bab 4: Percabangan dan Perulangan
- If-Else, Elif
- While dan For loop
- Nested loop dan penggunaan range()

📚 Bab 5: Fungsi & Modularisasi
- Membuat fungsi (def)
- Parameter & Return value
- Fungsi bawaan vs fungsi buatan

📚 Bab 6: Struktur Data
- List, Tuple, Dictionary, Set
- Operasi dasar, iterasi, manipulasi data

📚 Bab 7: Error Handling & File
- Try-Except block
- Membaca dan menulis file (.txt)

📚 Bab 8: Studi Kasus Mini Project
- Membuat Aplikasi To-Do List Sederhana di Terminal
- Fitur: Tambah tugas, tampilkan, hapus

🎓 Sertifikat:
Tersedia sertifikat gratis setelah menyelesaikan quiz akhir dan mini project!
""".trimIndent()

        ),
        //  Tambahkan lainnya...
        Course(
            name = "Belajar UI/UX - Google Course",
            description = "Kursus ini membantu kamu mengembangkan skill dasar Python untuk karir IT.",
            materials = "• Prinsip Desain UI\n• Wireframing\n• User Journey\n• Prototyping Dasar",
            platform = "Google Course",
            level = "Beginner",
            duration = "4 Minggu",
            certificate = true,
            content = """
📚 Bab 1: Pengenalan Python
- Apa itu Python?
- Sejarah singkat dan perkembangan Python
- Kelebihan Python untuk pemula dan profesional

📚 Bab 2: Instalasi & Tools
- Install Python (Windows/Mac)
- IDE: VS Code, PyCharm, atau IDLE
- Menjalankan file Python pertama

📚 Bab 3: Dasar-Dasar Pemrograman
- Variabel dan Tipe Data (int, float, str, bool)
- Input & Output
- Operasi Aritmatika

📚 Bab 4: Percabangan dan Perulangan
- If-Else, Elif
- While dan For loop
- Nested loop dan penggunaan range()

📚 Bab 5: Fungsi & Modularisasi
- Membuat fungsi (def)
- Parameter & Return value
- Fungsi bawaan vs fungsi buatan

📚 Bab 6: Struktur Data
- List, Tuple, Dictionary, Set
- Operasi dasar, iterasi, manipulasi data

📚 Bab 7: Error Handling & File
- Try-Except block
- Membaca dan menulis file (.txt)

📚 Bab 8: Studi Kasus Mini Project
- Membuat Aplikasi To-Do List Sederhana di Terminal
- Fitur: Tambah tugas, tampilkan, hapus

🎓 Sertifikat:
Tersedia sertifikat gratis setelah menyelesaikan quiz akhir dan mini project!
""".trimIndent()

        ),
        Course(
            name = "Kelas Public Speaking - Udemy",
            description = "Kursus ini membantu kamu mengembangkan skill dasar Python untuk karir IT.",
            materials = "• Teknik Vocal\n• Bahasa Tubuh\n• Menyusun Presentasi\n• Latihan Percaya Diri",
            platform = "Udemy",
            level = "Beginner",
            duration = "2 Minggu",
            certificate = true,
            content = """
📚 Bab 1: Pengenalan Python
- Apa itu Python?
- Sejarah singkat dan perkembangan Python
- Kelebihan Python untuk pemula dan profesional

📚 Bab 2: Instalasi & Tools
- Install Python (Windows/Mac)
- IDE: VS Code, PyCharm, atau IDLE
- Menjalankan file Python pertama

📚 Bab 3: Dasar-Dasar Pemrograman
- Variabel dan Tipe Data (int, float, str, bool)
- Input & Output
- Operasi Aritmatika

📚 Bab 4: Percabangan dan Perulangan
- If-Else, Elif
- While dan For loop
- Nested loop dan penggunaan range()

📚 Bab 5: Fungsi & Modularisasi
- Membuat fungsi (def)
- Parameter & Return value
- Fungsi bawaan vs fungsi buatan

📚 Bab 6: Struktur Data
- List, Tuple, Dictionary, Set
- Operasi dasar, iterasi, manipulasi data

📚 Bab 7: Error Handling & File
- Try-Except block
- Membaca dan menulis file (.txt)

📚 Bab 8: Studi Kasus Mini Project
- Membuat Aplikasi To-Do List Sederhana di Terminal
- Fitur: Tambah tugas, tampilkan, hapus

🎓 Sertifikat:
Tersedia sertifikat gratis setelah menyelesaikan quiz akhir dan mini project!
""".trimIndent()

        ),
        Course(
            name = "Basic Project Management - edX",
            description = "Kursus ini membantu kamu mengembangkan skill dasar Python untuk karir IT.",
            materials = "• Apa itu PM?\n• WBS dan Timeline\n• Stakeholder\n• Tools: Trello, Gantt",
            platform = "edX",
            level = "Beginner",
            duration = "2 Minggu",
            certificate = true,
            content = """
📚 Bab 1: Pengenalan Python
- Apa itu Python?
- Sejarah singkat dan perkembangan Python
- Kelebihan Python untuk pemula dan profesional

📚 Bab 2: Instalasi & Tools
- Install Python (Windows/Mac)
- IDE: VS Code, PyCharm, atau IDLE
- Menjalankan file Python pertama

📚 Bab 3: Dasar-Dasar Pemrograman
- Variabel dan Tipe Data (int, float, str, bool)
- Input & Output
- Operasi Aritmatika

📚 Bab 4: Percabangan dan Perulangan
- If-Else, Elif
- While dan For loop
- Nested loop dan penggunaan range()

📚 Bab 5: Fungsi & Modularisasi
- Membuat fungsi (def)
- Parameter & Return value
- Fungsi bawaan vs fungsi buatan

📚 Bab 6: Struktur Data
- List, Tuple, Dictionary, Set
- Operasi dasar, iterasi, manipulasi data

📚 Bab 7: Error Handling & File
- Try-Except block
- Membaca dan menulis file (.txt)

📚 Bab 8: Studi Kasus Mini Project
- Membuat Aplikasi To-Do List Sederhana di Terminal
- Fitur: Tambah tugas, tampilkan, hapus

🎓 Sertifikat:
Tersedia sertifikat gratis setelah menyelesaikan quiz akhir dan mini project!
""".trimIndent()

        ),
        Course(
            name = "Microsoft Excel untuk Pemula - LinkedIn Learning",
            description = "Kursus ini membantu kamu mengembangkan skill dasar Python untuk karir IT.",
            materials = "• Fungsi Dasar Excel\n• Rumus IF, SUM, AVERAGE\n• Tabel & Grafik\n• Latihan Kasus",
            platform = "LinkedIn Learning",
            level = "Beginner",
            duration = "1 Minggu",
            certificate = true,
            content = """
📚 Bab 1: Pengenalan Python
- Apa itu Python?
- Sejarah singkat dan perkembangan Python
- Kelebihan Python untuk pemula dan profesional

📚 Bab 2: Instalasi & Tools
- Install Python (Windows/Mac)
- IDE: VS Code, PyCharm, atau IDLE
- Menjalankan file Python pertama

📚 Bab 3: Dasar-Dasar Pemrograman
- Variabel dan Tipe Data (int, float, str, bool)
- Input & Output
- Operasi Aritmatika

📚 Bab 4: Percabangan dan Perulangan
- If-Else, Elif
- While dan For loop
- Nested loop dan penggunaan range()

📚 Bab 5: Fungsi & Modularisasi
- Membuat fungsi (def)
- Parameter & Return value
- Fungsi bawaan vs fungsi buatan

📚 Bab 6: Struktur Data
- List, Tuple, Dictionary, Set
- Operasi dasar, iterasi, manipulasi data

📚 Bab 7: Error Handling & File
- Try-Except block
- Membaca dan menulis file (.txt)

📚 Bab 8: Studi Kasus Mini Project
- Membuat Aplikasi To-Do List Sederhana di Terminal
- Fitur: Tambah tugas, tampilkan, hapus

🎓 Sertifikat:
Tersedia sertifikat gratis setelah menyelesaikan quiz akhir dan mini project!
""".trimIndent()

        ),
    )

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var adapter: CourseAdapter
    private var filteredCourseList: List<Course> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext() ?: throw IllegalStateException("Context is null!")
        val view = inflater.inflate(R.layout.activity_cari_fragment, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewCari)
        recyclerView.layoutManager = LinearLayoutManager(context)

        searchView = view.findViewById(R.id.searchViewCourse)

        adapter = CourseAdapter(context, courseList)
        recyclerView.adapter = adapter

        setupSearchView()
        

        return view
    }

    private fun setupSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterCourses(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterCourses(newText)
                return true
            }
        })
    }

    private fun filterCourses(query: String?) {
        filteredCourseList = if (query.isNullOrBlank()) {
            courseList // Kembalikan ke daftar asli jika query kosong
        } else {
            courseList.filter { course ->
                course.name.contains(query, ignoreCase = true) ||
                        course.description.contains(query, ignoreCase = true) ||
                        course.platform.contains(query, ignoreCase = true)
            }
        }
        adapter.updateData(filteredCourseList)
    }

    inner class CourseAdapter(private val context: Context, private var courseList: List<Course>) :
        RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

        inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameTextView: TextView = itemView.findViewById(R.id.skillName)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseAdapter.CourseViewHolder {
            val context = parent.context ?: throw IllegalStateException("Context is null!")
            val view = LayoutInflater.from(context).inflate(R.layout.item_skill, parent, false)
            if (view == null) {
                throw IllegalStateException("Layout inflation failed!")
            }
            return CourseViewHolder(view)
        }

        override fun onBindViewHolder(holder: CourseAdapter.CourseViewHolder, position: Int) {
            val course = courseList[position]
            holder.nameTextView.text = course.name

            holder.itemView.setOnClickListener {
                holder.itemView.context?.let { context ->
                    startDetailActivity(context, course)
                }
            }
        }

        override fun getItemCount(): Int {
            return courseList.size
        }

        fun updateData(newCourseList: List<Course>) {
            courseList = newCourseList
            notifyDataSetChanged()
        }

        private fun startDetailActivity(context: Context, course: Course) {
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
}