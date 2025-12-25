package ru.justneedcoffee.zennotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import ru.justneedcoffee.zennotes.ui.screens.MainScreen
import ru.justneedcoffee.zennotes.ui.theme.ZenNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ZenNotesTheme {
                MainScreen()
            }
        }
    }
}