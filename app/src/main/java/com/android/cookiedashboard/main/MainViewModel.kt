package com.android.cookiedashboard.main


import androidx.lifecycle.*
import com.android.localstoragemanager.model.Profile
import com.android.localstoragemanager.repository.ProfileRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProfileRepository) : ViewModel() {


    val allSettings: LiveData<List<Profile>> = repository.allProfiles.asLiveData()

    fun insert(profile: Profile) = viewModelScope.launch {
        repository.insert(profile)
    }
}