package com.metrolist.music.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorPickerDialog(
    initialColor: Color,
    onDismiss: () -> Unit,
    onSave: (Color) -> Unit
) {
    var red by remember { mutableFloatStateOf(initialColor.red * 255f) }
    var green by remember { mutableFloatStateOf(initialColor.green * 255f) }
    var blue by remember { mutableFloatStateOf(initialColor.blue * 255f) }

    val selectedColor = Color(
        red = red / 255f,
        green = green / 255f,
        blue = blue / 255f
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Custom Color")
        },
        text = {
            Column {

                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .background(selectedColor, CircleShape)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(Modifier.height(20.dp))

                Text("Red")
                Slider(
                    value = red,
                    onValueChange = { red = it },
                    valueRange = 0f..255f
                )

                Text("Green")
                Slider(
                    value = green,
                    onValueChange = { green = it },
                    valueRange = 0f..255f
                )

                Text("Blue")
                Slider(
                    value = blue,
                    onValueChange = { blue = it },
                    valueRange = 0f..255f
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onSave(selectedColor)
                }
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}
