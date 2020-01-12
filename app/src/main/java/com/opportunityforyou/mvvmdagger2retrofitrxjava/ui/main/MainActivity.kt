package com.opportunityforyou.mvvmdagger2retrofitrxjava.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.opportunityforyou.mvvmdagger2retrofitrxjava.R
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.application.RxApplication
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.component.DaggerActivityComponent
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.module.ActivityModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    @Inject
    lateinit var viewmodel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()


        viewmodel.users.observe(this, Observer {
            textView.text = it.toString()
        })



    }

    private fun getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent((application as RxApplication).applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }



    private fun initViews() {
        textView = findViewById(R.id.noneOne)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewmodel.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        viewmodel.getAllUsers()
    }

    override fun onStop() {
        super.onStop()
        viewmodel.deleteUser()
    }
}