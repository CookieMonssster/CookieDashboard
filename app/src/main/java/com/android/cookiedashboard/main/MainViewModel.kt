package com.android.cookiedashboard.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.android.localstoragemanager.model.Mode
import com.android.localstoragemanager.model.Profile
import com.android.localstoragemanager.repository.ProfileRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProfileRepository) : ViewModel() {

    private lateinit var profile: Profile

    fun loadProfile(id: Int) =
        repository.load(id).map {
            profile = it
            it
        }.asLiveData()

    fun updateProfileMode(mode: Mode) {
        viewModelScope.launch {
            repository.update(Profile(mode, profile.username, profile.id))
        }
    }
}