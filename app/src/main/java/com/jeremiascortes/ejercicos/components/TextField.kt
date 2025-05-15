package com.jeremiascortes.ejercicos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("Jeremías") }
    var value by remember { mutableStateOf("Jeremías") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTextField(user = user) { user = it }
        MySecondTextField(value = value) { value = it }
        MyAdvanceTextField(value = value) { value = it }
        MyPasswordTextField(value = value) { value = it }
        MyOutlineTextField(value = value) { value = it }
        MyBasicTextField(value = value) { value = it }
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(
        value = user,
        onValueChange = { onUserChange(it) },
        readOnly = user.isEmpty()
    )
}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Box(
                Modifier
                    .size(24.dp)
                    .background(Red)
            )
        },
        label = { Text(text = "A") }
    )
}

@Composable
fun MyAdvanceTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {
            // if (it.contains("a")) {
            onValueChange(it.replace("a", ""))
            // } else {
            // onValueChange(it)
            // }
        }
    )
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden by remember { mutableStateOf(true) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text(text = "Introduce tu contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation()
        else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier
                    .clickable{
                        passwordHidden = !passwordHidden
                    }
                    .padding(end = 8.dp)
            )
        }
    )
}

@Composable
fun MyOutlineTextField(value: String, onValueChange: (String) -> Unit){
    OutlinedTextField(value = value, onValueChange = {onValueChange(it)})
}

@Composable
fun MyBasicTextField(value: String, onValueChange: (String) -> Unit){
    BasicTextField(
        value = value,
        onValueChange = {onValueChange(it)},
        textStyle = LocalTextStyle.current.copy(color = White)
    )
}