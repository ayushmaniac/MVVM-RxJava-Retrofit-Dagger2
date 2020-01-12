package com.opportunityforyou.mvvmdagger2retrofitrxjava.di.module

import android.content.Context
import androidx.room.Room
import com.opportunityforyou.mvvmdagger2retrofitrxjava.data.local.DatabaseService
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.application.RxApplication
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class ApplicationModule (private val application: RxApplication) {


    @ApplicationContext
    @Provides
    fun provideContext() : Context = application


    @Provides
    fun provideDatabaseName() : String = "dummy_db"

    @Provides
    fun provideApiKey() : String = "API_KEY"

    @Provides
    @Singleton
    fun provideDatabaseService() : DatabaseService = Room.databaseBuilder(
            application,
            DatabaseService::class.java,
            "dbproject")
            .build()

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable = CompositeDisposable()
}