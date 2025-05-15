package com.jeremiascortes.ejercicos.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyButtons(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {  },
            enabled = true,
            shape = RoundedCornerShape(20),
            border = BorderStroke(3.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.Cyan
            )
        ){
            Text("Pulsame")
        }

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Unspecified,
                containerColor = Color.Unspecified,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            )
        ) {
            Text("Botón Outline")
        }

        TextButton(onClick = {}) {
            Text("Botón de TextButton")
        }

        FilledTonalButton(onClick = {}) { }
        Button(onClick = {}) { }
    }
}