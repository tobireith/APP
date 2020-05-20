package com.example.uebung4

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.iterator
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar : androidx.appcompat.widget.Toolbar
    lateinit var mDrawerLayout : DrawerLayout
    lateinit var mDrawerToggle: ActionBarDrawerToggle
    lateinit var mNavigationView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myInit()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mDrawerToggle.syncState()
    }

    fun myInit() {
        initGui()
        setupDrawerToggle()
        setupNavigationDrawer()
    }

    fun initGui() {
        mToolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(mToolbar)
        mDrawerLayout = findViewById(R.id.main_drawer_layout)
        mNavigationView = findViewById(R.id.main_navigation_view)
    }

    fun setupDrawerToggle() {
        mDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer)
        mDrawerLayout.addDrawerListener(mDrawerToggle)
    }

    fun setupNavigationDrawer() {
        mNavigationView.menu.getItem(0).setChecked(true)

        mNavigationView.setNavigationItemSelectedListener(
            NavigationView.OnNavigationItemSelectedListener(
                function = fun(menuItem: MenuItem): Boolean {
                    for (Titem in mNavigationView.menu) {
                        Titem.setChecked(false)
                    }
                    menuItem.setChecked(true)
                    switchFragment(menuItem.itemId)
                    Log.d("FRAGMENT", "This Fragment is selected: "+menuItem.itemId)
                    mDrawerLayout.closeDrawers()
                    return true
                }
            )
        )
    }

    fun switchFragment(menuItemId : Int) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        // Get the current fragment which is in the container
        val containerFragment: Fragment? = fragmentManager.findFragmentById(R.id.main_container)
        // Init the new fragment
        val newFragment: Fragment? = getFragmentById(containerFragment, menuItemId)
        if (newFragment != null) {
            fragmentTransaction.replace(R.id.main_container, newFragment)
            Log.d("FRAGMENT", "This Fragment is selected (switch Function): "+newFragment.id)
            fragmentTransaction.commit()
        }
    }

    private fun getFragmentById(containerFragment: Fragment?, menuItemId: Int): Fragment? {
        when (menuItemId) {
            R.id.menu_nav_item_settings ->                 // Check if fragment is already there - prevent unnecessary replacement
                if (containerFragment !is SettingsFragment) return SettingsFragment.newInstance()
            R.id.menu_nav_item_info -> if (containerFragment !is InfoFragment) return InfoFragment.newInstance()
            R.id.menu_nav_view_dashboard -> if(containerFragment !is DashboardFragment) return DashboardFragment.newInstance()
            else -> return null
        }
        // Return null if no change should occur
        return null
    }

}
