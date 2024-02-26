package com.pack.tasks.helper

import android.content.Context
import com.pack.tasks.R
import com.pack.tasks.entities.ListModel

object ProfileItemsHelper {

    fun profileDataHelper(context: Context):List<ListModel>{
//        val defaultYourInformationData = mutableListOf<String>()
        return listOf(ListModel(R.drawable.icon_privacy,"Privacy policy")
            ,ListModel(R.drawable.icon_document, "Terms and Conditions"))
    }

}