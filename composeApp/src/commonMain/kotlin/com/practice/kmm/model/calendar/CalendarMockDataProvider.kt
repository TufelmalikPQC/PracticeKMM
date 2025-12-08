package com.practice.kmm.model.calendar

import com.practice.kmm.model.data.Task
import com.practice.kmm.model.enums.TaskCategory
import com.practice.kmm.uiToolKit.DayItem
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.plus

/**
 * Provides mock data for the Calendar screen.
 */
object CalendarMockDataProvider {

    /**
     * Generates a list of week days starting from the given date.
     *
     * @param startDate The first day of the week
     * @param selectedDate The currently selected date
     * @return List of DayItem for the week
     */
    fun generateWeekDays(startDate: LocalDate, selectedDate: LocalDate): List<DayItem> {
        return (0..6).map { offset ->
            val date = startDate.plus(offset, DateTimeUnit.DAY)
            DayItem(
                date = date,
                dayOfWeek = date.dayOfWeek,
                isSelected = date == selectedDate
            )
        }
    }

    /**
     * Returns a list of mock tasks for the Calendar screen.
     */
    fun getMockTasks(): List<Task> {
        val now = LocalDateTime(2020, 10, 4, 12, 0, 0)
        return listOf(
            Task(
                id = "1",
                name = "Design Changes",
                date = LocalDate(2020, 10, 4),
                startTime = LocalTime(13, 22),
                endTime = LocalTime(15, 20),
                description = "Update the UI design",
                category = TaskCategory.Design,
                createdAt = now
            ),
            Task(
                id = "2",
                name = "Design Changes",
                date = LocalDate(2020, 10, 4),
                startTime = LocalTime(14, 0),
                endTime = LocalTime(16, 0),
                description = "Review mockups",
                category = TaskCategory.Design,
                createdAt = now
            ),
            Task(
                id = "3",
                name = "Design Changes",
                date = LocalDate(2020, 10, 4),
                startTime = LocalTime(10, 0),
                endTime = LocalTime(12, 0),
                description = "Finalize designs",
                category = TaskCategory.Design,
                createdAt = now
            ),
            Task(
                id = "4",
                name = "Design Changes",
                date = LocalDate(2020, 10, 4),
                startTime = LocalTime(16, 30),
                endTime = LocalTime(18, 0),
                description = "Present to team",
                category = TaskCategory.Meeting,
                createdAt = now
            )
        )
    }
}
