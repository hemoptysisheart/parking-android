package com.github.hemoptysisheart.parking.app.ui.template.setting

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewComponent
import java.util.UUID

/**
 * 설정 항목의 상세 화면.
 *
 * 레이아웃을 잡아준다.
 */
@Composable
fun SettingItemDetail(
        @StringRes title: Int,
        onBack: () -> Unit,
        content: @Composable () -> Unit
) {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (headerRef, contentRef) = createRefs()
        val state = rememberScrollState(0)

        SettingHeader(
                title = title,
                modifier = Modifier.constrainAs(headerRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                onBack = onBack
        )

        Column(
                modifier = Modifier
                        .constrainAs(contentRef) {
                            top.linkTo(headerRef.bottom)
                            start.linkTo(parent.start, 100.dp)
                            end.linkTo(parent.end, 100.dp)
                        }
                        .verticalScroll(state),
                verticalArrangement = Arrangement.Top
        ) {
            content()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_SettingItemDetail() {
    PreviewComponent {
        SettingItemDetail(
                title = R.string.template_setting_item_distance_title,
                onBack = { /*TODO*/ }
        ) {
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
            Text(text = "${UUID.randomUUID()}", Modifier.padding(20.dp))
        }
    }
}