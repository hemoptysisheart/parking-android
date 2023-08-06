package com.github.hemoptysisheart.parking.app.ui.template.setting

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewComponent

/**
 * 설정 항목의 상세 화면.
 *
 * 레이아웃을 잡아준다.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingItemDetail(
        @StringRes title: Int,
        onBack: () -> Unit,
        content: @Composable ColumnScope.() -> Unit
) {
    LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Top
    ) {
        stickyHeader {
            SettingHeader(
                    title = title,
                    onBack = onBack
            )
        }

        item {
            Column(Modifier.padding(20.dp, 0.dp)) {
                content()
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
fun PreviewApp_SettingItemDetail() {
    PreviewComponent {
        SettingItemDetail(
                title = R.string.template_setting_item_distance_title,
                onBack = { /*TODO*/ }
        ) {
            (1..50).forEach {
                Text(text = "$it", color = MaterialTheme.colorScheme.onBackground)
            }
        }
    }
}