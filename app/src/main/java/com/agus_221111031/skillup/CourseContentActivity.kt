package com.agus_221111031.skillup

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CourseContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_content)

        val courseName = intent.getStringExtra("name")
        val courseContent = intent.getStringExtra("content")

        findViewById<TextView>(R.id.courseTitle).text = courseName
        findViewById<TextView>(R.id.courseContent).text = courseContent
    }
}
