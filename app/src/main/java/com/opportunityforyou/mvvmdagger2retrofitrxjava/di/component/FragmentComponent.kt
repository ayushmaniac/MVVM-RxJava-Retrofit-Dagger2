package com.opportunityforyou.mvvmdagger2retrofitrxjava.di.component

import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.module.ActivityModule
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.module.FragmentModule
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.scopes.ActivityScope
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.scopes.FragmentScope
import com.opportunityforyou.mvvmdagger2retrofitrxjava.ui.main.MainActivity
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

}
