package com.jeremiascortes.ejercicos.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EjercicioOne(modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Ejemplo 01"
            )
        }
        Spacer(Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Ejemeplo 3")
                }
                Spacer(Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Ejemeplo 4")
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = "Ejemplo 4"
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_7_PRO,
    showBackground = true
)
@Composable
fun PreviewEjercicioOne() {
    EjercicioOne(modifier = Modifier)
}