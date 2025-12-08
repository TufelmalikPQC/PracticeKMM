package com.practice.kmm.model.home

import com.practice.kmm.model.data.Project
import kotlinx.datetime.LocalDate

/**
 * Provides mock data for the Home screen.
 */
object HomeMockDataProvider {

    /**
     * Returns a list of mock projects for display.
     */
    fun getMockProjects(): List<Project> {
        return listOf(
            Project(
                id = "1",
                name = "Project 1",
                title = "Front-End Development",
                date = LocalDate(2020, 10, 20)
            ),
            Project(
                id = "2",
                name = "Project 2",
                title = "Back-End Development",
                date = LocalDate(2020, 10, 24)
            ),
            Project(
                id = "3",
                name = "Project 3",
                title = "Mobile Development",
                date = LocalDate(2020, 10, 28)
            )
        )
    }

    /**
     * Returns a list of mock tasks for the Home screen.
     */
    fun getMockTasks(): List<com.practice.kmm.model.data.Task> {
        val now = kotlinx.datetime.LocalDateTime(2020, 10, 4, 12, 0, 0)
        return listOf(
            com.practice.kmm.model.data.Task(
                id = "1",
                name = "Design Changes",
                date = LocalDate(2020, 10, 4),
                startTime = kotlinx.datetime.LocalTime(13, 22),
                endTime = kotlinx.datetime.LocalTime(15, 20),
                description = "Update the UI design",
                category = com.practice.kmm.model.enums.TaskCategory.Design,
                createdAt = now
            ),
            com.practice.kmm.model.data.Task(
                id = "2",
                name = "Design Changes",
                date = LocalDate(2020, 10, 4),
                startTime = kotlinx.datetime.LocalTime(14, 0),
                endTime = kotlinx.datetime.LocalTime(16, 0),
                description = "Review mockups",
                category = com.practice.kmm.model.enums.TaskCategory.Design,
                createdAt = now
            )
        )
    }
}
