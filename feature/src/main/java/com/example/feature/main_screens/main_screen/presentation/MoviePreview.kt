package com.example.feature.main_screens.main_screen.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.core.data.models.latest_movies_responce.Movie
import com.example.core.ui.theme.mColors
import com.example.core.ui.theme.mShapes
import com.example.core.ui.theme.mTypography

@Composable
fun MoviePreviewUi(
    moviePreview: Movie
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500/${moviePreview.posterPath}",
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.3f)
                .clip(mShapes.small),
            contentScale = ContentScale.Crop,
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = moviePreview.title,
                style = mTypography.bodyLarge,
                color = mColors.primary,
                maxLines = 2
            )

            Text(
                text = moviePreview.voteAverage.toString(),
                style = mTypography.bodyMedium,
                color = mColors.secondary,
            )

            Text(
                text = moviePreview.overview,
                style = mTypography.bodySmall.copy(
                    lineBreak = LineBreak.Paragraph,
                    hyphens = Hyphens.Auto
                ),
                color = mColors.tertiary,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}