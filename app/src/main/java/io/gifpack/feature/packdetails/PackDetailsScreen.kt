package io.gifpack.feature.packdetails

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.compose.LocalImageLoader
import coil.request.ImageRequest
import io.gifpack.R
import io.gifpack.util.Image

//TODO: Implement different UI state handling loading/error
//      Implement handling for null fields
//      Implement MotionLayout (or similar) interaction
@ExperimentalFoundationApi
@Composable
fun PackDetailsScreen(viewModel: PackDetailsViewModel, onBackButtonPressed: () -> Unit) {

    val pack = viewModel.pack.observeAsState()
    val defaultGradientColor = colorResource(R.color.pack_details_default_gradient_start_color)
    var gradientStartColor by remember { mutableStateOf(defaultGradientColor) }

    LocalImageLoader.current.enqueue(
        getBannerImageRequestForPalette(LocalContext.current, pack.value?.imageUrl) { result ->
            Palette.from(result.toBitmap()).generate { bannerPalette ->
                bannerPalette ?: return@generate
                gradientStartColor = Color(bannerPalette.getMutedColor(defaultGradientColor.value.toInt()))
            }
        }
    )

    ConstraintLayout(
        Modifier
            .background(
                Brush.verticalGradient(
                    Pair(GRADIENT_START_COLOR_BEGIN, gradientStartColor),
                    Pair(GRADIENT_END_COLOR_BEGIN, colorResource(R.color.pack_details_gradient_end_color))
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
                .size(dimensionResource(R.dimen.pack_details_banner_image_size))
                .padding(top = dimensionResource(R.dimen.pack_details_banner_image_margin_top))
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
                .padding(
                    start = dimensionResource(R.dimen.horizontal_guideline),
                    top = dimensionResource(R.dimen.pack_details_title_margin_top)
                )
        )
        Text(
            text = pack.value?.description ?: "",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .constrainAs(packDescriptionTV) {
                    start.linkTo(parent.start)
                    top.linkTo(packNameTV.bottom)
                }
                .padding(
                    start = dimensionResource(R.dimen.horizontal_guideline),
                    top = dimensionResource(R.dimen.pack_details_description_margin_top)
                )
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(GIFS_LIST_COLUMNS_COUNT),
            contentPadding = PaddingValues(horizontal = dimensionResource(R.dimen.horizontal_guideline)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.pack_details_item_spacing)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.pack_details_item_spacing)),
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.pack_details_items_list_margin_top))
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

private fun getBannerImageRequestForPalette(context: Context, imageUrl: String?, successCallback: (Drawable) -> Unit): ImageRequest =
    ImageRequest.Builder(context)
        .data(imageUrl)
        .allowHardware(false)
        .target { result -> successCallback(result) }
        .build()

private const val GRADIENT_START_COLOR_BEGIN = 0f
private const val GRADIENT_END_COLOR_BEGIN = 0.4f
private const val GIFS_LIST_COLUMNS_COUNT = 2