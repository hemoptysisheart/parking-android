package com.github.hemoptysisheart.parking.app.ui.molecule.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

/**
 * 중요 버튼.
 *
 * 화면에서 가장 중요한 기능을 작동시키는 버튼. 되도록 한 화면에 1개만 노출해야 한다.
 */
@Composable
fun PrimaryButton(label: String, onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true) {
    Button(onClick = onClick, modifier = modifier, enabled = enabled) {
        Text(text = label)
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPrimaryButton() {
    ParkingTheme {
        PrimaryButton(label = "메인 버튼", onClick = {})
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPrimaryButtonDisabled() {
    ParkingTheme {
        PrimaryButton(label = "비활성 메인 버튼", onClick = {}, enabled = false)
    }
}