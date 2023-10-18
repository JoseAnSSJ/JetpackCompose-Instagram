package com.example.jetpackcomposeinstagram.login

import com.example.jetpackcomposeinstagram.core.RepositoryLogin
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val repositoryLogin: RepositoryLogin) {

    suspend operator fun invoke(user:String, pass:String):Boolean{
        return repositoryLogin.doLogin(user,pass)
    }
}