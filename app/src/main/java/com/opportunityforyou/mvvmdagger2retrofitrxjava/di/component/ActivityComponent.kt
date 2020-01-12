package com.opportunityforyou.mvvmdagger2retrofitrxjava.di.component

import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.module.ActivityModule
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.scopes.ActivityScope
import com.opportunityforyou.mvvmdagger2retrofitrxjava.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}