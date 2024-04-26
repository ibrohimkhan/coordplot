package com.kodeco.android.coordplot.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.R
import com.kodeco.android.coordplot.components.Map
import com.kodeco.android.coordplot.components.MapSlider
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
        MapSlider(
            title = stringResource(R.string.x_axis, (xPercentage * 100).toInt()),
            percent = xPercentage,
            onPercentageChange = { xPercentage = it }
        )
        MapSlider(
            title = stringResource(R.string.y_axis, (yPercentage * 100).toInt()),
            percent = yPercentage,
            onPercentageChange = { yPercentage = it }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlotSurfaceScreenPreview() {
    MyApplicationTheme {
        PlotSurfaceScreen()
    }
}
