package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.Neutral400
import com.practice.kmm.theme.Neutral700
import com.practice.kmm.theme.Purple100
import com.practice.kmm.theme.Purple600
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate

/**
 * Data class representing a single day item in the week calendar.
 */
data class DayItem(
    val date: LocalDate,
    val dayOfWeek: DayOfWeek,
    val isSelected: Boolean = false
)

/**
 * Week calendar component showing a horizontal row of days.
 *
 * @param days List of day items to display
 * @param onDaySelected Callback when a day is selected
 * @param modifier Modifier for the component
 */
@Composable
fun WeekCalendar(
    days: List<DayItem>,
    onDaySelected: (LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.weekCalendarHeight),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        days.forEach { dayItem ->
            DayItemView(
                dayItem = dayItem,
                onClick = { onDaySelected(dayItem.date) }
            )
        }
    }
}

@Composable
private fun DayItemView(
    dayItem: DayItem,
    onClick: () -> Unit
) {
    val backgroundColor = if (dayItem.isSelected) Purple100 else Color.Transparent
    val textColor = if (dayItem.isSelected) Purple600 else Neutral700
    val dayOfWeekColor = if (dayItem.isSelected) Purple600 else Neutral400

    Column(
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(Dimensions.spacing8),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = getDayShortName(dayItem.dayOfWeek),
            style = MaterialTheme.typography.labelSmall,
            color = dayOfWeekColor
        )
        Spacer(modifier = Modifier.height(Dimensions.spacing4))
        Text(
            text = dayItem.date.dayOfMonth.toString(),
            style = MaterialTheme.typography.titleMedium,
            color = textColor
        )
    }
}

private fun getDayShortName(dayOfWeek: DayOfWeek): String {
    return when (dayOfWeek) {
        DayOfWeek.MONDAY -> "Mo"
        DayOfWeek.TUESDAY -> "Tu"
        DayOfWeek.WEDNESDAY -> "We"
        DayOfWeek.THURSDAY -> "Th"
        DayOfWeek.FRIDAY -> "Fr"
        DayOfWeek.SATURDAY -> "Sa"
        DayOfWeek.SUNDAY -> "Su"
        else -> ""
    }
}
