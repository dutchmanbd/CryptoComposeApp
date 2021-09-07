package com.ticonsys.cryptocomposeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ticonsys.cryptocomposeapp.presentation.coin.detail.CoinDetailScreen
import com.ticonsys.cryptocomposeapp.presentation.coin.list.CoinListScreen
import com.ticonsys.cryptocomposeapp.presentation.ui.theme.CryptoComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoComposeAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController = navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coin_id}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
