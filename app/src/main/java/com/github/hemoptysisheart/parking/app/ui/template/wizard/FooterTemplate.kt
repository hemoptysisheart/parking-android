package com.github.hemoptysisheart.parking.app.ui.template.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.common.PrimaryButton
import com.github.hemoptysisheart.parking.app.ui.molecule.common.SecondaryButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

@Composable
fun FooterTemplate() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 0.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        SecondaryButton(label = "끝내기", onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.weight(1F))
        PrimaryButton(label = "다음", onClick = { /*TODO*/ })
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewFooterTemplate() {
    ParkingTheme {
        FooterTemplate()
    }
}