package com.example.habittracker.features.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.core.components.HtbMenu
import com.example.habittracker.core.components.HtbTextField
import com.example.habittracker.core.theme.HabitTrackerTheme

@Composable
fun AddHabitModal(
    modifier: Modifier = Modifier,
    onSave: () -> Unit
) {
    var name by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var interval by remember { mutableStateOf("Every day") }
    var expandedMenu by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ){
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFf4f8f7))
                    .clickable {},
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(20.dp),
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color(0xFF0b110c)
                )
            }
            Text(
                text = "Let's start a new habit",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(Modifier.height(30.dp))

        HtbTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Name",
            value = name,
            placeholder = "Type habit name",
            onValueChange = { name = it }
        )
        Spacer(Modifier.height(25.dp))
        HtbTextField(
            modifier = Modifier.fillMaxWidth(),
            label = "Description",
            value = description,
            placeholder = "Describe a habit",
            onValueChange = { description = it }
        )
        Spacer(Modifier.height(25.dp))
        HtbMenu(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expandedMenu = true },
            expanded = expandedMenu,
            label = "Interval",
            selected = interval,
            options = listOf("Every day", "Weekly", "Monthly"),
            onSelect = { interval = it },
            onDismissRequest = { expandedMenu = false }
        )
        Spacer(Modifier.height(25.dp))
        Text(
            text = "Icon",
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF0b110c)
        )

        LazyVerticalGrid(
            modifier = Modifier.padding(top = 4.dp),
            columns = GridCells.Adaptive(70.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(30) {
                Box(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .background(colors.random().copy(alpha = 0.9f))
                        .clickable {},
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        modifier = Modifier.padding(vertical = 24.dp),
                        tint = Color(0xFF0b110c),
                        imageVector = Icons.Default.Work,
                        contentDescription = null
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Private() {
    HabitTrackerTheme {
        AddHabitModal(
            onSave = {}
        )
    }
}