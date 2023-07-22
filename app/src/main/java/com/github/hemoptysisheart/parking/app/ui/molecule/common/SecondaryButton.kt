package com.github.hemoptysisheart.parking.app.ui.molecule.common

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

/**
 * 보조 버튼.
 *
 * 보조적인 기능을 제공하는 버튼. 한 화면에서 소수만 노출해야 한다.
 */
@Composable
fun SecondaryButton(label: String, onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true) {
    OutlinedButton(onClick = onClick, modifier = modifier, enabled = enabled) {
        Text(text = label)
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSecondaryButton() {
    ParkingTheme {
        SecondaryButton(label = "보조 버튼", onClick = {})
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSecondaryButtonDisabled() {
    ParkingTheme {
        SecondaryButton(label = "비활성 보조 버튼", onClick = {}, enabled = false)
    }
}