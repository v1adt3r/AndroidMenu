package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener, View.OnClickListener {

    private var popupMenu: PopupMenu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(findViewById(R.id.hello))

        popupMenu = PopupMenu(this, findViewById(R.id.hello))
        popupMenu!!.inflate(R.menu.popup)
        popupMenu!!.setOnMenuItemClickListener(this)

        invalidateOptionsMenu()

        findViewById<TextView>(R.id.hello).setOnClickListener(this)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when(v?.id) {
            R.id.hello -> menuInflater.inflate(R.menu.context, menu)
        }

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.context_exit ->
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }

        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.main_add, R.id.main_create, R.id.main_delete ->
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.popup_quit -> Toast.makeText(this, "Quit", Toast.LENGTH_SHORT).show()
            else            -> return false
        }

        return true;
    }

    override fun onClick(p0: View?) {
        popupMenu?.show()
    }
}