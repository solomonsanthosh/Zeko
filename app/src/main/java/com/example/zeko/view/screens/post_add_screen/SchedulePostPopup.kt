package com.example.zeko.view.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.zeko.R
import java.util.*


@Composable
fun SchedulePostPopup(
    onDismissRequest: () -> Unit,
    onTimeSelected:(Long) -> Unit,
    onScheduled: () -> Unit
) {
    val year: Int
    val month: Int
    val day: Int


    val mCalendar = Calendar.getInstance()


    year = mCalendar.get(Calendar.YEAR)
    month = mCalendar.get(Calendar.MONTH)
    day = mCalendar.get(Calendar.DAY_OF_MONTH)
    var pickedDate by remember {
        mutableStateOf("Pick a Date")
    }

    var pickedTime by remember {
        mutableStateOf("Pick a Time")
    }
    var showDateDialog by remember {
        mutableStateOf(false)
    }
    var showTimeDialog by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    Popup(
        alignment = Alignment.Center,
        onDismissRequest = onDismissRequest,


        ) {

        Card(


            backgroundColor = colorResource(id = R.color.cardBg),
            modifier = Modifier
                .padding(80.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Schedule a post")
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { showDateDialog = true }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(text = pickedDate)
                }
                Button(
                    onClick = { showTimeDialog = true }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(text = pickedTime)
                }

                if (showDateDialog) {
                    DatePickerDialog(
                        context,
                        DatePickerDialog.OnDateSetListener { view, year, month, day ->
                            pickedDate = "${year}-${month}-${day}"

                            showDateDialog = false
                        },
                        year,
                        month,
                        day
                    ).show()
                }
                if (showTimeDialog) {
                    TimePickerDialog(
                        context,
                        TimePickerDialog.OnTimeSetListener { view, hour, min ->
                            pickedTime = "${hour}:${min}"
                            showTimeDialog = false
                        }, 0, 0, false
                    ).show()
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.green)),
                    onClick = {

                        var dateArray = pickedDate.split("-")
                        var timeArray = pickedTime.split(":")


                        mCalendar.set(dateArray.get(0).toInt(),dateArray.get(1).toInt(),dateArray.get(2).toInt(),timeArray.get(0).toInt(),timeArray.get(1).toInt())
                        onTimeSelected(mCalendar.timeInMillis)
                        onScheduled()
                    }
                ) {
                    Text(text = "Schedule", color = Color.White)
                }
            }
        }
    }
}


