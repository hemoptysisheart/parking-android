package com.github.hemoptysisheart.parking.app.ui.page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun WizardPage() {
    Text(text = "wizard")
}

@Composable
@Preview
fun PreviewWizardPage() {
    ParkingTheme {
        WizardPage()
    }
}
