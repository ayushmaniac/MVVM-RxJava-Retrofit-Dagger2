package com.opportunityforyou.mvvmdagger2retrofitrxjava.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "users")
data class User(

        @PrimaryKey(autoGenerate = true)
        var id : Long = 0,

        @ColumnInfo(name = "name")
        var name: String
)