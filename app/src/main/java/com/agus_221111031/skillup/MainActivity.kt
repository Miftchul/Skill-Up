package com.agus_221111031.skillup

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

// Data class untuk kursus dengan anotasi Parcelable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Course(
    val name: String,
    val description: String,
    val materials: String,
    val platform: String,
    val level: String,
    val duration: String,
    val certificate: Boolean,
    val content: String
) : Parcelable

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var bottomNav: BottomNavigationView
    private val exploreFragment = ExploreFragment()
    private val learnFragment = LearnFragment()
    private val searchFragment = SearchFragment()

    private val courseList = listOf(
        Course(
            name = "Belajar Python Gratis - Coursera",
            description = "Kursus ini membantu kamu mengembangkan skill dasar Python untuk karir IT.",
            materials = "• Variabel dan Tipe Data\n• Perulangan\n• Fungsi Dasar\n• Mini Project Python",
            platform = "Coursera",
            level = "Beginner",
            duration = "4 Minggu",
            certificate = true,
            content = "Materi lengkap tentang dasar-dasar Python, termasuk sintaks, struktur data, dan proyek sederhana untuk membangun aplikasi kecil."
        ),
        Course(
            name = "Belajar UI/UX - Google Course",
            description = "Kursus ini membantu kamu memahami prinsip dasar desain UI/UX untuk pengembangan aplikasi.",
            materials = "• Prinsip Desain UI\n• Wireframing\n• User Journey\n• Prototyping Dasar",
            platform = "Google Course",
            level = "Beginner",
            duration = "4 Minggu",
            certificate = true,
            content = "Panduan lengkap untuk merancang antarmuka pengguna yang intuitif dan pengalaman pengguna yang optimal."
        ),
        Course(
            name = "Kelas Public Speaking - Udemy",
            description = "Kursus ini membantu kamu meningkatkan keterampilan berbicara di depan umum.",
            materials = "• Teknik Vocal\n• Bahasa Tubuh\n• Menyusun Presentasi\n• Latihan Percaya Diri",
            platform = "Udemy",
            level = "Beginner",
            duration = "2 Minggu",
            certificate = true,
            content = "Pelajari teknik presentasi yang efektif dan cara membangun kepercayaan diri saat berbicara di depan audiens."
        ),
        Course(
            name = "Basic Project Management - edX",
            description = "Kursus ini mengajarkan dasar-dasar manajemen proyek untuk pemula.",
            materials = "• Apa itu PM?\n• WBS dan Timeline\n• Stakeholder\n• Tools: Trello, Gantt",
            platform = "edX",
            level = "Beginner",
            duration = "2 Minggu",
            certificate = true,
            content = "Kursus ini mencakup pengenalan manajemen proyek, pembuatan rencana kerja, dan penggunaan alat seperti Trello dan Gantt Chart."
        ),
        Course(
            name = "Microsoft Excel untuk Pemula - LinkedIn Learning",
            description = "Kursus ini mengajarkan penggunaan Microsoft Excel untuk analisis data dasar.",
            materials = "• Fungsi Dasar Excel\n• Rumus IF, SUM, AVERAGE\n• Tabel & Grafik\n• Latihan Kasus",
            platform = "LinkedIn Learning",
            level = "Beginner",
            duration = "1 Minggu",
            certificate = true,
            content = "Pelajari cara menggunakan Excel untuk mengelola data, membuat tabel, dan visualisasi data dengan grafik."
        )
    )

    private val NOTIFICATION_PERMISSION_CODE = 1001

    private fun showWelcomeNotification() {
        val channelId = "skillup_channel"
        val channelName = "SkillUp Notification"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

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
                showWelcomeNotification()
            }
        } else {
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

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        bottomNav = findViewById(R.id.bottom_navigation)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

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

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_explore -> {
                    loadFragment(exploreFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_learn -> {
                    loadFragment(learnFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_search -> {
                    loadFragment(searchFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        if (savedInstanceState == null) {
            loadFragment(exploreFragment)
            Log.d("MainActivity", "Loading initial fragment: ExploreFragment")
        }

        checkNotificationPermission()
    }

    private fun loadFragment(fragment: Fragment) {
        Log.d("MainActivity", "Loading fragment: ${fragment.javaClass.simpleName}")
        if (fragment is ExploreFragment) {
            fragment.arguments = Bundle().apply {
                putParcelableArrayList("courseList", ArrayList(courseList))
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        val view = layoutInflater.inflate(R.layout.dialog_custom_exit, null)
        val dialog = AlertDialog.Builder(this)
            .setView(view)
            .create()

        view.findViewById<Button>(R.id.btnYes).setOnClickListener {
            dialog.dismiss()
            super.onBackPressed()
        }

        view.findViewById<Button>(R.id.btnNo).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}