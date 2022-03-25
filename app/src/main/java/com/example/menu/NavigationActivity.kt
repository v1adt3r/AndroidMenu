package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var action: TextView? = null
    private var bottom: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        action = findViewById(R.id.action)
        bottom = findViewById(R.id.navigation)

        bottom?.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.bottom_git  -> action?.setText("GIT")
            R.id.bottom_home -> action?.setText("Home")
            R.id.bottom_svn  -> action?.setText("SVN")
            else -> return false
        }

        return true 
    } 
}