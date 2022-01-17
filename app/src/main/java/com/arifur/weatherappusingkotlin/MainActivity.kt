package com.arifur.weatherappusingkotlin

import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


import com.arifur.weatherappusingkotlin.databinding.ActivityMainBinding
import com.arifur.weatherappusingkotlin.ui.dashboard.DashboardFragment
import com.arifur.weatherappusingkotlin.ui.home.HomeFragment
import com.arifur.weatherappusingkotlin.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        setFragment(HomeFragment())
        navView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_home->setFragment(HomeFragment())
                R.id.navigation_dashboard->setFragment(DashboardFragment())
                R.id.navigation_notifications->setFragment(NotificationsFragment())
            }
            false
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.nav_host_fragment_activity_main,fragment)
            commit()
        }
    }

}