package com.opportunityforyou.mvvmdagger2retrofitrxjava.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.opportunityforyou.mvvmdagger2retrofitrxjava.data.dao.UserDao
import com.opportunityforyou.mvvmdagger2retrofitrxjava.data.entity.User


@Database(
        entities = [User::class],
        version = 1,
        exportSchema = false
)
abstract class DatabaseService : RoomDatabase() {


    abstract fun userDao() : UserDao
}