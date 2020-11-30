package com.android.cookiedashboard.profile


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.android.cookiedashboard.profile.adapter.ProfileCard
import com.android.localstoragemanager.model.Profile
import com.android.localstoragemanager.repository.ProfileRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {


    val allProfiles = repository.allProfiles.map {
        it.map {
            ProfileCard(it.id, it.username, true)
        }
    }.asLiveData()

    fun saveProfile(profile: Profile) = viewModelScope.launch {
        repository.insert(profile)
    }
}