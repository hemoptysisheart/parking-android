package com.github.hemoptysisheart.parking.app.ui.molecule.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun GoBackButton(onClick: () -> Unit = {}) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.go_back_button_description),
            modifier = Modifier.padding(15.dp)
        )
    }
}

@Composable
@Preview
fun Preview_GoBackButton() {
    ParkingTheme {
        GoBackButton()
    }
}
