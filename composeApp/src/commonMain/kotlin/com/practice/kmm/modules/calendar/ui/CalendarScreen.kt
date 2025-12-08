package com.practice.kmm.modules.calendar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.practice.kmm.model.calendar.CalendarMockDataProvider
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.GradientPurpleEnd
import com.practice.kmm.theme.GradientPurpleStart
import com.practice.kmm.theme.textSecondary
import com.practice.kmm.uiToolKit.BottomNavDestination
import com.practice.kmm.uiToolKit.BottomNavigationBar
import com.practice.kmm.uiToolKit.TaskCard
import com.practice.kmm.uiToolKit.WeekCalendar
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.action_add_task
import practicekmm.composeapp.generated.resources.cd_back_button
import practicekmm.composeapp.generated.resources.cd_search_icon
import practicekmm.composeapp.generated.resources.msg_task_clicked
import practicekmm.composeapp.generated.resources.title_tasks

/**
 * Calendar screen composable showing week view and task list.
 *
 * @param onNavigateBack Callback to navigate back
 * @param onNavigateToHome Callback to navigate to home
 * @param onNavigateToCreateTask Callback to navigate to create task screen
 * @param modifier Modifier for the screen
 */
@Composable
fun CalendarScreen(
    onNavigateBack: () -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToCreateTask: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedDate by remember { mutableStateOf(LocalDate(2020, 10, 4)) }
    var currentNavDestination by remember { mutableStateOf(BottomNavDestination.Calendar) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Generate week days from provider
    val weekDays = remember(selectedDate) {
        CalendarMockDataProvider.generateWeekDays(LocalDate(2020, 10, 3), selectedDate)
    }

    // Mock tasks from provider
    val tasks = remember { CalendarMockDataProvider.getMockTasks() }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            BottomNavigationBar(
                currentDestination = currentNavDestination,
                onDestinationSelected = { destination ->
                    currentNavDestination = destination
                    when (destination) {
                        BottomNavDestination.Home -> onNavigateToHome()
                        else -> {}
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Header
            CalendarHeader(
                monthYear = "Oct, 2020",
                onBackClick = onNavigateBack,
                onSearchClick = { /* Handle search */ },
                onAddTaskClick = onNavigateToCreateTask
            )

            // Week calendar
            WeekCalendar(
                days = weekDays,
                onDaySelected = { date ->
                    selectedDate = date
                },
                modifier = Modifier.padding(vertical = Dimensions.spacing8)
            )

            Spacer(modifier = Modifier.height(Dimensions.spacing16))

            // Bottom card with Tasks section
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(
                    topStart = Dimensions.cornerXLarge,
                    topEnd = Dimensions.cornerXLarge
                ),
                shadowElevation = Dimensions.cardElevationHigh
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Tasks title with proper padding
                    Text(
                        text = stringResource(Res.string.title_tasks),
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(
                            start = Dimensions.spacing24,
                            end = Dimensions.spacing24,
                            top = Dimensions.spacing24,
                            bottom = Dimensions.spacing16
                        )
                    )

                    // Task list
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            horizontal = Dimensions.spacing24,
                            vertical = Dimensions.spacing8
                        ),
                        verticalArrangement = Arrangement.spacedBy(Dimensions.spacing12)
                    ) {
                        items(tasks) { task ->
                            val taskClickedMessage = stringResource(Res.string.msg_task_clicked, task.name)
                            TaskCard(
                                task = task,
                                onClick = {
                                    scope.launch {
                                        snackbarHostState.showSnackbar(taskClickedMessage)
                                    }
                                },
                                onMenuClick = { /* Handle menu */ }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CalendarHeader(
    monthYear: String,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onAddTaskClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.spacing8, vertical = Dimensions.spacing8),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(Res.string.cd_back_button),
                tint = MaterialTheme.colorScheme.textSecondary
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onSearchClick) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(Res.string.cd_search_icon),
                tint = MaterialTheme.colorScheme.textSecondary
            )
        }
    }

    // Month title and Add Task button
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.spacing16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = monthYear,
            style = MaterialTheme.typography.headlineLarge
        )

        val gradient = Brush.horizontalGradient(
            colors = listOf(GradientPurpleStart, GradientPurpleEnd)
        )

        Button(
            onClick = onAddTaskClick,
            shape = RoundedCornerShape(Dimensions.cornerFull),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .background(gradient, RoundedCornerShape(Dimensions.cornerFull))
                    .padding(horizontal = Dimensions.spacing20, vertical = Dimensions.spacing10)
            ) {
                Text(
                    text = stringResource(Res.string.action_add_task),
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White
                )
            }
        }
    }
}
