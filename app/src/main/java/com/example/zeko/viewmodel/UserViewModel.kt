package com.example.zeko.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeko.data.model.UserEntity
import com.example.zeko.data.usecase.getUserUseCase
import com.example.zeko.data.usecase.makeConnectionUseCase
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class UserViewModel @Inject constructor(

    val getUserUseCase: getUserUseCase,
    val makeConnectionUseCase: makeConnectionUseCase

) : ViewModel() {


    val userLiveData = MutableLiveData<UserEntity?>()


    private var auth: FirebaseAuth


    init {
        auth = FirebaseAuth.getInstance()
    }


    suspend fun getUser(email: String, password: String): UserEntity? {

//        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
//            if (it.isSuccessful) {
//
////                viewModelScope.launch {
////                    val user = getUserUseCase.execute(email)
////                    userLiveData.postValue(user)
////
////                }
//                return coroutineScope {
//                    val response = async {
//                        getUserUseCase.execute(email)
//                    }
//
//                    response.await()
//                }
//
//
//            } else {
//
//                Log.e("AuthError", it.exception?.localizedMessage?.toString() ?: "")
//                userLiveData.postValue(null)
//
//            }
//            return@addOnCompleteListener
        return suspendCoroutine { continuation ->
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { authResult ->
                if (authResult.isSuccessful) {
                    val user = auth.currentUser
                    if (user != null) {
                        // User is authenticated, execute the getUserUseCase
                        viewModelScope.launch {
                            val response = getUserUseCase.execute(email)
                            userLiveData.postValue(response)
                            continuation.resume(response)
                        }
                    } else {
                        continuation.resume(null) // No authenticated user
                    }
                } else {
                    Log.e("AuthError", authResult.exception?.localizedMessage ?: "")
                    continuation.resume(null) // Authentication failed
                }
            }
        }

    }


    fun makeConnection(followerid: String, getPost: () -> Unit,type:String) {

        val body =
            mapOf<String, String>("userid" to userLiveData.value!!.id, "followerid" to followerid,"type" to type)

        viewModelScope.launch {
            val res = makeConnectionUseCase.execute(body)
            if(res.type == "success"){
                getPost()
            }
        }


    }


}
