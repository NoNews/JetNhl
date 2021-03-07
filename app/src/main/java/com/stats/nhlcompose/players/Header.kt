package com.stats.nhlcompose.players

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stats.nhlcompose.core_ui.UiElement

@Composable
fun Header(model: HeaderUiModel) {

    Text(
        text = model.text,
        modifier = Modifier.padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
    )

}

data class HeaderUiModel(val text: String) : UiElement