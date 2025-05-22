package com.example.habittracker.features.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.R
import com.example.habittracker.core.components.PrimaryButton
import com.example.habittracker.core.theme.HabitTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitDetailModal(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onDone: () -> Unit
) {

    ModalBottomSheet(
        modifier = modifier.statusBarsPadding(),
        sheetState = rememberModalBottomSheetState(true),
        onDismissRequest = onDismissRequest,
        containerColor = Color(0xFFbBeb6c)
    ) {
        Column(
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(20.dp)
                            .clickable { onDismissRequest() },
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color(0xFF0b110c)
                    )
                },
                title = {
                    Text(
                        text = "Meditation",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )

            Spacer(Modifier.height(50.dp))

            Image(
                modifier = Modifier
                    .size(310.dp),
                painter = painterResource(R.drawable.meditation_img),
                contentDescription = null
            )

            Spacer(Modifier.height(40.dp))

            HabitNotes(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Calm music can help you"
            )
            HabitNotes(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                text = "Mindful breathing helps you relax"
            )

            Spacer(Modifier.height(30.dp))

            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Done",
                onClick = onDone
            )
        }
    }

}

@Composable
private fun HabitNotes(
    modifier: Modifier = Modifier,
    text: String,
) {
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .background(Color(0xffc5ee8a))
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF0b110c)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    HabitTrackerTheme {
        HabitDetailModal(
            onDone = {},
            onDismissRequest = {}
        )
    }
}