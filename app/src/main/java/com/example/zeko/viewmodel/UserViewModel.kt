package com.example.zeko.viewmodel

import android.provider.ContactsContract
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zeko.data.model.ResponseEntity
import com.example.zeko.data.model.UserEntity
import com.example.zeko.data.usecase.getFollowingUseCase
import com.example.zeko.data.usecase.getUserByPhoneUseCase
import com.example.zeko.data.usecase.getUserUseCase
import com.example.zeko.data.usecase.makeConnectionUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class UserViewModel @Inject constructor(

    val getUserUseCase: getUserUseCase,
    val getFollowingUseCase: getFollowingUseCase,
    val makeConnectionUseCase: makeConnectionUseCase,
    val getUserByPhoneUseCase: getUserByPhoneUseCase

) : ViewModel() {


    val userLiveData = MutableLiveData<UserEntity?>()

    val followings = MutableLiveData<List<UserEntity>>()

    private var auth: FirebaseAuth


    init {
        auth = FirebaseAuth.getInstance()
    }


    suspend fun getUser(email: String, password: String): UserEntity? {


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
                    continuation.resume(null) // Authentication faile
                }
            }
        }

    }
// fun getUser(email: String, password: String): UserEntity? {
//
//
//
//        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { authResult ->
//            if (authResult.isSuccessful) {
//                val user = auth.currentUser
//                if (user != null) {
//                    // User is authenticated, execute the getUserUseCase
//                    viewModelScope.launch {
//                        val response = getUserUseCase.execute(email)
//                        userLiveData.postValue(response)
//                        withContext(Dispatchers.Main){
//                            return response
//
//                        }
//
//                    }
//                } else {
//                    Log.e("AuthError",  "User is not present")
//
//                    // No authenticated user
//                }
//            } else {
//                Log.e("AuthError", authResult.exception?.localizedMessage ?: "")
//            }
//        }
//
//
//}


    fun makeConnection(followerid: String, getPost: () -> Unit,type:String) {

        val body =
            mapOf<String, String>("userid" to userLiveData.value!!.id, "followerid" to followerid,"type" to type)

        viewModelScope.launch {
            val res = makeConnectionUseCase.execute(body)
            if(res.type == "success"){
                getPost()
                val response = getUserUseCase.execute(userLiveData.value!!.email)
                userLiveData.postValue(response)
            }
        }


    }

    fun getFollowings(type:String){

        viewModelScope.launch {
            followings.value = getFollowingUseCase.execute(userLiveData.value!!.id,type)
        }



    }

   suspend fun findUserByPhone(number:String):ResponseEntity{

        return suspendCoroutine { continuation ->
            viewModelScope.launch {
               val res = getUserByPhoneUseCase.execute(number)
                continuation.resume(res)
            }
        }


    }







}
