package com.example.jetpackcomposeinstagram.core.network

import com.example.jetpackcomposeinstagram.login.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject


class LoginService @Inject constructor(private val loginClient: LoginClient){


    suspend fun doLogin(user:String, pass:String): Boolean{
       return withContext(Dispatchers.IO){
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}