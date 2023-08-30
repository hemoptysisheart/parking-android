package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.interaction.wizard.InstructionInteraction
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextTitleLarge
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreview
import com.github.hemoptysisheart.parking.app.ui.preview.PagePreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.WizardFooter

@Composable
fun InstructionPageContent(
        interaction: InstructionInteraction,
        closable: Boolean
) {
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(20.dp, 0.dp)
    ) {
        Spacer(modifier = Modifier.weight(1F))
        TextTitleLarge(
                text = stringResource(R.string.page_wizard_instruction_title),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 20.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
        )
        TextBodyMedium(
                text = stringResource(R.string.page_wizard_instruction_detail),
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 10.dp),
                color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.weight(2F))
        WizardFooter(
                closeEnable = closable,
                onClose = interaction::close,
                onNext = interaction::gotoLocation
        )
    }
}

@Composable
@PagePreview
fun Preview_InstructionPageContent() {
    PagePreviewContainer {
        InstructionPageContent(InstructionInteraction(it), true)
    }
}
