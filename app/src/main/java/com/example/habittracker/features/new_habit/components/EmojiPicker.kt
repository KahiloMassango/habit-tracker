package com.example.habittracker.features.new_habit.components

import android.view.ViewGroup
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.emoji2.emojipicker.EmojiPickerView
import com.example.habittracker.core.ui.theme.HabitTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmojiPicker(
    modifier: Modifier = Modifier,
    selectedIcon: String,
    selectedColor: Color,
    onSelectIcon: (String) -> Unit,
    onSelectColor: (Color) -> Unit,
    onDismiss: () -> Unit,
) {
    ModalBottomSheet(
        modifier = modifier,
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Select Icon & Color",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xff4e55e0)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Box(
                    modifier = modifier
                        .clip(MaterialTheme.shapes.large)
                        .background(selectedColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = selectedIcon,
                        fontSize = 28.sp,
                    )
                }
                ColorPickerGrid(
                    selectedColor = selectedColor,
                    colors = colors,
                    onSelectColor = onSelectColor

                )
            }
            EmojiKeyboard(
                modifier = Modifier,
                onEmojiSelected = onSelectIcon
            )
        }
    }
}

val colors = listOf(
    Color(0xff4e55e0),
    Color(0xFFbBeb6c),
    Color(0xFFf7cd63),
    Color(0xFFfc8fc6),
    Color(0xFFbBeb6c),
    Color(0xFFf7cd63),
    Color(0xff4e55e0),
    Color(0xFFfc8fc6),
    Color(0xFFbBeb6c),
)

@Composable
fun IconsBox(
    modifier: Modifier = Modifier,
    icon: String,
    backgroundColor: Color,
) {
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(12.dp),
            text = icon,
            fontSize = 28.sp,
        )

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .align(Alignment.TopEnd)
                .background(Color(0xfff3f9ff))
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = Color(0xff9c9ea5)
            )
        }
    }
}

@Composable
private fun ColorPickerGrid(
    modifier: Modifier = Modifier,
    selectedColor: Color,
    colors: List<Color>,
    onSelectColor: (Color) -> Unit,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(5),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(colors) { color ->
            Box(
                contentAlignment = Alignment.Center
            ) {
                ColorBox(
                    color = color,
                    isSelected = color == selectedColor,
                    onClick = { onSelectColor(color) }
                )
            }
        }
    }
}

@Composable
private fun ColorBox(
    modifier: Modifier = Modifier,
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color)
            .size(30.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = isSelected
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = Icons.Default.Done,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}


@Composable
private fun EmojiKeyboard(
    modifier: Modifier = Modifier,
    onEmojiSelected: (String) -> Unit,
) {
    val context = LocalContext.current
    val emojiPickerView = EmojiPickerView(context).apply {
        emojiGridColumns = 8
        emojiGridRows = 5f
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    AndroidView(
        modifier = modifier
            .fillMaxWidth()
            .height(400.dp),
        factory = { emojiPickerView },
        update = { view ->
            view.setOnEmojiPickedListener {
                onEmojiSelected(it.emoji)
            }
        }
    )

}




@Preview
@Composable
private fun Preview() {
    HabitTrackerTheme {
        EmojiPicker(
            selectedIcon = "😇",
            selectedColor = Color(0xff4e55e0),
            onSelectIcon = {},
            onSelectColor = {},
            onDismiss = {}
        )
    }
}

