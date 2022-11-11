package com.github.hemoptysisheart.parking.app.ui.component.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun SearchHeader(navController: NavHostController = rememberNavController()) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Icon(
            Icons.Default.ArrowBack,
            stringResource(R.string.action_move_back),
            Modifier
                .clickable { navController.popBackStack() }
                .background(Color.White, RoundedCornerShape(20.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
                .padding(5.dp)
        )
    }
}

@Composable
@Preview
fun SearchHeaderPreview() {
    ParkingTheme {
        SearchHeader()
    }
}