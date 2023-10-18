package com.example.jetpackcomposeinstagram.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) :ViewModel() {

    //val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String> = _pass

    private val _loginFlag = MutableLiveData<Boolean>()
    val loginFlag: LiveData<Boolean> = _loginFlag

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    }

    fun onLoginChanged(email: String, pass:String) {
        _email.value = email
        _pass.value = pass
        _loginFlag.value = enableLogin(email,pass)
    }

    fun goBack() {
        _isLoading.value = false
    }

    fun onLoginSelected(){
        viewModelScope.launch {
            val result = loginUseCase(_email.value!!,_pass.value!!)
            if (result){
                _isLoading.value = true
            }
        }
    }
}