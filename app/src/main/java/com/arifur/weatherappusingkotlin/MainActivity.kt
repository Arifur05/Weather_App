package com.arifur.weatherappusingkotlin

import android.os.Bundle
import android.text.method.TextKeyListener.clear
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

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
        val home = HomeFragment()
        val location = DashboardFragment()
        val settings = NotificationsFragment()
        setFragment(HomeFragment())
        navView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_home->setFragment(HomeFragment())
                R.id.navigation_locations->setFragment(DashboardFragment())
                R.id.navigation_setting->setFragment(NotificationsFragment())
            }
            false
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fragment_container,fragment)
            commit()
        }
    }

}