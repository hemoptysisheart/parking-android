package com.github.hemoptysisheart.parking.app.ui.template.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.app.ui.molecule.OpenInFullButton
import com.github.hemoptysisheart.parking.app.ui.molecule.TextBodyMedium
import com.github.hemoptysisheart.parking.app.ui.molecule.TextLabelMedium
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreview
import com.github.hemoptysisheart.parking.app.ui.preview.ComponentPreviewContainer
import com.github.hemoptysisheart.parking.app.ui.template.LOGGER
import com.github.hemoptysisheart.parking.core.domain.search.RecommendItemPlaceImpl
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.search.RecommendItem
import com.github.hemoptysisheart.parking.domain.search.RecommendItemPlace

/**
 * [`destinationSearch/item`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1396&mode=design)
 */
@Composable
fun <T> RecommendItem(item: RecommendItem<T>, gotoSelectParking: (Place) -> Unit = { }) {
    LOGGER.v("#RecommendItem args : item=$item")
    when (item) {
        is RecommendItemPlaceImpl ->
            RecommendItem(item = item, gotoSelectParking)

        else ->
            throw IllegalArgumentException("unsupported type : item.type=${item::class}, item=$item")
    }
}

@Composable
fun RecommendItem(item: RecommendItemPlace, gotoSelectParking: (Place) -> Unit = { }) {
    Row(
            Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp)
    ) {
        Column(modifier = Modifier.weight(1F)) {
            TextLabelMedium(text = item.name)
            Spacer(modifier = Modifier.height(10.dp))
            item.description?.let {
                TextBodyMedium(text = it, color = MaterialTheme.colorScheme.outline)
            }
        }

        OpenInFullButton(color = MaterialTheme.colorScheme.outlineVariant)
    }
}


@Composable
@ComponentPreview
fun Preview_Item() {
    ComponentPreviewContainer {
        //Item()
    }
}
