package com.example.performate.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.performate.data.ErrorMessage
import com.example.performate.data.PhoneRepository
import com.example.performate.data.model.PhoneResponseItem
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PhoneRepository) : ViewModel() {

    private var _phones = MutableLiveData<List<PhoneResponseItem>>()
    val phones: LiveData<List<PhoneResponseItem>>
        get() = _phones

    private var _errorStatus = MutableLiveData<String?>()
    val errorStatus: LiveData<String?> get() = _errorStatus

    private var _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading


    fun getPhones() {
        viewModelScope.launch {
            try {
                _loading.value = true
                _phones.value = repository.getPhones()
            } catch (error: ErrorMessage) {
                _errorStatus.value = error.message
            } finally {
                _loading.value = false
            }
        }
    }

    fun onSnackbarShown() {
        _errorStatus.value = null
    }
}