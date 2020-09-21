package com.example.aplikasiprofilesekolah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host :NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host)as NavHostFragment??:return

        val navController = host.navController

        bottom_nav.setupWithNavController(navController)

        supportActionBar?.elevation = 0f

    }
}