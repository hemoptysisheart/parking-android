package com.github.hemoptysisheart.parking.app.ui.template

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.ui.support.detail
import com.github.hemoptysisheart.parking.app.ui.support.title
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.ui.theme.Typography
import com.github.hemoptysisheart.parking.core.util.AndroidMessageException

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun GlobalAlertDialog(
        error: AndroidMessageException,
        onClearError: () -> Unit = {}
) {
    AlertDialog(onDismissRequest = onClearError) {
        Column(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(20.dp))
                        .padding(10.dp)
        ) {
            Text(
                    text = error.title(),
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = Typography.titleMedium
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = error.detail(), color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onClearError, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.global_header_close_alert_dialog))
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
fun GlobalAlertDialogLight() {
    ParkingTheme {
        GlobalAlertDialog(error = AndroidMessageException(null, R.string.global_header_error_default_detail))
    }
}

@Composable
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
fun GlobalAlertDialogDark() {
    ParkingTheme {
        GlobalAlertDialog(error = AndroidMessageException(null, R.string.global_header_error_default_detail))
    }
}
