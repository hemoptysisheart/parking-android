package com.github.hemoptysisheart.parking.app.ui.template.wizard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.molecule.common.PrimaryButton
import com.github.hemoptysisheart.parking.app.ui.molecule.common.SecondaryButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun FooterTemplate(onClickSkip: () -> Unit, onClickNext: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        SecondaryButton(label = "끝내기", onClick = onClickSkip)
        Spacer(modifier = Modifier.weight(1F))
        PrimaryButton(label = "다음", onClick =onClickNext)
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewFooterTemplate() {
    ParkingTheme {
        FooterTemplate(onClickSkip = {}, onClickNext = {})
    }
}