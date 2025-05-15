package com.jeremiascortes.ejercicos.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ExerciseTwo(modifier: androidx.compose.ui.Modifier){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow, boxCyan, boxBlack, boxBlue, boxDarkGrey) = createRefs()
        Box(Modifier.size(175.dp).background(Color.Cyan).constrainAs(boxCyan){
            bottom.linkTo(boxMagenta.top)
            end.linkTo(boxMagenta.end)

        })

        Box(Modifier.size(175.dp).background(Color.Gray).constrainAs(boxDarkGrey){
            start.linkTo(boxGreen.start)
            bottom.linkTo(boxGreen.top)

        })

        Box(Modifier.size(75.dp).background(Color.Black).constrainAs(boxBlack){
            start.linkTo(boxCyan.end)
            bottom.linkTo(boxCyan.bottom)
            top.linkTo(boxCyan.top)
        })

        Box(Modifier.size(175.dp).background(Color.Blue).constrainAs(boxBlue){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxGray.top)
        })

        Box(Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(boxYellow.bottom)
            start.linkTo(boxYellow.end)
        })

        Box(Modifier.size(75.dp).background(Color.Gray).constrainAs(boxGray){
            top.linkTo(boxYellow.bottom)
            end.linkTo(boxYellow.start)
        })

        Box(Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen){
            bottom.linkTo(boxYellow.top)
            start.linkTo(boxYellow.end)
        })


        Box(Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxYellow.top)
            end.linkTo(boxYellow.start)
        })

        Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })


    }
}