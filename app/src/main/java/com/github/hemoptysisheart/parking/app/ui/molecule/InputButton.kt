package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.preview.PreviewComponent
import com.github.hemoptysisheart.parking.app.ui.preview.preview

@Composable
fun BackButton(
        description: String? = null,
        color: Color = LocalContentColor.current,
        onClick: () -> Unit = { }
) {
    IconButton(onClick = onClick) {
        Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = description,
                tint = color
        )
    }
}

@Composable
fun DropDownButton(
        description: String? = null,
        color: Color = LocalContentColor.current,
        onClick: () -> Unit = { }
) {
    IconButton(onClick = onClick) {
        Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = description,
                tint = color
        )
    }
}

@Composable
fun DropUpButton(
        description: String? = null,
        color: Color = LocalContentColor.current,
        onClick: () -> Unit = { }
) {
    IconButton(onClick = onClick) {
        Icon(
                imageVector = Icons.Default.ArrowDropUp,
                contentDescription = description,
                tint = color
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview_InputButton() {
    PreviewComponent {
        LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            preview(R.string.molecule_input_button_back_label) {
                BackButton(it)
            }

            preview(R.string.molecule_input_button_drop_down_label) {
                DropDownButton(it)
            }

            preview(R.string.molecule_input_button_drop_up_label) {
                DropUpButton(it)
            }
        }
    }
}