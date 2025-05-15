package com.jeremiascortes.ejercicos.components

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun MyTexts(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Jeremías")
        Text(text = "Jeremías", color = Color.Red)
        Text(text = "Jeremías con Font Size", fontSize = 24.sp)
        Text(text = "Jeremías con Font Style", fontStyle = FontStyle.Italic)
        Text(text = "Jeremías con Font Family", fontFamily = FontFamily.Cursive)
        Text(text = "Jeremías con Font Weight", fontWeight = FontWeight.ExtraBold)
        Text(
            text = "Jeremías con todas las ediciones",
            color = Color.Blue,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        Text("LetterSpacing", letterSpacing = 14.sp)
        Text("LetterSpacing", textDecoration = TextDecoration.LineThrough)
        Text(
            "LetterSpacing",
            textDecoration = TextDecoration.LineThrough + TextDecoration.Underline
        )
        Text("Align", Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(
            text = "Align Align Align Align Align Align Align Align Align Align",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}