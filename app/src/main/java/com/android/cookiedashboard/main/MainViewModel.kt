package com.android.cookiedashboard.main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.android.localstoragemanager.model.Profile
import com.android.localstoragemanager.repository.ProfileRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProfileRepository) : ViewModel() {


    val allSettings = repository.allProfiles.map { it.map { it.username } }.asLiveData()

    fun insert(profile: Profile) = viewModelScope.launch {
        repository.insert(profile)
    }
}