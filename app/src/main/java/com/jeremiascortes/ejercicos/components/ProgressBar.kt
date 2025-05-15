package com.jeremiascortes.ejercicos.components

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp

@Composable
fun MyProgress(modifier: Modifier) {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 5.dp
            )
            LinearProgressIndicator(
                Modifier.padding(top = 32.dp),
                color = Color.Green,
                trackColor = Color.Gray
            )
        }
        Button(onClick = { showLoading = !showLoading }, modifier = Modifier.padding(vertical = 12.dp)) {
            Text(
                if (showLoading) "Ocultar progreso" else "Mostrar progreso"
            )
        }
        MyProgressAdvance()

    }
}

@Composable
fun MyProgressAdvance() {
    var progress by remember { mutableFloatStateOf(.1f) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progress, modifier = Modifier.padding(vertical = 12.dp))
        LinearProgressIndicator(progress = progress, modifier = Modifier.padding(vertical = 12.dp))
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { progress += .1f }) { Text("+") }
            Button(onClick = { progress -= .1f }) { Text("-") }
        }
    }
}