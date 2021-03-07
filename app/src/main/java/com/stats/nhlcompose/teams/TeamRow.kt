package com.stats.nhlcompose.teams

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun TeamCard(team: TeamCardUiModel, onClickTeam: () -> Unit) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = onClickTeam)
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = team.drawableRes),
                contentDescription = team.name,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .padding(4.dp)
                    .size(64.dp)
            )

            Text(
                text = team.name,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

data class TeamCardUiModel(
    val name: String,
    val subtitle: String,
    @DrawableRes val drawableRes: Int
)