package com.github.hemoptysisheart.parking.app.ui.page.wizard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.interaction.baseInteraction
import com.github.hemoptysisheart.parking.app.interaction.wizard.InstructionInteraction
import com.github.hemoptysisheart.parking.app.ui.molcule.EasyButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.ui.theme.Typography

@Composable
fun InstructionPage(interaction: InstructionInteraction) {
    Column(Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1F))
        Text(
            text = """
                파킹은 도심지에서 목적지 근처 주차장을 찾아줍니다.
                """.trimIndent(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            style = Typography.bodyLarge
        )
        EasyButton(onClick = interaction::close, label = "마법사 종료")
        EasyButton(onClick = interaction::gotoLocation, label = "다음")
        Spacer(modifier = Modifier.weight(1F))
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview_InstructionPage() {
    ParkingTheme {
        InstructionPage(interaction = InstructionInteraction(baseInteraction(PreviewActivity())))
    }
}
