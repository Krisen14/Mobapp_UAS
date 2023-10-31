package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import androidx.appcompat.widget.Toolbar


class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private val profileFragment = ProfileFragment()
    private val homeFragment = HomeFragment()
    private val settingFragment = SettingFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottomView);
        bottomNavigationView.setOnItemSelectedListener(this);

        val customToolbar = findViewById<Toolbar>(R.id.customToolbar)
        setSupportActionBar(customToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false) // Sembunyikan judul default

        // Atur tindakan saat tombol aksi ditekan
        val actionButton = customToolbar.findViewById<ImageButton>(R.id.actionButton)
        actionButton.setOnClickListener {
            // Tindakan yang akan dijalankan saat tombol aksi ditekan
            // Misalnya, tampilkan menu atau lakukan tindakan tertentu.
        }

        // Atur logo dan ikon profil di toolbar
        val logoImageView = customToolbar.findViewById<ImageView>(R.id.logoImageView)
        val profileImageView = customToolbar.findViewById<ImageView>(R.id.profileImageView)

        // Atur logo ke kiri atas
        val layoutParams = logoImageView.layoutParams as Toolbar.LayoutParams
        layoutParams.gravity = Gravity.START or Gravity.CENTER_VERTICAL
        logoImageView.layoutParams = layoutParams

        // Atur profil ke kiri atas
        val profileLayoutParams = profileImageView.layoutParams as Toolbar.LayoutParams
        profileLayoutParams.gravity = Gravity.START or Gravity.CENTER_VERTICAL
        profileImageView.layoutParams = profileLayoutParams
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, profileFragment).commit()
                return true
            }

            R.id.menu -> {
                supportFragmentManager.beginTransaction().replace(R.id.flFragment, homeFragment)
                    .commit()
                return true
            }

            R.id.settings -> {
                supportFragmentManager.beginTransaction().replace(R.id.flFragment, settingFragment)
                    .commit()
                return true
            }
        }
        return false
    }
}