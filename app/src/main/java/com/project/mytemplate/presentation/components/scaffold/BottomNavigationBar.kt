package com.project.mytemplate.presentation.components.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.project.mytemplate.presentation.navegation.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    var selectedItem by remember { mutableIntStateOf(0) }

    val items = listOf(
        NavigationItem("Home", Icons.Filled.Home, Screen.Screen1.route),
        NavigationItem("Cargar", Icons.Filled.Add, Screen.Screen2.route),
        NavigationItem("Favorito", Icons.Filled.Favorite, Screen.Screen3.route)
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)
