package com.github.hemoptysisheart.parking.app.ui.molecule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.OpenInFull
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.preview.preview

/**
 * [`button/icon/back`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54319-25236&mode=design&t=KO0iRhHsEzhk5ImB-4)
 */
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

/**
 * [`button/icon/settings`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54394-25013&mode=design)
 */
@Composable
fun SettingsButton(
        description: String? = null,
        color: Color = LocalContentColor.current,
        onClick: () -> Unit = { }
) {
    IconButton(onClick = onClick) {
        Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = description,
                tint = color
        )
    }
}

/**
 * [`button/icon/search`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54396-25046&mode=design)
 */
@Composable
fun SearchButton(
        description: String? = null,
        color: Color = LocalContentColor.current,
        onClick: () -> Unit = { }
) {
    IconButton(onClick = onClick) {
        Icon(
                imageVector = Icons.Default.Search,
                contentDescription = description,
                tint = color
        )
    }
}

/**
 * [`button/icon/open_in_full`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1569&mode=design)
 */
@Composable
fun OpenInFullButton(
        description: String? = null,
        color: Color = LocalContentColor.current,
        onClick: () -> Unit = { }
) {
    IconButton(onClick = onClick) {
        Icon(
                imageVector = Icons.Default.OpenInFull,
                contentDescription = description,
                tint = color
        )
    }
}

@Composable
@ComponentPreview
fun Preview_InputButton() {
    ComponentPreviewContainer {
        LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            preview(R.string.molecule_input_button_back_label) {
                BackButton(description = it, color = MaterialTheme.colorScheme.onBackground)
            }

            preview(R.string.molecule_input_button_drop_down_label) {
                DropDownButton(description = it, color = MaterialTheme.colorScheme.onBackground)
            }

            preview(R.string.molecule_input_button_drop_up_label) {
                DropUpButton(description = it, color = MaterialTheme.colorScheme.onBackground)
            }

            preview(R.string.molecule_input_button_settings_label) {
                SettingsButton(description = it, color = MaterialTheme.colorScheme.onBackground)
            }

            preview(R.string.molecule_input_button_search_label) {
                SearchButton(description = it, color = MaterialTheme.colorScheme.onBackground)
            }

            preview(R.string.molecule_input_button_open_in_full_label) {
                OpenInFullButton(description = it, color = MaterialTheme.colorScheme.onBackground)
            }
        }
    }
}