package com.github.hemoptysisheart.parking.app.ui.template.search

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.molecule.BackButton
import com.github.hemoptysisheart.parking.app.ui.molecule.SearchButton
import com.github.hemoptysisheart.parking.app.ui.molecule.SettingsButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.support.KEYBOARD_SEARCH

/**
 * [`destinationSearch/header`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1232&mode=design)
 *
 * @param query 검색어
 * @param onChangeQuery 검색어 변경
 * @param onClickBack 돌아가기
 * @param onSearch 키보드 검색 버튼 클릭.
 * @param gotoSearchSetting 검색설정 열기
 */
@Composable
fun Header(
        query: String,
        onChangeQuery: (String) -> Unit = { },
        onClickBack: () -> Unit = { },
        onSearch: () -> Unit = { },
        gotoSearchSetting: () -> Unit = { }
) {
    val bottomColor = MaterialTheme.colorScheme.outlineVariant
    Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .drawBehind {
                        drawLine(
                                color = bottomColor,
                                start = Offset(0F, size.height + 10.dp.toPx()),
                                end = Offset(size.width, size.height + 10.dp.toPx())
                        )
                    },
            verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton(onClick = onClickBack, color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.width(10.dp))
        OutlinedTextField(
                value = query,
                onValueChange = onChangeQuery,
                modifier = Modifier.weight(1F),
                placeholder = {
                    TextBodyMedium(
                            text = stringResource(R.string.page_destination_search_query_placeholder),
                            color = Color.Unspecified,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                    )
                },
                leadingIcon = { SearchButton() },
                keyboardOptions = KEYBOARD_SEARCH,
                keyboardActions = KeyboardActions(onSearch = { onSearch() }),
                singleLine = true,
                shape = RoundedCornerShape(30.dp),
                colors = OutlinedTextFieldDefaults.colors(
                        unfocusedPlaceholderColor = MaterialTheme.colorScheme.outlineVariant,
                        focusedPlaceholderColor = MaterialTheme.colorScheme.outlineVariant
                )
        )
        Spacer(modifier = Modifier.width(10.dp))
        SettingsButton(onClick = gotoSearchSetting, color = MaterialTheme.colorScheme.onBackground)
    }
}


@Composable
@ComponentPreview
fun Preview_Header() {
    ComponentPreviewContainer {
        Header("검색어 검색어 검색어")
    }
}
