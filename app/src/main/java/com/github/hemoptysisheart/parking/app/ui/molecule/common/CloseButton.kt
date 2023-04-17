package com.github.hemoptysisheart.parking.app.ui.molecule.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun CloseButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(R.string.navi_close_button_description),
            modifier = Modifier.padding(15.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_CloseButton() {
    ParkingTheme {
        CloseButton(onClick = {})
    }
}
