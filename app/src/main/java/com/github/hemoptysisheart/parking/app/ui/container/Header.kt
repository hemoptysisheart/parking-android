package com.github.hemoptysisheart.parking.app.ui.container

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.ui.theme.ParkingTheme

@Composable
fun Header(content: @Composable RowScope.() -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
@Preview
fun HeaderPreview() {
    ParkingTheme {
        Header()
    }
}

@Composable
@Preview
@Suppress("NonAsciiCharacters")
fun `HeaderPreview - 텍스트 입력`() {
    ParkingTheme {
        Header {
            OutlinedTextField(value = "입력", onValueChange = {}, modifier = Modifier.weight(1.0F))
        }
    }
}

@Composable
@Preview
@Suppress("NonAsciiCharacters")
fun `HeaderPreview - 텍스트 입력과 버튼`() {
    ParkingTheme {
        Header {
            OutlinedTextField(value = "입력", onValueChange = {}, modifier = Modifier.weight(1.0F))
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                onClick = { },
                modifier = Modifier.border(1.dp, color = Color.Gray, shape = RoundedCornerShape(5.dp))
            ) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "버튼")
            }
        }
    }
}