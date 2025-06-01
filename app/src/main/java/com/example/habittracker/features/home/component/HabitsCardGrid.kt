package com.example.habittracker.features.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HabitsCardGrid(
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit
) {
    LazyHorizontalGrid(
        modifier = modifier,
        rows = GridCells.Adaptive(125.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(9) {
            HabitCard(
                modifier = Modifier
                    .width(260.dp)
                    .fillMaxHeight(),
                onClick = onCardClick
            )
        }
    }
}
