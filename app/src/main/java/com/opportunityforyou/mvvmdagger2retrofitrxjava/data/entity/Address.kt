package com.opportunityforyou.mvvmdagger2retrofitrxjava.data.entity

import androidx.room.ColumnInfo

data class Address (


    @ColumnInfo(name = "city")
    var city : String,

    @ColumnInfo(name = "country")
    var country : String


    )