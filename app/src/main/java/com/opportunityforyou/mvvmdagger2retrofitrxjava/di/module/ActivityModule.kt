package com.opportunityforyou.mvvmdagger2retrofitrxjava.di.module

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.qualifiers.ActivityContext
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity: Activity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity
}