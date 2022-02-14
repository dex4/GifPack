package io.gifpack.feature.browse.itemslist.header

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import org.joda.time.DateTime

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = getGreetingForTimeOfDay(),
        fontWeight = FontWeight.SemiBold,
        style = MaterialTheme.typography.h6,
        modifier = modifier
    )
}

private fun getGreetingForTimeOfDay(): String {
    val date = DateTime.now()
    val hourOfDay = date.hourOfDay
    return when {
        hourOfDay < 12 -> "Good morning!"
        hourOfDay < 15 -> "Good day!"
        hourOfDay < 19 -> "Good afternoon!"
        else -> "Good evening!"
    }
}