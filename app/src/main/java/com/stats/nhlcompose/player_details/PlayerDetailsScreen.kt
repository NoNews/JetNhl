package com.stats.nhlcompose.player_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.transform.CircleCropTransformation
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PlayerDetailsScreen(
    inputData: PlayerDetailsScreenContract.InputData,
    viewModel: PlayerDetailsViewModel = viewModel(factory = PlayerDetailsViewModelFactory(inputData))
) {

    Column {

        Box(
            Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) {
            CoilImage(
                data = "https://cms.nhl.bamgrid.com/images/actionshots/8479318@2x.jpg",
                contentDescription = "Player image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(154.dp),
                contentScale = ContentScale.FillBounds
            )
            CoilImage(
                data = "https://sportshub.cbsistatic.com/i/r/2020/02/13/15f08284-1ecb-48a4-bb64-874726fa1879/thumbnail/1200x675/98e24b912cd094134c686f7ceee2e422/gettyimages-1193579487.jpg",
                contentDescription = "Player image",
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.BottomCenter)
            )
        }

        Text(
            text = "Connor MCDavid",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

    }


}