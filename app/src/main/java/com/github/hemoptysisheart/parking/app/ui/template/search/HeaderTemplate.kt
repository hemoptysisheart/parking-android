package com.github.hemoptysisheart.parking.app.ui.template.search

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.common.BackButton
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme

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
        BackButton(onBack)
        TextField(value = query, onValueChange = onQueryChange, modifier = Modifier.weight(1f), singleLine = true)
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
