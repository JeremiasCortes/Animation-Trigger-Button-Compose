package com.jeremiascortes.ejercicos.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySwitchs(modifier: Modifier) {
    var status by rememberSaveable { mutableStateOf(true) }
    val checkInfo = CheckInfo(
        title = "Ejemeplo 1",
        selected = status,
        onCheckedChange = {myNewStatus -> status = myNewStatus}
    )
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MySwitch(checkInfo = checkInfo)
        MyCheckBox(checkInfo = checkInfo)
        MyCheckWithText(checkInfo = checkInfo)
    }
}

@Composable
fun MySwitch(checkInfo: CheckInfo) {
    Switch(
        checked = checkInfo.selected,
        onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackColor = Color.Cyan
        )
    )
}

@Composable
fun MyCheckBox(checkInfo: CheckInfo) {
    Checkbox(
        checked = checkInfo.selected,
        onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Blue,
            checkmarkColor = Color.Green
        )
    )
}

@Composable
fun MyCheckWithText(checkInfo: CheckInfo) {
    Row(modifier = Modifier.padding(8.dp)){
        Checkbox(checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Hello Jeremías Cortés")
    }
}