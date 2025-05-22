package com.example.habittracker.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HtbTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF0b110c)
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.bodySmall,
            shape = MaterialTheme.shapes.large,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            placeholder = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color(0xFF0b110c),
                unfocusedTextColor = Color(0xFF0b110c),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color(0xfff6f8fa),
                focusedIndicatorColor = Color(0xff4e55e0),
                unfocusedIndicatorColor = Color(0xfff6f8fa),
                focusedPlaceholderColor = Color(0xFFc5c7c8),
                unfocusedPlaceholderColor = Color(0xFFc5c7c8)

            )
        )
    }
}

@Composable
fun HtbMenu(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    label: String,
    selected: String,
    options: List<String>,
    onClick: () -> Unit,
    onSelect: (String) -> Unit,
    onDismissRequest: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF0b110c)
        )
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .background(Color(0xfff6f8fa))
                .fillMaxWidth()
                .clickable { onClick() }
            ,
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = selected,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF0b110c)
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismissRequest,
            containerColor = Color.White
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    },
                    onClick = {
                        onSelect(option)
                        onDismissRequest()
                    },
                    colors = MenuItemColors(
                        textColor = Color(0xFF0b110c),
                        leadingIconColor = Color.Unspecified,
                        trailingIconColor = Color.Unspecified,
                        disabledTextColor = Color.Unspecified,
                        disabledLeadingIconColor = Color.Unspecified,
                        disabledTrailingIconColor = Color.Unspecified
                    )
                )
            }
        }
    }
}