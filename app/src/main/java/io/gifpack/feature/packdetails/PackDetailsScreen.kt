package io.gifpack.feature.packdetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.compose.LocalImageLoader
import coil.request.ImageRequest
import io.gifpack.R
import io.gifpack.core.data.GifDetails
import io.gifpack.util.AnimatedImage
import io.gifpack.util.Image

@ExperimentalFoundationApi
@Composable
fun PackDetailsScreen(viewModel: PackDetailsViewModel, onBackButtonPressed: () -> Unit = {}) {
    val pack = viewModel.pack.observeAsState()
    val mockGifsList = mutableListOf<GifDetails>().apply {
        (0..10).forEach {
            add(GifDetails(it, "https://picsum.photos/id/${it}/800/400", "Moment $it"))
        }
    }
    var gradientStartColor by remember { mutableStateOf(Color(0, 0, 0)) }
    LocalImageLoader.current.enqueue(
        ImageRequest.Builder(LocalContext.current)
            .data(pack.value?.imageUrl)
            .allowHardware(false)
            .target { result ->
                Palette.from(result.toBitmap()).generate {
                    it ?: return@generate
                    gradientStartColor = Color(it.getMutedColor(0))
                }
            }
            .build()
    )
    ConstraintLayout(
        Modifier
            .background(
                Brush.verticalGradient(
                    Pair(0f, gradientStartColor),
                    Pair(0.4f, colorResource(R.color.black))
                )
            )
            .fillMaxSize()
    ) {

        val (backNavigationIB, bannerIV, packNameTV, packDescriptionTV, gifsList) = createRefs()

        IconButton(onClick = { onBackButtonPressed() }, Modifier.constrainAs(backNavigationIB) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }) {
            Icon(painter = painterResource(R.drawable.ic_back), contentDescription = null)
        }
        Image(pack.value?.imageUrl,
            Modifier
                .size(200.dp, 200.dp)
                .padding(top = dimensionResource(R.dimen.spacing_delta))
                .constrainAs(bannerIV) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = pack.value?.name ?: "",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .constrainAs(packNameTV) {
                    start.linkTo(parent.start)
                    top.linkTo(bannerIV.bottom)
                }
                .padding(start = dimensionResource(id = R.dimen.horizontal_guideline), top = dimensionResource(id = R.dimen.spacing_delta))
        )
        Text(
            text = pack.value?.description ?: "",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .constrainAs(packDescriptionTV) {
                    start.linkTo(parent.start)
                    top.linkTo(packNameTV.bottom)
                }
                .padding(start = dimensionResource(id = R.dimen.horizontal_guideline), top = dimensionResource(id = R.dimen.spacing_alpha))
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(gifsList) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(packDescriptionTV.bottom)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
        ) {
            items(pack.value?.gifsList ?: listOf()) { gifDetails ->
                GifContainer(gifDetails)
            }
        }
    }
}

@Composable
fun GifContainer(gifDetails: GifDetails = GifDetails(1, "https://picsum.photos/id/52/200/200", "Gravity :(")) {
    Box(
        modifier = Modifier
            .height(110.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(R.dimen.browse_recent_pack_corner_radius)))
    ) {
        AnimatedImage(
            url = gifDetails.url,
            modifier = Modifier.matchParentSize()
        )
        Text(
            text = gifDetails.name ?: "",
            color = colorResource(R.color.white),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            colorResource(R.color.transparent),
                            colorResource(R.color.black)
                        )
                    )
                )
                .padding(dimensionResource(R.dimen.spacing_beta))
        )
    }
}