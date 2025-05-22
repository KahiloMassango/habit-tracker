package com.example.habittracker.features.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.habittracker.R

@Composable
fun HbtBottomBar(
    modifier: Modifier = Modifier,
    onAddHabitClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = Color.White,
        contentColor = Color(0xFF0b110c)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                }
                FloatingActionButton(
                    onClick = onAddHabitClick,
                    containerColor = Color(0xff4e55e0),
                    contentColor = Color.White
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(50))
                        .clickable { onProfileClick() },
                    painter = painterResource(R.drawable.welcome_img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

            }
        }
    }
}
