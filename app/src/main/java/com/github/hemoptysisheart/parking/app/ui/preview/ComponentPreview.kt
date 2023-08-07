package com.github.hemoptysisheart.parking.app.ui.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
        name = "small font",
        group = "light theme",
        showBackground = true,
        fontScale = 0.85F,
        uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
        name = "regular font",
        group = "light theme",
        showBackground = true,
        fontScale = 1F,
        uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
        name = "large font",
        group = "light theme",
        showBackground = true,
        fontScale = 1.15F,
        uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
        name = "extra large font",
        group = "light theme",
        showBackground = true,
        fontScale = 1.3F,
        uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
        name = "small font",
        group = "dark theme",
        showBackground = true,
        fontScale = 0.85F,
        uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
        name = "regular font",
        group = "dark theme",
        showBackground = true,
        fontScale = 1F,
        uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
        name = "large font",
        group = "dark theme",
        showBackground = true,
        fontScale = 1.15F,
        uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
        name = "extra large font",
        group = "dark theme",
        showBackground = true,
        fontScale = 1.3F,
        uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class ComponentPreview
