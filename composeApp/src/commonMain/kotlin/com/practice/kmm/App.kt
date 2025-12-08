package com.practice.kmm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.kmm.modules.calendar.ui.CalendarScreen
import com.practice.kmm.modules.home.ui.HomeScreen
import com.practice.kmm.modules.task.ui.CreateTaskScreen
import com.practice.kmm.theme.TaskManagerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Main App composable with navigation setup.
 * Entry point for the application UI.
 */
@Composable
@Preview
fun App() {
    TaskManagerTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Screen.Home,
            modifier = Modifier.fillMaxSize()
        ) {
            composable<Screen.Home> {
                HomeScreen(
                    onNavigateToCalendar = {
                        navController.navigate(Screen.Calendar)
                    }
                )
            }

            composable<Screen.Calendar> {
                CalendarScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home) {
                            popUpTo(Screen.Home) { inclusive = true }
                        }
                    },
                    onNavigateToCreateTask = {
                        navController.navigate(Screen.CreateTask)
                    }
                )
            }

            composable<Screen.CreateTask> {
                CreateTaskScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onTaskCreated = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}