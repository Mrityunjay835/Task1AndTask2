package com.pack.tasks.viewmodel

import android.content.Context
import com.pack.tasks.entities.ListModel
import com.pack.tasks.helper.ProfileItemsHelper
import com.pack.tasks.helper.SingletonHolder

class ProfilePreferenceManager private constructor(val context: Context){

    companion object :
        SingletonHolder<ProfilePreferenceManager, Context>(::ProfilePreferenceManager)

    fun getYourInformation():List<ListModel>{
        return ProfileItemsHelper.profileDataHelper(context)
    }

}