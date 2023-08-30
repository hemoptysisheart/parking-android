package com.github.hemoptysisheart.parking.app.ui.template.search

import androidx.compose.foundation.clickable
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
import com.github.hemoptysisheart.parking.domain.common.Object
import com.github.hemoptysisheart.parking.domain.place.Place
import com.github.hemoptysisheart.parking.domain.search.RecommendItem

/**
 * [`destinationSearch/item`](https://www.figma.com/file/4ddVw1GJttHudAFojZRj1s/Parking?type=design&node-id=54416-1396&mode=design)
 */
@Composable
fun RecommendItem(
        item: RecommendItem<out Object>,
        gotoSelectParking: (Place) -> Unit = { },
        showItemDetail: (Object) -> Unit
) {
    LOGGER.v("#RecommendItem args : item=$item")
    item.item.let {
        when (it) {
            is Place ->
                RecommendItemPlace(
                        item = it,
                        gotoSelectParking = gotoSelectParking,
                        showPlaceDetail = showItemDetail
                )

            else ->
                throw IllegalArgumentException("unsupported type : item.type=${item::class}, item=$item")
        }
    }
}

@Composable
private fun RecommendItemPlace(
        item: Place,
        gotoSelectParking: (Place) -> Unit = { },
        showPlaceDetail: (Place) -> Unit = { }
) {
    Row(
            Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp)
    ) {
        Column(
                Modifier
                        .weight(1F)
                        .clickable { gotoSelectParking(item) }
        ) {
            TextLabelMedium(text = item.name, color = MaterialTheme.colorScheme.onBackground)
            Spacer(modifier = Modifier.height(10.dp))
            TextBodyMedium(text = item.address, color = MaterialTheme.colorScheme.outline)
        }

        OpenInFullButton(
                color = MaterialTheme.colorScheme.outlineVariant,
                onClick = { showPlaceDetail(item) }
        )
    }
}

@Composable
@ComponentPreview
fun Preview_RecommendItem() {
    ComponentPreviewContainer {
        //Item()
    }
}
