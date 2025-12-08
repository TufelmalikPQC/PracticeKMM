package com.practice.kmm.modules.home.ui

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.practice.kmm.model.data.Project
import com.practice.kmm.model.enums.HomeFilter
import com.practice.kmm.model.home.HomeMockDataProvider
import com.practice.kmm.theme.Dimensions
import com.practice.kmm.theme.textSecondary
import com.practice.kmm.uiToolKit.BottomNavDestination
import com.practice.kmm.uiToolKit.BottomNavigationBar
import com.practice.kmm.uiToolKit.FilterChip
import com.practice.kmm.uiToolKit.ProjectCard
import com.practice.kmm.uiToolKit.TaskCard
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.cd_menu_icon
import practicekmm.composeapp.generated.resources.cd_profile_icon
import practicekmm.composeapp.generated.resources.label_completed
import practicekmm.composeapp.generated.resources.label_in_progress
import practicekmm.composeapp.generated.resources.label_my_tasks
import practicekmm.composeapp.generated.resources.msg_greeting
import practicekmm.composeapp.generated.resources.msg_greeting_subtitle
import practicekmm.composeapp.generated.resources.msg_task_clicked
import practicekmm.composeapp.generated.resources.title_progress

/**
 * Home screen composable.
 *
 * @param onNavigateToCalendar Callback to navigate to calendar screen
 * @param modifier Modifier for the screen
 */
@Composable
fun HomeScreen(
    onNavigateToCalendar: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedFilter by remember { mutableStateOf(HomeFilter.MyTasks) }
    var currentNavDestination by remember { mutableStateOf(BottomNavDestination.Home) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Mock data from provider
    val projects = remember { HomeMockDataProvider.getMockProjects() }
    val tasks = remember { HomeMockDataProvider.getMockTasks() }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            BottomNavigationBar(
                currentDestination = currentNavDestination,
                onDestinationSelected = { destination ->
                    currentNavDestination = destination
                    if (destination == BottomNavDestination.Calendar) {
                        onNavigateToCalendar()
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(vertical = Dimensions.spacing16)
        ) {
            // Header with greeting (aligned)
            item {
                HomeHeaderWithGreeting(userName = "Rohan")
            }

            // Filter tabs
            item {
                FilterTabsRow(
                    selectedFilter = selectedFilter,
                    onFilterSelected = { selectedFilter = it }
                )
            }

            // Project cards carousel
            item {
                ProjectCarousel(
                    projects = projects,
                    onProjectClick = { /* Handle project click */ }
                )
            }

            // Progress section header
            item {
                Text(
                    text = stringResource(Res.string.title_progress),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(
                        horizontal = Dimensions.spacing16,
                        vertical = Dimensions.spacing12
                    )
                )
            }

            // Task cards
            items(tasks) { task ->
                val taskClickedMessage = stringResource(Res.string.msg_task_clicked, task.name)
                TaskCard(
                    task = task,
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(taskClickedMessage)
                        }
                    },
                    onMenuClick = { /* Handle menu click */ },
                    modifier = Modifier.padding(
                        horizontal = Dimensions.spacing16,
                        vertical = Dimensions.spacing6
                    )
                )
            }
        }
    }
}

/**
 * Combined header with menu icon, profile, and greeting - aligned properly
 */
@Composable
private fun HomeHeaderWithGreeting(userName: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.spacing16)
    ) {
        // Top row with menu and profile
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Open menu */ },
                modifier = Modifier.size(Dimensions.iconSizeXLarge)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(Res.string.cd_menu_icon),
                    tint = MaterialTheme.colorScheme.textSecondary
                )
            }

            Box(
                modifier = Modifier
                    .size(Dimensions.iconSizeLarge)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(Res.string.cd_profile_icon),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(Dimensions.spacing8))

        // Greeting - aligned with menu icon
        Text(
            text = stringResource(Res.string.msg_greeting, userName),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(Dimensions.spacing4))
        Text(
            text = stringResource(Res.string.msg_greeting_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.textSecondary
        )
    }
}

@Composable
private fun FilterTabsRow(
    selectedFilter: HomeFilter,
    onFilterSelected: (HomeFilter) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimensions.spacing12),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.spacing8),
        contentPadding = PaddingValues(horizontal = Dimensions.spacing16)
    ) {
        item {
            FilterChip(
                text = stringResource(Res.string.label_my_tasks),
                selected = selectedFilter == HomeFilter.MyTasks,
                onClick = { onFilterSelected(HomeFilter.MyTasks) }
            )
        }
        item {
            FilterChip(
                text = stringResource(Res.string.label_in_progress),
                selected = selectedFilter == HomeFilter.InProgress,
                onClick = { onFilterSelected(HomeFilter.InProgress) }
            )
        }
        item {
            FilterChip(
                text = stringResource(Res.string.label_completed),
                selected = selectedFilter == HomeFilter.Completed,
                onClick = { onFilterSelected(HomeFilter.Completed) }
            )
        }
    }
}

@Composable
private fun ProjectCarousel(
    projects: List<Project>,
    onProjectClick: (Project) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { projects.size })

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = Dimensions.spacing32),
            pageSpacing = Dimensions.spacing12
        ) { page ->
            ProjectCard(
                project = projects[page],
                onClick = { onProjectClick(projects[page]) }
            )
        }

        // Rectangle page indicator
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimensions.spacing16),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(projects.size) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(horizontal = Dimensions.spacing2)
                        .width(if (isSelected) Dimensions.indicatorWidthActive else Dimensions.indicatorWidthInactive)
                        .height(Dimensions.indicatorHeight)
                        .clip(RoundedCornerShape(Dimensions.spacing2))
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.outlineVariant
                        )
                )
            }
        }
    }
}
