package com.example.habittracker.core.ui.components

import android.icu.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitTimePicker(
    modifier: Modifier = Modifier,
    onPicked: (String) -> Unit,
) {
    var showTimeDialog by remember { mutableStateOf(false) }
    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (showTimeDialog) {
            HbtTimePickerDialog(
                state = timePickerState,
                onDismiss = { showTimeDialog = false },
                onConfirm = {
                    onPicked(timePickerState.formatedHour())
                    showTimeDialog = false
                }
            )
        }

        Text(
            text = "Remind me at",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF0b110c)
        )
        Row(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .background(Color(0xfff6f8fa))
                .fillMaxWidth()
                .clickable { showTimeDialog = true },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(14.dp),
                text = timePickerState.formatedHour(),
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF0b110c),
                letterSpacing = 2.sp
            )
            Spacer(Modifier.height(10.dp))
            Icon(
                modifier = Modifier.padding(end = 12.dp),
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
private fun TimePickerState.formatedHour(): String {
    val inputFormatter = DateTimeFormatter.ofPattern("H:m")
    val outputFormatter = DateTimeFormatter.ofPattern("hh:mm a")
    val time = LocalTime.parse("${this.hour}:${this.minute}", inputFormatter)
    return time.format(outputFormatter)
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HbtTimePickerDialog(
    state: TimePickerState,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Dismiss")
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("OK")
            }
        },
        text = {
            TimePicker(
                state = state,
            )
        }
    )
}