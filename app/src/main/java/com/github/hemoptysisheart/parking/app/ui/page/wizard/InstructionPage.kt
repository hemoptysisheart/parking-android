package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.interaction.wizard.InstructionInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun InstructionPage(
    interaction: InstructionInteraction
) {
    LOGGER.v("#InstructionPage args : interaction=$interaction")
    Text(text = "wizard : instruction")
}

@Composable
@Preview
fun PreviewWizardPage() {
    ParkingTheme {
        InstructionPage(InstructionInteraction(commonInteraction()))
    }
}
