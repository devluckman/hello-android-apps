package com.man.hello_android.view.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.man.hello_android.R
import com.man.hello_android.adapter.AdapterMain
import com.man.hello_android.model.Response
import com.man.hello_android.utils.DataHelper
import com.man.hello_android.view.about.AboutActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
    }

    private fun setViews(){
        val list = Gson().fromJson(DataHelper.getJson(this), Response::class.java)
        val adapterMe = AdapterMain(list.os_android, this)
        rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterMe
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.about)
            startActivity(Intent(this, AboutActivity::class.java))

        return true
    }
}
