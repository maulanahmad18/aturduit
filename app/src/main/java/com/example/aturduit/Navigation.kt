package com.example.aturduit


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController




@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HalamanLogin") {
        composable("HalamanLogin") {
            HalamanLogin(navController).showLogin()
        }
        composable("HalamanRegister") {
            HalamanRegister().ShowRegister()
        }
        // Tambahkan tujuan lainnya di sini
    }
}

