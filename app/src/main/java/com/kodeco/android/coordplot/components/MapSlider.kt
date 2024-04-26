package com.kodeco.android.coordplot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.R
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun MapSlider(modifier: Modifier = Modifier, title: String, percent: Float, onPercentageChange: (Float) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(start = 8.dp)
                .width(120.dp)
        )
        Slider(
            value = percent,
            onValueChange = onPercentageChange,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapSliderPreview() {
    MyApplicationTheme {
        MapSlider(
            title = stringResource(R.string.x_axis, 100),
            percent = 0.5f,
            onPercentageChange = {}
        )
    }
}
