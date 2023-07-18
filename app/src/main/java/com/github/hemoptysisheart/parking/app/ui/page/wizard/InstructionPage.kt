package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.interaction.wizard.InstructionInteraction
import com.github.hemoptysisheart.parking.app.ui.preview.commonInteraction
import com.github.hemoptysisheart.parking.app.ui.template.wizard.FooterTemplate
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.ui.support.LOGGER_COMPOSE as LOGGER

@Composable
fun InstructionPage(
    interaction: InstructionInteraction
) {
    LOGGER.v("#InstructionPage args : interaction=$interaction")

    Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
        Spacer(modifier = Modifier.weight(1F))
        Text(text = "wizard : instruction", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.weight(1F))
        FooterTemplate(onClickSkip = interaction::skip, onClickNext = interaction::next)
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewInstructionPage() {
    ParkingTheme {
        InstructionPage(InstructionInteraction(commonInteraction()))
    }
}
