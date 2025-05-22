package com.agus_221111031.skillup.ui.detail

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.agus_221111031.skillup.CourseContentActivity
import com.agus_221111031.skillup.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Ambil data dari Intent
        val name = intent.getStringExtra("name") ?: "Nama tidak tersedia!"
        val description = intent.getStringExtra("description")
        val materials = intent.getStringExtra("materials")
// Ambil data lainnya...
        val platform = intent.getStringExtra("platform")
        val level = intent.getStringExtra("level")
        val duration = intent.getStringExtra("duration")
        val certificate = intent.getBooleanExtra("certificate", false)
        val courseContent = intent.getStringExtra("content") // ⬅ Tambahkan ini!

        // Tampilkan ke tampilan
        findViewById<TextView>(R.id.skillName).text = name
        findViewById<TextView>(R.id.skillDescription).text = description
        findViewById<TextView>(R.id.skillMaterials).text = "📘 Materi Singkat:\n$materials"
        findViewById<TextView>(R.id.skillDetails).text = """
📌 Platform     : $platform
📌 Level        : $level
📌 Durasi       : $duration
📌 Sertifikat   : ${if (certificate) "✅ Ya" else "❌ Tidak"}
""".trimIndent()

        // Tombol ke halaman materi
        val startButton = findViewById<Button>(R.id.btnStartCourse)
        startButton.setOnClickListener {
            val intent = Intent(this, CourseContentActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("content", courseContent)
            startActivity(intent)
        }
    }
}