package com.agus_221111031.skillup

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager


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
import androidx.recyclerview.widget.RecyclerView

data class Course(
    val name: String,
    val description: String,
    val materials: String,
    val platform: String,
    val level: String,
    val duration: String,
    val certificate: Boolean,
    val content: String
)


class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView


    private val courseList = listOf(
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
        // Tambahkan lainnya...
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

        // Inisialisasi RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCourses)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CourseAdapter(this, courseList)
        recyclerView.adapter = adapter

        // Tombol "Tentang Aplikasi"
        val aboutButton = findViewById<Button>(R.id.aboutButton)
        aboutButton.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        // Cek notifikasi
        checkNotificationPermission()

        // Setup nav drawer
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
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
