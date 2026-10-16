package com.example.questtugasuserinput_0077

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.questtugasuserinput_0077.ui.theme.QuestTugasUserInput_0077Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestTugasUserInput_0077Theme {
                FormBiodataScreen()
            }
        }
    }
}