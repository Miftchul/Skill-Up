package com.agus_221111031.skillup.ui.profil

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.agus_221111031.skillup.R
import com.google.android.material.navigation.NavigationView

class ProfilFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profil, container, false)

        val aboutButton: Button = view.findViewById(R.id.aboutButton)
        drawerLayout = view.findViewById(R.id.drawer_layout)
        navView = view.findViewById(R.id.nav_view)

        aboutButton.setOnClickListener {
            //  Bersihkan konten NavigationView
            navView.menu.clear()
            navView.removeAllViews()

            //  1. Inflate layout activity_about.xml
            val aboutView = inflater.inflate(R.layout.activity_about, navView, false)

            //  2. Temukan FrameLayout di dalam NavigationView (atau buat jika perlu)
            var contentContainer = navView.findViewById<FrameLayout>(R.id.nav_content_container)
            if (contentContainer == null) {
                contentContainer = FrameLayout(requireContext())
                contentContainer.id = R.id.nav_content_container
                navView.addView(contentContainer)

                //  Atur LayoutParams untuk FrameLayout agar memenuhi lebar NavigationView
                val params = contentContainer.layoutParams
                params.width = ViewGroup.LayoutParams.MATCH_PARENT
                contentContainer.layoutParams = params
            }

            //  3. Tambahkan aboutView ke container
            contentContainer.addView(aboutView)

            //  4. Temukan TextView untuk versi aplikasi
            val versionTextView: TextView = aboutView.findViewById(R.id.versionTextView)

            //  5. Dapatkan dan atur versi aplikasi
            try {
                val packageInfo = requireContext().packageManager.getPackageInfo(requireContext().packageName, 0)
                val versionName = packageInfo.versionName
                versionTextView.text = "Versi Aplikasi: $versionName"
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                versionTextView.text = "Versi Aplikasi: Tidak Diketahui"
            }


            //  6. Buka Drawer
            drawerLayout.openDrawer(navView)
        }

        return view
    }

    companion object {
        //  Pindahkan deklarasi ARG_PARAM1 dan ARG_PARAM2 ke sini
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfilFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}