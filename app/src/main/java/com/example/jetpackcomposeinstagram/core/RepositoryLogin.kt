package com.example.jetpackcomposeinstagram.core

import com.example.jetpackcomposeinstagram.core.network.LoginService
import javax.inject.Inject

class RepositoryLogin @Inject constructor(private val loginService: LoginService){

    suspend fun doLogin(user:String, pass:String): Boolean{
        return loginService.doLogin(user, pass)
    }
}