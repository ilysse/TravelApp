package com.example.travlerer


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : BottomNavItem(
        route = "home",
        icon = Icons.Default.Home,
        label = "Home"
    )

    object Bag : BottomNavItem(
        route = "bag",
        icon = Icons.Default.ShoppingCart,
        label = "Bag"
    )

    object Archive : BottomNavItem(
        route = "archive",
        icon = Icons.Filled.Email,
        label = "Archive"
    )

    object Profile : BottomNavItem(
        route = "profile",
        icon = Icons.Default.Person,
        label = "Profile"
    )
}