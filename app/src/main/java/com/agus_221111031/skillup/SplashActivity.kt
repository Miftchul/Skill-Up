package com.agus_221111031.skillup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private var progressStatus = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo)
        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressText)

        // Initial condition for logo
        logo.scaleX = 0.8f
        logo.scaleY = 0.8f
        logo.alpha = 0f

        logo.animate()
            .scaleX(1f)
            .scaleY(1f)
            .alpha(1f)
            .setDuration(1500)
            .start()

        // Start the loading simulation
        simulateLoading()
    }

    private fun simulateLoading() {
        Thread {
            while (progressStatus < 100) {
                progressStatus += 1
                handler.post {
                    progressBar.progress = progressStatus
                    progressText.text = "$progressStatus%"
                }
                Thread.sleep(30) // Loading speed, smaller value means faster
            }

            // After progress reaches 100%, move to MainActivity
            handler.post {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }.start()
    }
}
