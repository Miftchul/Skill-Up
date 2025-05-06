package com.agus_221111031.skillup

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

// Notifikasi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

// Nav Drawer
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle



class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    private val skills = arrayOf(
        "Belajar Python Gratis - Coursera",
        "Dasar UI/UX - Google Course",
        "Kelas Public Speaking - Udemy",
        "Basic Project Management - edX",
        "Microsoft Excel untuk Pemula - LinkedIn Learning"
    )

    private val skillDetails = mapOf(
        "Belajar Python Gratis - Coursera" to "• Variabel dan Tipe Data\n• Perulangan\n• Fungsi Dasar\n• Mini Project Python",
        "Dasar UI/UX - Google Course" to "• Prinsip Desain UI\n• Wireframing\n• User Journey\n• Prototyping Dasar",
        "Kelas Public Speaking - Udemy" to "• Teknik Vocal\n• Bahasa Tubuh\n• Menyusun Presentasi\n• Latihan Percaya Diri",
        "Basic Project Management - edX" to "• Apa itu PM?\n• WBS dan Timeline\n• Stakeholder\n• Tools: Trello, Gantt",
        "Microsoft Excel untuk Pemula - LinkedIn Learning" to "• Fungsi Dasar Excel\n• Rumus IF, SUM, AVERAGE\n• Tabel & Grafik\n• Latihan Kasus"
    )

    private val NOTIFICATION_PERMISSION_CODE = 1001

    private fun showWelcomeNotification() {
        val channelId = "skillup_channel"
        val channelName = "SkillUp Notification"

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Channel dibutuhkan mulai dari Android Oreo ke atas
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Selamat Datang di SkillUp!")
            .setContentText("Yuk, cek skill dan mulai belajar hari ini.")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(1, notification)
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_CODE
                )
            } else {
                // Izin sudah diberikan, tampilkan notif
                showWelcomeNotification()
            }
        } else {
            // Versi di bawah Android 13 tidak butuh izin
            showWelcomeNotification()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == NOTIFICATION_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showWelcomeNotification()
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "SkillUp" // Judul ActionBar

        listView = findViewById(R.id.listViewSkills)
        val adapter = SkillAdapter(this, skills)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedSkill = skills[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("skill_name", selectedSkill)
            intent.putExtra("skill_materi", skillDetails[selectedSkill])
            startActivity(intent)
        }

        val aboutButton = findViewById<Button>(R.id.aboutButton)
        aboutButton.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        // Cek & minta izin sebelum tampilkan notifikasi
        checkNotificationPermission()

//      NAV DRAWER
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

// Toggle untuk buka/tutup drawer
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

// Handle klik item di drawer
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    drawerLayout.closeDrawers()
                }
                R.id.nav_about -> {
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                    drawerLayout.closeDrawers()
                }
            }
            true
        }

    }

    @Suppress("MissingSuperCall")
    override fun onBackPressed() {
        val view = layoutInflater.inflate(R.layout.dialog_custom_exit, null)
        val dialog = AlertDialog.Builder(this)
            .setView(view)
            .create()

        view.findViewById<Button>(R.id.btnYes).setOnClickListener {
            dialog.dismiss()
            finish()
        }

        view.findViewById<Button>(R.id.btnNo).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
