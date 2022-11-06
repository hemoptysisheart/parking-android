package com.github.hemoptysisheart.parking.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.app.ui.component.map.MapView
import com.github.hemoptysisheart.parking.app.ui.configuration.NavGraphConstant.Destination
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * 기본 액티비티.
 *
 * 지도 화면 등.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        private val TAG = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ParkingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainLayout()
                }
            }
        }
    }
}

@Composable
fun MainLayout(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, Destination.MAP_VIEW) {
        composable(Destination.MAP_VIEW) { MapView() }
    }
}

@Composable
@Preview(showBackground = true)
fun MainLayoutPreview() {
    ParkingTheme {
        MainLayout()
    }
}
