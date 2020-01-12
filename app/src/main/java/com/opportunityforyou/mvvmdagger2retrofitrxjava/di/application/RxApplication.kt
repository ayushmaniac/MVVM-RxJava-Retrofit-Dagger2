package com.opportunityforyou.mvvmdagger2retrofitrxjava.di.application

import android.app.Application
import com.opportunityforyou.mvvmdagger2retrofitrxjava.data.local.DatabaseService
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.component.ApplicationComponent
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.component.DaggerApplicationComponent
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.module.ApplicationModule
import javax.inject.Inject

class RxApplication : Application() {


    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var databaseService : DatabaseService

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }


}