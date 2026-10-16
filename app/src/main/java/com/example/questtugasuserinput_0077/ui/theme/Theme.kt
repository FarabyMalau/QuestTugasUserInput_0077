package com.example.questtugasuserinput_0077.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.questtugasuserinput_0077.R

@Composable
fun QuestTugasUserInput_0077Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = colorResource(R.color.ungu_judul),
            onPrimary = colorResource(R.color.putih),
            background = colorResource(R.color.putih),
            surface = colorResource(R.color.putih)
        ),
        content = content
    )
}