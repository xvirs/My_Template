package com.project.mytemplate.presentation.navegation

import androidx.annotation.StringRes
import com.project.mytemplate.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Screen1 : Screen("screen1", R.string.screen1)
    object Screen2 : Screen("screen2", R.string.screen2)
    object Screen3 : Screen("screen3", R.string.screen3)
}

