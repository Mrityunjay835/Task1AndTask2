package com.pack.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pack.tasks.databinding.ActivityMainBinding
import com.pack.tasks.fragment.HomeFragment
import com.pack.tasks.fragment.OrdersFragment
import com.pack.tasks.fragment.PointsFragment
import com.pack.tasks.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.itHome -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.itPoints -> {
                    loadFragment(PointsFragment())
                    true
                }
                R.id.itOthers -> {
                    loadFragment(OrdersFragment())
                    true
                }
                R.id.itProfile -> {
                    loadFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        // Initially load the home fragment
        loadFragment(HomeFragment())


    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navHostFragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}