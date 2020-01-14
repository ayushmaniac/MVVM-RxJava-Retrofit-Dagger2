package com.opportunityforyou.mvvmdagger2retrofitrxjava.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.opportunityforyou.mvvmdagger2retrofitrxjava.data.entity.Address
import com.opportunityforyou.mvvmdagger2retrofitrxjava.data.entity.User
import com.opportunityforyou.mvvmdagger2retrofitrxjava.data.local.DatabaseService
import com.opportunityforyou.mvvmdagger2retrofitrxjava.di.scopes.ActivityScope
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
        private val compositeDisposable: CompositeDisposable,
        private val database : DatabaseService
){

    companion object{
        const val TAG = "MainViewModel"
    }
    val user = MutableLiveData<User>()
    val users = MutableLiveData<List<User>>()
    var allUsers : List<User> = emptyList()

    init {
        compositeDisposable.add(
                database.userDao().getCount()
                        .flatMap {
                            if(it == 0)
                                database.userDao().insertMany(
                                        User(name = "Ayush", address = Address("Raipur","India")),
                                        User(name = "Ayush Again", address = Address("Bhilai","India")),
                                        User(name = "Ayush Again", address = Address("London","United Kingdom")),
                                        User(name = "Ayush Again", address = Address("Moscow","Russia")),
                                        User(name = "Ayush Again", address = Address("New York","USA"))

                                )
                            else Single.just(0)
                        }
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                {
                                    Log.d(TAG, "User exists in the table: $it")
                                 },
                                {

                                    Log.d(TAG, "User exists in the table: $it")

                                })


        )
    }


    fun getAllUsers(){
         compositeDisposable.add(database.userDao().getAllUsers()
                 .subscribeOn(Schedulers.io())
                 .subscribe(
                         {
                            users.postValue(it)
                         },
                         {
                             Log.d(TAG, it.toString())

                         }

                 ))

    }


    fun deleteUser(){

        if(allUsers.isNotEmpty()){

            compositeDisposable.addAll(database.userDao().delete(allUsers[0])
                    .flatMap { database.userDao().getAllUsers(

                    ) }
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            {
                                allUsers = it
                                users.postValue(it)
                            },
                            {
                                Log.d(TAG, it.toString())

                            }
                    ))
        }
    }


    fun onDestroy() {

        compositeDisposable.dispose()
    }
}