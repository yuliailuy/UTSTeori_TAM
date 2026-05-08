package com.example.utsteori_tam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.utsteori_tam.navigation.AppNavigation
import com.example.utsteori_tam.ui.theme.UTSTeori_TAMTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UTSTeori_TAMTheme {
                AppNavigation()
            }
        }
    }
}