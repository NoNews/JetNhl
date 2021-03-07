package com.stats.nhlcompose.players

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.stats.nhlcompose.core_ui.UiElement
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun PlayerRow(model: PlayerRowUiModel, onClick: (PlayerRowUiModel) -> Unit) {

    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                onClick.invoke(model)
            }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        CoilImage(
            data = model.imageUrl,
            contentDescription = "Player ${model.name} image",
            requestBuilder = {
                transformations(CircleCropTransformation())
            },
            modifier = Modifier.size(56.dp)
        ) {

        }
        Column(
            Modifier.align(Alignment.CenterVertically)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = model.name,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = model.position,
                style = MaterialTheme.typography.body2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


data class PlayerRowUiModel(
    val name: String,
    val position: String,
    val imageUrl: String
) : UiElement