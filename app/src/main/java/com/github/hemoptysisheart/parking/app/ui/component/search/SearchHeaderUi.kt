package com.github.hemoptysisheart.parking.app.ui.component.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

/**
 * [header / search / query](https://www.figma.com/file/I3LN6lcAVaAXlNba0kBKPN/Parking?node-id=44%3A739&t=TzUdFxNeMKN4ZpTv-4)
 *
 * @param query 현재의 쿼리.
 * @param onQueryChange 쿼리 변경 리스너.
 * @param onBack 돌아가기 버튼 리스너.
 */
@Composable
fun SearchHeaderUi(query: String = "", onQueryChange: (String) -> Unit = {}, onBack: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.ArrowBack,
            stringResource(R.string.action_move_back),
            Modifier
                .clickable { onBack() }
                .background(Color.White, RoundedCornerShape(20.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
                .padding(5.dp)
        )
        Spacer(Modifier.width(10.dp))
        BasicTextField(
            value = query,
            onValueChange = {
                onQueryChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(20.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
                .padding(10.dp, 6.dp),
            singleLine = true
        )
        // TODO 검색 필터 추가.
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSearchHeaderUi() {
    ParkingTheme {
        SearchHeaderUi()
    }
}
