package com.github.hemoptysisheart.parking.app.ui.molcule

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.ui.theme.Typography

/**
 * 클릭하기 쉽게 크기와 패딩을 준 버튼.
 */
@Composable
fun EasyButton(onClick: () -> Unit, label: String, padding: Int = 10) {
    Button(
        onClick = onClick, modifier = Modifier
            .fillMaxWidth()
            .padding(padding.dp)
    ) {
        Text(text = label, style = Typography.labelMedium)
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_EasyButton() {
    ParkingTheme {
        EasyButton(onClick = { /*TODO*/ }, label = "button label")
    }
}