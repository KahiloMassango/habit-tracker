package com.example.habittracker.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.habittracker.R

@Composable
fun HabitNotesContainer(
    modifier: Modifier = Modifier,
    notes: List<String>,
    onNotesChange: (index: Int, value: String) -> Unit,
    addNote: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Notes ${notes.size}/3 ",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF0b110c),
            textAlign = TextAlign.Center,
        )

        notes.forEachIndexed { index, value ->
            HabitNoteTextField(
                modifier = Modifier.padding(top = 12.dp),
                text = value,
                onDone = { focusManager.clearFocus() },
                onValueChange = { onNotesChange(index, it) }
            )
        }

        Spacer(Modifier.height(26.dp))
        HbtOutlinedButton(
            modifier = Modifier,
            enabled = notes.size < 3,
            onClick = addNote,
        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "Note",
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Composable
private fun HabitNoteTextField(
    modifier: Modifier = Modifier,
    text: String,
    onDone: () -> Unit,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(R.drawable.grip_vertical),
            contentDescription = null,
            tint = Color.Gray
        )
        HtbTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            placeholder = "Enter none",
            shape = RoundedCornerShape(45),
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { onDone() }
            )
        )

    }
}
