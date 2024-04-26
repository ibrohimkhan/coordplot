package com.kodeco.android.coordplot.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.R
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun PlotSurfaceScreen() {
    var xPercentage by remember { mutableFloatStateOf(0.5f) }
    var yPercentage by remember { mutableFloatStateOf(0.5f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Map(xPercentage, yPercentage)
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        Slider(
            value = xPercentage,
            onValueChange = { xPercentage = it }
        )
        Slider(
            value = yPercentage,
            onValueChange = { yPercentage = it }
        )
    }
}

@Composable
fun Map(xPercent: Float, yPercent: Float, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(300.dp)
            .background(color = Color.Blue)
    ) {
        Box(
            modifier = Modifier
                .offset((xPercent * 300 - 18).dp, (yPercent * 300 - 18).dp)
                .paint(painter = painterResource(id = R.drawable.star))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}

@Preview(showBackground = true)
@Composable
fun PlotSurfaceScreenPreview() {
    MyApplicationTheme {
        PlotSurfaceScreen()
    }
}