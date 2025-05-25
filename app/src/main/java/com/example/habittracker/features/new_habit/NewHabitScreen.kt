package com.example.habittracker.features.new_habit

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.core.model.DayOfWeek
import com.example.habittracker.core.model.Frequency
import com.example.habittracker.core.ui.components.DaysOfWeekSelector
import com.example.habittracker.core.ui.components.FrequencySelector
import com.example.habittracker.core.ui.components.HabitNotesContainer
import com.example.habittracker.core.ui.components.HabitTimePicker
import com.example.habittracker.core.ui.components.HtbTextField
import com.example.habittracker.core.ui.components.PrimaryButton
import com.example.habittracker.core.ui.theme.HabitTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewHabitScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    var name by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var frequency by remember { mutableStateOf(Frequency.DAILY) }
    var selectedDays = remember { mutableStateSetOf<DayOfWeek>(DayOfWeek.MON) }
    val notes = remember { mutableStateListOf<String>("") }


    val focusManager = LocalFocusManager.current
    Scaffold(
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures { focusManager.clearFocus() }
            },
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateUp
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(20.dp),
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color(0xFF0b110c)
                        )
                    }
                },
                title = {
                    Text(
                        text = "Let's start a new habit",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
                .animateContentSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {

            HtbTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Name",
                value = name,
                placeholder = "Type habit name",
                onValueChange = { name = it },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) })
            )

            HtbTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Description",
                value = description,
                placeholder = "Describe a habit",
                onValueChange = { description = it },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
            )

            FrequencySelector(
                selected = frequency,
                onSelect = { frequency = it }
            )
            DaysOfWeekSelector(
                selectedDays = selectedDays,
                enabled = frequency == Frequency.WEEKLY,
                onSelect = {
                    if (it in selectedDays) selectedDays.remove(it) else selectedDays.add(it)
                }
            )
            HabitTimePicker(
                onPicked = { hour -> }
            )
            HabitNotesContainer(
                notes = notes,
                onNotesChange = { index, value -> notes[index] = value },
                addNote = { notes.add("") }
            )

            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Save",
                containerColor = Color(0xff4e55e0),
                contentColor = Color.White,
                onClick = {  }
            )

        }
    }
}




@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Private() {
    HabitTrackerTheme {
        NewHabitScreen(
            onNavigateUp = {},
        )
    }
}