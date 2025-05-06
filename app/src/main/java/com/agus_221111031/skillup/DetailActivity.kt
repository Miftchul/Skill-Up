package com.agus_221111031.skillup

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val skillName = intent.getStringExtra("skill_name")
        val skillMateri = intent.getStringExtra("skill_materi")

        val titleText = findViewById<TextView>(R.id.skillName)
        val materiText = findViewById<TextView>(R.id.skillDescription)

        titleText.text = skillName
        materiText.text = "Kursus ini bisa membantu kamu mengembangkan skill untuk karir!\n\n📘 Materi Singkat:\n$skillMateri"


    }



}
