package com.jeremiascortes.ejercicos

// Añadir al principio del archivo
import androidx.compose.animation.core.tween
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jeremiascortes.ejercicos.ui.theme.EjercicosTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjercicosTheme {
                Screen()
            }
        }
    }
}

@Composable
fun Screen() {
    Column(
        modifier = Modifier.padding(top=24.dp)
    ) {
        AnimatedSlidingToggleButtons()
        AnimatedSlidingToggleButtons2()
    }
}



@Composable
fun AnimatedSlidingToggleButtons(
    options: List<String> = listOf("Opción 1", "Opción 2"),
    activeColor: Color = Color(0xFF2196F3),
    inactiveColor: Color = Color(0xFFE0E0E0),
    textActive: Color = Color.White,
    textInactive: Color = Color.Black,
    animationDuration: Int = 400,
    onSelected: (Int) -> Unit = {}
) {
    var selectedIndex by remember { mutableStateOf(0) }
    val buttonWidth = remember { mutableStateOf(0f) }

    Box(
        Modifier
            .padding(16.dp)
            .height(48.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(inactiveColor)
    ) {
        // Animación de desplazamiento
        val offsetX by animateFloatAsState(
            targetValue = selectedIndex * (buttonWidth.value),
            animationSpec = tween(durationMillis = animationDuration),
            label = "offsetX"
        )

        // Barra deslizante de fondo (sin texto)
        Box(
            Modifier
                .offset { IntOffset(offsetX.toInt(), 0) }
                .width(with(LocalDensity.current) { buttonWidth.value.toDp() })
                .fillMaxHeight()
                .clip(RoundedCornerShape(50, 0, 0, 50))
                .background(activeColor)
        )

        // Texto siempre encima
        Row(
            Modifier.fillMaxSize()
        ) {
            options.forEachIndexed { index, text ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .onGloballyPositioned { coords ->
                            if (index == 0) buttonWidth.value = coords.size.width.toFloat()
                        }
                        .clickable(
                            indication = null, // Esto elimina el efecto visual gris
                            interactionSource = remember { MutableInteractionSource() } // Necesario cuando se quita la indicación
                        ) {
                            if (selectedIndex != index) {
                                selectedIndex = index
                                onSelected(index)
                            }
                        }
                ) {
                    Text(
                        text = text,
                        color = if (selectedIndex == index) textActive else textInactive,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun AnimatedSlidingToggleButtons2(
    options: List<String> = listOf("Opción 1", "Opción 2"),
    activeColor: Color = Color(0xFF2196F3),
    inactiveColor: Color = Color(0xFFE0E0E0),
    textActive: Color = Color.White,
    textInactive: Color = Color.Black,
    animationDuration: Int = 400,
    onSelected: (Int) -> Unit = {}
) {
    var selectedIndex by remember { mutableStateOf(0) }
    val buttonWidth = remember { mutableStateOf(0f) }

    Box(
        Modifier
            .padding(16.dp)
            .height(48.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(inactiveColor)
    ) {
        // Animación de desplazamiento
        val offsetX by animateFloatAsState(
            targetValue = selectedIndex * (buttonWidth.value),
            animationSpec = tween(durationMillis = animationDuration),
            label = "offsetX"
        )

        // Barra deslizante de fondo (sin texto)
        Box(
            Modifier
                .offset { IntOffset(offsetX.toInt(), 0) }
                .width(with(LocalDensity.current) { buttonWidth.value.toDp() })
                .fillMaxHeight()
                .clip(RoundedCornerShape(24.dp))
                .background(activeColor)
        )

        // Texto siempre encima
        Row(
            Modifier.fillMaxSize()
        ) {
            options.forEachIndexed { index, text ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .onGloballyPositioned { coords ->
                            if (index == 0) buttonWidth.value = coords.size.width.toFloat()
                        }
                        .clickable(
                            indication = null, // Esto elimina el efecto visual gris
                            interactionSource = remember { MutableInteractionSource() } // Necesario cuando se quita la indicación
                        ) {
                            if (selectedIndex != index) {
                                selectedIndex = index
                                onSelected(index)
                            }
                        }
                ) {
                    Text(
                        text = text,
                        color = if (selectedIndex == index) textActive else textInactive,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

