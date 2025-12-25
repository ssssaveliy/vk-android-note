package ru.justneedcoffee.zennotes.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.justneedcoffee.zennotes.R
import ru.justneedcoffee.zennotes.ui.theme.ColorMain
import ru.justneedcoffee.zennotes.ui.theme.ColorSecondary

@Composable
fun ErrorScreen(
    message: String,
    onRetryClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorSecondary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_start_flowers),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.25f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.error_message),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = message,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = onRetryClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorMain,
                    contentColor = ColorSecondary
                )
            ) {
                Text(text = stringResource(R.string.error_retry))
            }
        }
    }
}
