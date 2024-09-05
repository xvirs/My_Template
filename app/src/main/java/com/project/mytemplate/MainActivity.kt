package com.project.mytemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.project.mytemplate.presentation.navegation.AppNavigation
import com.project.mytemplate.presentation.ui.theme.MyTemplateTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private var isLoading by mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            delay(4000)
            isLoading = false
        }

        setContent {
            MyTemplateTheme(
                dynamicColor = true,
            ) {
                val navController = rememberNavController()
                AppNavigation(navController)
//                Scaffold()
//                if (isLoading){
//                    Loading()
//                } else {
//                    AppNavigation(navController)
//                }
            }
        }



    }
}
