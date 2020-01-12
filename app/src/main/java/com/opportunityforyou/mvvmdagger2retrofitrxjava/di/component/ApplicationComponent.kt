package com.opportunityforyou.mvvmdagger2retrofitrxjava.di.component

import android.content.Context
import com.opportunityforyou.mvvmdagger2retrofitrxjava.data.local.DatabaseService
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.application.RxApplication
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.module.ApplicationModule
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.qualifiers.ApplicationContext
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: RxApplication)

    @ApplicationContext
    fun getContext(): Context


    fun getDatabaseService(): DatabaseService

    fun getCompositeDisposable() : CompositeDisposable
}