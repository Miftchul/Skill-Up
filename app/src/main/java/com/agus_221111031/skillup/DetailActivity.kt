package com.agus_221111031.skillup

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Ambil data dari Intent
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val materials = intent.getStringExtra("materials")
        val platform = intent.getStringExtra("platform")
        val level = intent.getStringExtra("level")
        val duration = intent.getStringExtra("duration")
        val certificate = intent.getBooleanExtra("certificate", false)

        findViewById<TextView>(R.id.skillName).text = name
        findViewById<TextView>(R.id.skillDescription).text = description
        findViewById<TextView>(R.id.skillMaterials).text = "📘 Materi Singkat:\n$materials"
        findViewById<TextView>(R.id.skillDetails).text = """
📌 Platform     : $platform
📌 Level        : $level
📌 Durasi       : $duration
📌 Sertifikat   : ${if (certificate) "✅ Ya" else "❌ Tidak"}
""".trimIndent()


        // Tampilkan ke TextView
//        val textView = findViewById<TextView>(R.id.skillDescription)
//        textView.text = detailText
    }
}
