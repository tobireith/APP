package com.example.uebung4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar : androidx.appcompat.widget.Toolbar
    lateinit var mDrawerLayout : DrawerLayout
    lateinit var mDrawerToggle: ActionBarDrawerToggle

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
    }

    fun initGui() {
        mToolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(mToolbar)
        mDrawerLayout = findViewById(R.id.main_drawer_layout)

    }

    fun setupDrawerToggle() {
        mDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer)
        mDrawerLayout.addDrawerListener(mDrawerToggle)
    }
}
