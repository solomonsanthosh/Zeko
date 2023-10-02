package com.example.zeko.view.screens.account

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.zeko.data.model.ContactEntity
import com.example.zeko.data.model.UserEntity
import com.example.zeko.viewmodel.UserViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch


@SuppressLint("Range")
@Composable
fun ContactListScreen(authViewModel: UserViewModel) {

    val coroutineScope = rememberCoroutineScope()


    val contentResolver = LocalContext.current.contentResolver



    var contactList by remember {
        mutableStateOf(emptyList<UserEntity>())
    }

    var loading by remember {
        mutableStateOf(true)
    }
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->

            if (isGranted) {
                val cursor = contentResolver.query(
                    ContactsContract.Contacts.CONTENT_URI,
                    null,
                    null,
                    null,
                    null
                )

                // Iterate over the cursor and create a list of contacts.
                val contacts = mutableListOf<UserEntity>()
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        val contact =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                        if(contact != null){
                            val contactId =
                                cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))

                            // Check if the contact has a phone number
                            val hasPhoneNumber =
                                cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                                    .toInt()

                            if (hasPhoneNumber > 0) {
                                val phoneCursor = contentResolver.query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                    null,
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                                    arrayOf(contactId),
                                    null
                                )
                                phoneCursor?.use {
                                    while (phoneCursor.moveToNext()) {
                                        val phoneNumber =
                                            phoneCursor.getString(
                                                phoneCursor.getColumnIndex(
                                                    ContactsContract.CommonDataKinds.Phone.NUMBER
                                                )
                                            )


                                        val number = if(phoneNumber.length > 10) phoneNumber.reversed().substring(0,11).reversed().replace(" ","") else phoneNumber


                                        coroutineScope.launch {
                                            val res = authViewModel.findUserByPhone(number)
                                            val gson = Gson()
                                            if(res.type == "found"){

                                                val jsonTree = gson.toJsonTree(res.data)
                                                contacts.add(gson.fromJson(jsonTree,UserEntity::class.java))

                                                if(cursor.isClosed){
                                                    contactList = contacts

                                                    loading = false
                                                    Log.d("Phone",contacts.toString())
                                                }
                                            }

                                        }



                                        // Process and store the phoneNumber as needed
                                    }
                                }
                            }


                        }


                    }





                }

                // Close the cursor.
                if (cursor != null) {

                        cursor.close()


                }
            } else {
                Log.d("Access","denied")

            }
        }



    fun requestContactsPermission() {
        requestPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
    }

    // Trigger permission request in LaunchedEffect
    LaunchedEffect(Unit) {
        requestContactsPermission()
    }




    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally){





            // Query the Contacts table.
            item {
                Text(text = "Add from contacts",Modifier.padding(15.dp), fontWeight = FontWeight.Medium, color = Color.Yellow)
                Divider(color = Color.DarkGray, thickness = 2.dp)

            }

        if(loading){
            item {
                val strokeWidth = 4.dp

                Box(modifier = Modifier.padding(15.dp)){
                    CircularProgressIndicator(
                        modifier = Modifier.drawBehind {

                            drawCircle(
                                Color.Red,
                                radius = size.width / 2 - strokeWidth.toPx() / 2,
                                style = Stroke(strokeWidth.toPx())
                            )
                        },
                        color = Color.LightGray,
                        strokeWidth = strokeWidth
                    )
                }

            }
        } else {
            if(contactList.isEmpty()){
                item {
                    Text(text = "no Contacts using the app",Modifier.padding(15.dp))
                }
            } else {
                items(contactList) { contact ->

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp)
                    ) {
                        Text(
                            text = contact.name,
                            color = Color.LightGray,

                            fontSize = 19.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Text(
                            modifier = Modifier

                                .clickable {


//
                                    var type = "push"
                                    if (authViewModel.userLiveData.value?.id in contact.followers) {
                                        type = "pull"
                                    }

                                    authViewModel.makeConnection(
                                        contact.id,
                                        { authViewModel.getFollowings(type) },
                                        type
                                    )

                                },
                            text = if (authViewModel.userLiveData.value?.id in contact.followers) {
                                "following"
                            } else {
                                "follow"
                            },
                            fontSize = 15.sp,
                            color = Color.LightGray
                        )
                    }
                    Divider(color = Color.DarkGray, thickness = 2.dp)
                }
            }
        }





        }

}