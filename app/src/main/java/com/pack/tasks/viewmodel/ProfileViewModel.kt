package com.pack.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pack.tasks.entities.ListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val profileListData = MutableLiveData<MutableList<ListModel>>()

    fun getProfileListData(): MutableLiveData<MutableList<ListModel>> {
        return profileListData
    }



    fun getProfileList() {
        viewModelScope.launch(Dispatchers.IO) {
            val yourInformation = ProfilePreferenceManager.getInstance(getApplication()).getYourInformation()?.toMutableList()
            profileListData.postValue(yourInformation?.toMutableList())
        }
    }


}