package com.example.core.ui.toasts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.ui.theme.mTypography
import kotlinx.coroutines.delay

@Composable
fun ToastMessage(
    text: String,
    success: Boolean,
    onTimeEnds: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(5000)
        onTimeEnds()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (!success) Color(0xffF08080) else Color(0xff00FA9A))
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if(success) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_check_circle),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cross_circle),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Text(
                text = text,
                style = mTypography.labelSmall,
                color = Color.White
            )
        }
    }
}