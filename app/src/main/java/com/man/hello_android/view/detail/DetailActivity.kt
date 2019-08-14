package com.man.hello_android.view.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.man.hello_android.R
import com.man.hello_android.adapter.AdapterDetail
import com.man.hello_android.adapter.AdapterMain
import com.man.hello_android.model.OsAndroid
import com.man.hello_android.utils.DataHelper
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setView(intent.getParcelableExtra(AdapterMain.ANDRO))
    }

    private fun setView (data : OsAndroid){
        val feature = data.new_feature!!.split("|")
        setFeature(feature)
        detailNameVersion.text = data.name
        detailNumberVersion.text = data.version
        detailReleaseDate.text = data.release_date
        detailApiLevelDate.text = data.api_level
        detailDescription.text = data.description
        DataHelper.loadImage(detailIcon, data.icon, this)
    }

    private fun setFeature(list: List<String>){
        val adp = AdapterDetail(list, this)
        rvFeature.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = adp
        }
    }
}
