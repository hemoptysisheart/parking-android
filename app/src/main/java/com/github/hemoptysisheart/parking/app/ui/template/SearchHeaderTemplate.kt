package com.github.hemoptysisheart.parking.app.ui.template

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun SearchHeaderTemplate(
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    onBack: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBack, modifier = Modifier.padding(10.dp)) {
            Icon(
                imageVector = Icons.Default.Backspace,
                contentDescription = stringResource(R.string.label_move_back)
            )
        }
        TextField(value = query, onValueChange = onQueryChange, modifier = Modifier.weight(1f))
    }
}

@Composable
@Preview
@Suppress("NonAsciiCharacters")
fun Preview_SearchHeaderTemplate_빈_검색어() {
    ParkingTheme {
        SearchHeaderTemplate()
    }
}

@Composable
@Preview
@Suppress("NonAsciiCharacters")
fun Preview_SearchHeaderTemplate_검색어() {
    ParkingTheme {
        SearchHeaderTemplate(query = "검색어")
    }
}
