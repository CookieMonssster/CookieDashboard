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

    private var profile: Profile? = null

    fun loadProfile(id: Int) =
        repository.load(id).map {
            profile = it
            it
        }.asLiveData()

    fun updateProfileMode(mode: Mode) {
        profile?.let {
            viewModelScope.launch {
                repository.update(Profile(mode, it.username, it.id))
            }
        }
    }

    fun removeProfile() {
        profile?.let {
            viewModelScope.launch {
                repository.remove(it.id)
            }
        }
    }
}