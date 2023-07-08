package com.github.hemoptysisheart.parking.app.ui.page

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.hemoptysisheart.parking.R
import com.github.hemoptysisheart.parking.app.activity.MainActivity
import com.github.hemoptysisheart.parking.app.activity.WizardActivity
import com.github.hemoptysisheart.parking.app.ui.theme.ParkingTheme
import com.github.hemoptysisheart.parking.app.viewmodel.LauncherViewModel
import kotlinx.coroutines.delay

@Composable
fun LauncherPage(
    viewModel: LauncherViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.label_welcome_message, stringResource(R.string.app_name)),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 44.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                lineHeight = 60.sp
            )
        }
    }
    LaunchedEffect(true) {
        delay(3000L)
        val intent = if (viewModel.gotoWizard) {
            Intent(context, WizardActivity::class.java)
        } else {
            Intent(context, MainActivity::class.java)
        }
        context.startActivity(intent)
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview_LauncherPage() {
    ParkingTheme {
        LauncherPage()
    }
}
