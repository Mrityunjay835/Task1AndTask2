package com.pack.tasks.entities

import androidx.annotation.DrawableRes

data class ListModel (
    @DrawableRes val imageResourceId:Int,
    val title:String
)